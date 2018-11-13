package com.kevintoh0305gmail.gastronome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatisticsFragment extends Fragment {
    private BarChart chart;
    private TextView tvX, tvY;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = view.findViewById(R.id.profileBarChart);
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.setMaxVisibleValueCount(50);
        chart.setDrawGridBackground(false);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 2040f));
        barEntries.add(new BarEntry(2, 2144f));
        barEntries.add(new BarEntry(3, 0f));
        barEntries.add(new BarEntry(4, 0f));
        barEntries.add(new BarEntry(5, 0f));
        barEntries.add(new BarEntry(6, 0f));
        barEntries.add(new BarEntry(7, 0f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Days");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.9f);
        chart.setData(data);

        String[] days = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(days));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //xAxis.setGranularity(1);
        //xAxis.setCenterAxisLabels(true);
        //xAxis.setAxisMinimum(1);
        //YAxis yAxis = chart.getAxisRight();
        //yAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
    }

    public class MyXAxisValueFormatter implements IAxisValueFormatter{
        private String[] mValues;
        public MyXAxisValueFormatter(String[] values){
            this.mValues = values;
        }
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int)value - 1];
        }
    }

}
