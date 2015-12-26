package app.technokratzs.classroomconnect.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import app.technokratzs.classroomconnect.R;

/**
 * Created by afif on 19/5/15.
 */
public class GraphFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

         View view = inflater.inflate(R.layout.fragment_graph,container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PieChart mPieChart = (PieChart) view.findViewById(R.id.piechart);

        mPieChart.addPieSlice(new PieModel("Mathematics", 15, Color.parseColor("#FE6DA8")));
        mPieChart.addPieSlice(new PieModel("Physics", 12, Color.parseColor("#56B7F1")));
        mPieChart.addPieSlice(new PieModel("Biology", 14, Color.parseColor("#CDA67F")));
        mPieChart.addPieSlice(new PieModel("Chemistry", 10, Color.parseColor("#FED70E")));
        mPieChart.addPieSlice(new PieModel("English", 11, Color.parseColor("#66FF33")));
        mPieChart.addPieSlice(new PieModel("Social Science", 15, Color.parseColor("#19222B")));



        mPieChart.startAnimation();

    }
}
