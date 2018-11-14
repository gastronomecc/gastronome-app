package com.kevintoh0305gmail.gastronome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
    TextView profileDetails;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        profileDetails = view.findViewById(R.id.tvProfileInfo);
//        profileDetails.setText("Height : "+Home.globals.getCurrentUser().getHeight()+"cm\n"
//                + "Weight : " + Home.globals.getCurrentUser().getWeight()+"kg\n"
//                + "BMI : " + Home.globals.getCurrentUser().getBMI()+"\n"
//                + "Goal : " + Home.globals.getCurrentUser().getGoal());
    }
}
