package com.aprivate.louyong.appointmentviewdemo;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louyong on 2017/8/30.
 */

class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.DayViewHolder> {

    public interface OnRvItemClicklistener{

        void onRvItemClick(int postion);
    }

    private LayoutInflater inflater;
    private List<DayEntity> list;
    private OnRvItemClicklistener onRvItemClicklistener;
    private Activity activity;

    public AppointmentAdapter(Activity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);
        this.list = new ArrayList<DayEntity>();
    }

    public void setOnRvItemClicklistener(OnRvItemClicklistener onRvItemClicklistener) {
        this.onRvItemClicklistener = onRvItemClicklistener;
    }


    public void setList(List<DayEntity> list){
        if (list == null) {
            list = new ArrayList<DayEntity>();
        }
        this.list = new ArrayList<DayEntity>(list);
        notifyDataSetChanged();
    }

    public List<DayEntity> getList() {
        return list;
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DayViewHolder(inflater.inflate(R.layout.day_layout, null));
    }

    @Override
    public void onBindViewHolder(final DayViewHolder holder, final int position) {
        holder.title.setText(getItem(position).getTitle());
        holder.abutton.setEnabled(false);
        holder.fbutton.setEnabled(false);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public DayEntity getItem(int position){
        return list.get(position);
    }

    class DayViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private Button abutton;
        private Button fbutton;

        public DayViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            abutton = (Button) itemView.findViewById(R.id.appoint);
            fbutton = (Button) itemView.findViewById(R.id.full);
        }
    }
}