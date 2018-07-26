package net.tawheed.mymoney;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import static android.view.Menu.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZIS extends Fragment {

    private Menu menu;

    public ZIS() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_zis, container, false);

        Toolbar t;
        t = v.findViewById(R.id.top_bar);
        try{
            if (t.getMenu().hasVisibleItems())
                System.out.println(" Hell'o World");
        } catch (NullPointerException n){
            System.out.println(" Nahh o Hell'o World");
        }
//        t.getMenu().findItem(R.id.grup1).setVisible(false);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(t);

        t = v.findViewById(R.id.mm_choose_bar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        ((AppCompatActivity)getActivity()).setSupportActionBar(t);


        // Inflate the layout for this fragment
        return v;

    }
}
