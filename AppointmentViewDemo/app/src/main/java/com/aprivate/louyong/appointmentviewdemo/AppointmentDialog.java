package com.aprivate.louyong.appointmentviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louyong on 2017/8/30.
 */

public class AppointmentDialog extends DialogFragment{

    private RecyclerView mDaylist;
    private AppointmentAdapter mAppointmentAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_layout, null);

        mAppointmentAdapter = new AppointmentAdapter(getActivity());
        mDaylist = (RecyclerView) v.findViewById(R.id.day_list);
        List<DayEntity> list = new ArrayList<>();
        List<String> dayWeeks = DataUtils.getDateAndWeekStrings(false, 14);

        for(String str : dayWeeks) {
            DayEntity dE =  new DayEntity();
            dE.setTitle(str);
            list.add(dE);
        }
        mAppointmentAdapter.setList(list);
        mDaylist.setAdapter(mAppointmentAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mDaylist.setLayoutManager(manager);
        return v;
    }
}
