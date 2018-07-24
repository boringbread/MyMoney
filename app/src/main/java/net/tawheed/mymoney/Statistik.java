package net.tawheed.mymoney;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Statistik extends Fragment {
    BarChart bar;

    public Statistik() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_statistik, container, false);
        String[] arraySpinner = new String[] {
                "Income/Outcome", "Loan", "Both"
        };
        Spinner s = (Spinner) v.findViewById(R.id.spinner_stat_type);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        s.setAdapter(adapter);

//        Typeface font = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/ProductSans.ttf");
//        bar = v.findViewById(R.id.bar1);
//
//        List<BarEntry> entries = new ArrayList<>();
//        entries.add(new BarEntry(0f, 100f, "Total"));
//        entries.add(new BarEntry(1f, 82f, "Obtained"));
//        entries.add(new BarEntry(2f, 95f, "Highest"));
//        entries.add(new BarEntry(3f, 69f, "Average"));
//
//
//        BarDataSet bSet = new BarDataSet(entries, "Marks");
//        bSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
//
//        ArrayList<String> barFactors = new ArrayList<>();
//        barFactors.add("Total");
//        barFactors.add("Obtained");
//        barFactors.add("Highest");
//        barFactors.add("Average");
//
//
//        XAxis xAxis = bar.getXAxis();
//        xAxis.setGranularity(1f);
//        xAxis.setGranularityEnabled(true);
//        BarData data = new BarData(bSet);
//        data.setBarWidth(0.9f); // set custom bar width
//        data.setValueTextSize(12);
//        Description description = new Description();
//        description.setTextColor(R.color.colorPrimary);
//        description.setText("All values in marks");
//        bar.setDescription(description);
//        bar.setData(data);
//        bar.setFitBars(true); // make the x-axis fit exactly all bars
//        bar.invalidate(); // refresh
//        bar.getXAxis().setValueFormatter(new IndexAxisValueFormatter(barFactors));
//
//        Legend l = bar.getLegend();
//        l.setFormSize(10f); // set the size of the legend forms/shapes
//        l.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
//        l.setTypeface(font);
//        l.setTextSize(12f);
//        l.setTextColor(Color.BLACK);
//        List<LegendEntry> lentries = new ArrayList<>();
//        for (int i = 0; i < barFactors.size(); i++) {
//            LegendEntry entry = new LegendEntry();
//            entry.formColor = ColorTemplate.VORDIPLOM_COLORS[i];
//            entry.label = barFactors.get(i);
//            lentries.add(entry);
//        }
//        l.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
//        l.setYEntrySpace(5f);
//        l.setCustom(lentries);

        // Inflate the layout for this fragment
        return v;
    }

}
