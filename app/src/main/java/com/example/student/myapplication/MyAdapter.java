package com.example.student.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Student on 10/16/2018.
 */

public class MyAdapter extends BaseAdapter {
    private Context mcontext;
    private int mlayout;
    private List<SinhVien> lstSinhVien;

    public MyAdapter(Context context, int layout, List<SinhVien> object) {
        this.mcontext = context;
        this.mlayout = layout;
        this.lstSinhVien = object;
    }

    @Override
    public int getCount() {
        return lstSinhVien.size();
    }

    @Override
    public Object getItem(int position) {
        return lstSinhVien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(mcontext).inflate(mlayout, parent, false);
        TextView ten= (TextView) convertView.findViewById(R.id.txtTen);
        ImageView hinh= (ImageView) convertView.findViewById(R.id.imageHinh);

        SinhVien sv=lstSinhVien.get(position);
        ten.setText(sv.getName());
        hinh.setImageResource(R.drawable.arrow);
        return convertView;
    }
}
