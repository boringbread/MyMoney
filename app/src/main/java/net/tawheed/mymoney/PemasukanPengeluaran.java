package net.tawheed.mymoney;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PemasukanPengeluaran extends Fragment {


    public PemasukanPengeluaran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pemasukan_pengeluaran, container, false);

        Toolbar t = v.findViewById(R.id.mm_choose_bar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        ((AppCompatActivity)getActivity()).setSupportActionBar(t);

        // Inflate the layout for this fragment
        return v;
    }

}
