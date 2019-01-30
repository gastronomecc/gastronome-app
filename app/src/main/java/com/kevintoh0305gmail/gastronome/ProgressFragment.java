package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProgressFragment extends Fragment {


    BarChart chart;
    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;
//    ArrayList<Logs> mondayList = new ArrayList<>();
//    ArrayList<Logs> tuesdayList = new ArrayList<>();
//    ArrayList<Logs> wednesdayList = new ArrayList<>();
//    ArrayList<Logs> thursdayList = new ArrayList<>();
//    ArrayList<Logs> fridayList = new ArrayList<>();
//    ArrayList<Logs> saturdayList = new ArrayList<>();
//    ArrayList<Logs> sundayList = new ArrayList<>();
    DatabaseReference reference;
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
        return inflater.inflate(R.layout.fragment_graph, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = view.findViewById(R.id.progressPageBarChart);
        database = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        LoadWeeklyLogData();

        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.setMaxVisibleValueCount(50);
        chart.setDrawGridBackground(false);

//        ArrayList<BarEntry> barEntries = new ArrayList<>();
//        barEntries.add(new BarEntry(1, 2040f));
//        barEntries.add(new BarEntry(2, 2144f));
//        barEntries.add(new BarEntry(3, 2812f));
//        barEntries.add(new BarEntry(4, 3342f));
//        barEntries.add(new BarEntry(5, 2732f));
//        barEntries.add(new BarEntry(6, 3232f));
//        barEntries.add(new BarEntry(7, 1323f));
//
//        BarDataSet barDataSet = new BarDataSet(barEntries, "Days");
//        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//
//        BarData data = new BarData(barDataSet);
//        data.setBarWidth(1.0f);
//        chart.setData(data);
        //PlotChart();
    }

    public void LoadWeeklyLogData()
    {
        reference = database.getReference("ZLogs").child(firebaseAuth.getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Logs> mondayList = new ArrayList<>();
                ArrayList<Logs> tuesdayList = new ArrayList<>();
                ArrayList<Logs> wednesdayList = new ArrayList<>();
                ArrayList<Logs> thursdayList = new ArrayList<>();
                ArrayList<Logs> fridayList = new ArrayList<>();
                ArrayList<Logs> saturdayList = new ArrayList<>();
                ArrayList<Logs> sundayList = new ArrayList<>();
                ArrayList<BarEntry> barEntries = new ArrayList<>();
                int mondayCalories = 0;
                int tuesdayCalories = 0;
                int wednesdayCalories = 0;
                int thursdayCalories = 0;
                int fridayCalories = 0;
                int saturdayCalories = 0;
                int sundayCalories = 0;

                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    Logs log = ds.getValue(Logs.class);
                    Log.d("AddProgress", log.day + log.title);
                    if(log.getDay().equals("1")) {
                        mondayList.add(log);
                        Log.d("Progress", log.getDay() + log.title);
                    }
                    if(log.getDay().equals("2")) {
                        tuesdayList.add(log);
                        Log.d("Progress", log.getDay() + log.title);
                    }
                    if(log.getDay().equals("3")) {
                        wednesdayList.add(log);
                        Log.d("Progress", log.getDay() + log.title);
                    }
                    if(log.getDay().equals("4")) {
                        thursdayList.add(log);
                        Log.d("Progress", log.getDay() + log.title);
                    }
                    if(log.getDay().equals("5")) {
                        fridayList.add(log);
                        Log.d("Progress", log.getDay() + log.title);
                    }
                    if(log.getDay().equals("6")) {
                        saturdayList.add(log);
                        Log.d("Progress", log.getDay() + log.title);
                    }
                    if(log.getDay().equals("7")){
                        sundayList.add(log);
                        Log.d("Progress", log.getDay() + log.title);
                    }
                    for (int i  = 0; i < mondayList.size(); i++)
                    {
                        mondayCalories += mondayList.get(i).calories;
                    }
                    for (int i  = 0; i < tuesdayList.size(); i++)
                    {
                        tuesdayCalories += tuesdayList.get(i).calories;
                    }
                    for (int i  = 0; i < wednesdayList.size(); i++)
                    {
                        wednesdayCalories += wednesdayList.get(i).calories;
                    }
                    for (int i  = 0; i < thursdayList.size(); i++)
                    {
                        thursdayCalories += thursdayList.get(i).calories;
                    }
                    for (int i  = 0; i < fridayList.size(); i++)
                    {
                        fridayCalories += fridayList.get(i).calories;
                    }
                    for (int i  = 0; i < saturdayList.size(); i++)
                    {
                        saturdayCalories += saturdayList.get(i).calories;
                    }
                    for (int i  = 0; i < sundayList.size(); i++)
                    {
                        sundayCalories += sundayList.get(i).calories;
                    }
                }
                Log.d("Progress", " "+ tuesdayCalories);
                barEntries.add(new BarEntry(1, mondayCalories));
                barEntries.add(new BarEntry(2, tuesdayCalories));
                barEntries.add(new BarEntry(3, wednesdayCalories));
                barEntries.add(new BarEntry(4, thursdayCalories));
                barEntries.add(new BarEntry(5, fridayCalories));
                barEntries.add(new BarEntry(6, saturdayCalories));
                barEntries.add(new BarEntry(7, sundayCalories));

                BarDataSet barDataSet = new BarDataSet(barEntries, "Days");
                barDataSet.setColors(ColorTemplate.rgb("#F3534A"));
                BarData data = new BarData(barDataSet);
                data.setBarWidth(1.0f);
                chart.setData(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Cancel", "" + databaseError.getCode());
            }
        });

    }

//    public void PlotChart()
//    {
//        int mondayCalories = 0;
//        int tuesdayCalories = 0;
//        int wednesdayCalories = 0;
//        int thursdayCalories = 0;
//        int fridayCalories = 0;
//        int saturdayCalories = 0;
//        int sundayCalories = 0;
//        ArrayList<BarEntry> barEntries = new ArrayList<>();
//        for (int i  = 0; i < mondayList.size(); i++)
//        {
//            mondayCalories += mondayList.get(i).calories;
//        }
//        for (int i  = 0; i < tuesdayList.size(); i++)
//        {
//            tuesdayCalories += tuesdayList.get(i).calories;
//        }
//        for (int i  = 0; i < wednesdayList.size(); i++)
//        {
//            wednesdayCalories += wednesdayList.get(i).calories;
//        }
//        for (int i  = 0; i < thursdayList.size(); i++)
//        {
//            thursdayCalories += thursdayList.get(i).calories;
//        }
//        for (int i  = 0; i < fridayList.size(); i++)
//        {
//            fridayCalories += fridayList.get(i).calories;
//        }
//        for (int i  = 0; i < saturdayList.size(); i++)
//        {
//            saturdayCalories += saturdayList.get(i).calories;
//        }
//        for (int i  = 0; i < sundayList.size(); i++)
//        {
//            sundayCalories += sundayList.get(i).calories;
//        }
//
//        Log.d("Progress", " "+ tuesdayCalories);
//
//
//        barEntries.add(new BarEntry(1, mondayCalories));
//        barEntries.add(new BarEntry(2, tuesdayCalories));
//        barEntries.add(new BarEntry(3, wednesdayCalories));
//        barEntries.add(new BarEntry(4, thursdayCalories));
//        barEntries.add(new BarEntry(5, fridayCalories));
//        barEntries.add(new BarEntry(6, saturdayCalories));
//        barEntries.add(new BarEntry(7, sundayCalories));
//
//        BarDataSet barDataSet = new BarDataSet(barEntries, "Days");
//        barDataSet.setColors(ColorTemplate.rgb("#0000FF"));
//
//        BarData data = new BarData(barDataSet);
//        data.setBarWidth(1.0f);
//        chart.setData(data);
//    }
        return inflater.inflate(R.layout.fragment_progress, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cal = Calendar.getInstance();
        currentDay = cal.getTime();
        dayFormat = new SimpleDateFormat("EEEE");
        totalCal = 0;

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
                totalCal = 0;
                if (dayInNo == 1) {
                    dayInNo = 7;
                } else {
                    dayInNo -= 1;
                }
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
        });

        btnRight = view.findViewById(R.id.imgBtnRight);
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCal = 0;
                if (dayInNo == 7) {
                    dayInNo = 1;
                } else {
                    dayInNo ++;
                }
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
