package com.kevintoh0305gmail.gastronome;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

public class BottomSheetFoodLogFragment extends BottomSheetDialogFragment {


    EditText txtFoodName, txtCalories;
    TextView tvDate;
    Calendar calendar;
    Date currentDay;
    ImageButton btnAddImage, btnAddFoodLog;
    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;


    final int REQUEST_CODE_GALLERY = 999;

    public BottomSheetFoodLogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bottom_sheet_foodlog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtFoodName = view.findViewById(R.id.etLogFoodName);
        txtCalories = view.findViewById(R.id.etLogFoodCalories);
        tvDate = view.findViewById(R.id.tvBottomSheetDate);
        btnAddImage = view.findViewById(R.id.btnAddImage);
        btnAddFoodLog = view.findViewById(R.id.btnAddFoodlog);
        calendar = Calendar.getInstance();
        currentDay = calendar.getTime();
        database = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        DateFormat dayFormat = new SimpleDateFormat("EEEE");
        DateFormat dateFormat = new SimpleDateFormat("dd MMM");
        tvDate.setText(dayFormat.format(currentDay)+", "+dateFormat.format(currentDay));
        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
        });

        btnAddFoodLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodname = txtFoodName.getText().toString();
                String calories = txtCalories.getText().toString();
                if (foodname.isEmpty()) { //Check whether the email textbox is empty
                    txtFoodName.setError("Username is required");
                    txtFoodName.requestFocus();
                    return; //Do not allow user to authenticate
                }

                if (calories.isEmpty()) { //Check whether the password text is empty
                    txtCalories.setError("Password is required");
                    txtCalories.requestFocus();
                    return; //Do not allow user to authenticate
                }
                database.getReference("UserFoodLog").child(firebaseAuth.getCurrentUser().getUid()).child(foodname).setValue(new FoodLog(foodname,Integer.parseInt(calories)));
                dismiss();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            try {
                Uri uri = data.getData();
                InputStream inputStream = getContext().getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                btnAddImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "File not found.",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getContext(), "You haven't picked an image.",Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
