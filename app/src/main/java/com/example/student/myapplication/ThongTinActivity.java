package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThongTinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);

        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("data");
        SinhVien sv= (SinhVien) bundle.getSerializable("sinhvien");

        FragmentThongTin frg=new FragmentThongTin();
        frg.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frg).commit();
    }
}
