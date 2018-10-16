package com.example.student.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.res.ConfigurationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 10/16/2018.
 */

public class FragmentListView extends ListFragment {
    private List<SinhVien> lstSinhVien;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_listview, container, false);
        lstSinhVien=new ArrayList<>();
        lstSinhVien.add(new SinhVien("01", "Huy", "23"));
        lstSinhVien.add(new SinhVien("02", "Nhi", "22"));
        lstSinhVien.add(new SinhVien("03", "Linh", "22"));
        lstSinhVien.add(new SinhVien("04", "Yen", "23"));

        MyAdapter adapter=new MyAdapter(getActivity(), R.layout.custom_layout, lstSinhVien);
        setListAdapter(adapter);
        return view;
    }

    public void OpenThongTinActivity(SinhVien sv){
        Intent intent=new Intent(getActivity(), ThongTinActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("sinhvien", sv);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        SinhVien sv=lstSinhVien.get(position);
        int orien=getResources().getConfiguration().orientation;
        if(orien== Configuration.ORIENTATION_PORTRAIT){
            OpenThongTinActivity(sv);
        }else {
            Bundle bundle=new Bundle();
            bundle.putSerializable("sinhvien", sv);
            FragmentThongTin frg=new FragmentThongTin();
            frg.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, frg).commit();
        }
    }
}
