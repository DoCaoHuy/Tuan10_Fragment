package com.example.student.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Student on 10/16/2018.
 */

public class FragmentThongTin extends Fragment {
    private TextView ma, ten, tuoi;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_thongtin, container, false);
        ma= (TextView) view.findViewById(R.id.lblID);
        ten= (TextView) view.findViewById(R.id.lblName);
        tuoi= (TextView) view.findViewById(R.id.lblAge);

        Bundle bundle=this.getArguments();
        SinhVien sv= (SinhVien) bundle.getSerializable("sinhvien");

        ma.setText(sv.getId());
        ten.setText(sv.getName());
        tuoi.setText(sv.getAge());

        return view;
    }
}
