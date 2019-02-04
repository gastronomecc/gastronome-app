package com.kevintoh0305gmail.gastronome;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.core.app.ActivityCompat;
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

public class BottomSheetDrinkLogFragment extends BottomSheetDialogFragment {

    EditText txtDrinkName, txtCalories;
    TextView tvDate;
    ImageButton btnAddImage, btnAddDrinkLog;
    Calendar calendar;
    Date currentDay;
    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;

    final int REQUEST_CODE_GALLERY = 999;

    public BottomSheetDrinkLogFragment() {
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
        return inflater.inflate(R.layout.bottom_sheet_drinklog, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtDrinkName = view.findViewById(R.id.etLogDrinkName);
        txtCalories = view.findViewById(R.id.etLogDrinkCalories);
        tvDate = view.findViewById(R.id.tvBottomSheetDrinkDate);
        btnAddImage = view.findViewById(R.id.btnAddImage2);
        btnAddDrinkLog = view.findViewById(R.id.btnAddDrinkLog);
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

        btnAddDrinkLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String drinkname = txtDrinkName.getText().toString();
                String calories = txtCalories.getText().toString();
                if (drinkname.isEmpty()) { //Check whether the email textbox is empty
                    txtDrinkName.setError("Username is required");
                    txtDrinkName.requestFocus();
                    return; //Do not allow user to authenticate
                }

                if (calories.isEmpty()) { //Check whether the password text is empty
                    txtCalories.setError("Password is required");
                    txtCalories.requestFocus();
                    return; //Do not allow user to authenticate
                }
                database.getReference("UserDrinkLog").child(firebaseAuth.getCurrentUser().getUid()).child(drinkname).setValue(new DrinkLog(drinkname,Integer.parseInt(calories)));
                dismiss();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else{
                Toast.makeText(getContext(), "The app does not have permissions to access your gallery.",Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
