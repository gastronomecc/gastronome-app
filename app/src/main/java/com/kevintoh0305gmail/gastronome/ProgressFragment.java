package com.kevintoh0305gmail.gastronome;

import android.icu.util.LocaleData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProgressFragment extends Fragment {

    TextView tvDate, tvCal;
    ImageButton btnRight, btnLeft;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference ref;
    int totalCal;
    Date currentDay;
    Calendar cal;
    SimpleDateFormat dayFormat;
    String day;
    int dayInNo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cal = Calendar.getInstance();
        currentDay = cal.getTime();
        dayFormat = new SimpleDateFormat("EEEE");

        Log.d("CurrentDay: ", dayFormat.format(currentDay));
        Log.d("CurrentDaySub: ", dayFormat.format(currentDay).substring(0,2));

        day = dayFormat.format(currentDay).substring(0,2);
        if (day.equals("Su")) {
            dayInNo = 7;
        } else if (day.equals("Mo")) {
            dayInNo = 1;
        } else if (day.equals("Tu")) {
            dayInNo = 2;
        } else if (day.equals("We")) {
            dayInNo = 3;
        } else if (day.equals("Th")) {
            dayInNo = 4;
        } else if (day.equals("Fr")) {
            dayInNo = 5;
        } else if (day.equals("Sa")) {
            dayInNo = 6;
        } else {
            dayInNo = 4;
        }

        tvDate = view.findViewById(R.id.tvDate);
        tvCal = view.findViewById(R.id.tvTotalCal);
        btnLeft = view.findViewById(R.id.imgBtnLeft);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dayInNo == 1) {
                    dayInNo = 7;
                } else {
                    dayInNo -= 1;
                }
                callData();
            }
        });

        btnRight = view.findViewById(R.id.imgBtnRight);
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dayInNo == 7) {
                    dayInNo = 1;
                } else {
                    dayInNo ++;
                }
                callData();
            }
        });
        callData();
    }

    public void callData() {
        ref = database.getInstance().getReference("ZLogs").child(mAuth.getInstance().getCurrentUser().getUid());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:  dataSnapshot.getChildren()) {
                    Logs log = ds.getValue(Logs.class);
                    if (log.day.equals(String.valueOf(dayInNo))) {// MUST GET CURRENT DAY {
                        totalCal += log.getCalories();
                    }
                }
                tvCal.setText("" + totalCal);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("The read failed: " , "" + databaseError.getCode());
            }
        });
    }
}
