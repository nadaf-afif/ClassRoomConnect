package app.technokratzs.classroomconnect.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dacer.androidcharts.LineView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.renderer.YAxisRenderer;

import java.util.ArrayList;
import java.util.List;

import app.technokratzs.classroomconnect.R;

/**
 * Created by afif on 20/5/15.
 */
public class SubjectAnalysisFragment extends Fragment {


    private LineChart mLineChart;
    private LineView mLineView;
    protected String[] mMonths = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private int[] mMarks = new int[]{40,35,41,44,39,40,32,42};
    private int[] mAverageMarks = new int[]{45,39,40,44,42,43,38,40};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_subject_analysis,container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//
//        mLineChart = (LineChart) view.findViewById(R.id.lineChartSubjects);
//
//        LineData data = getData(mMarks.length, 0);
//        setupChart(mLineChart, data,  Color.WHITE );
//
//        XAxis xAxis = mLineChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTextSize(10f);
//        xAxis.setTextColor(Color.RED);
//        xAxis.setDrawAxisLine(true);
//
//
//        YAxis yAxis = mLineChart.getAxisLeft();
//        yAxis.setTextSize(12f); // set the textsize
//        yAxis.setAxisMaxValue(60f); // the axis maximum is 100
//        yAxis.setTextColor(Color.BLACK);
//
//        LimitLine ll = new LimitLine(40, "Average score");
//        ll.setLineColor(Color.MAGENTA);
//        ll.setLineWidth(2f);
//        ll.setTextColor(Color.BLACK);
//        ll.setTextSize(12f);
//
//        yAxis.addLimitLine(ll);
//
//        ArrayList<String> xVals = new ArrayList<String>();
//        xVals.add("1.Q"); xVals.add("2.Q"); xVals.add("3.Q"); xVals.add("4.Q");


        mLineView = (LineView) view.findViewById(R.id.lineView);
        ArrayList<String> monthsArray = new ArrayList<String>();
        for (int i = 0;i<mMonths.length;i++)
            monthsArray.add(mMonths[i]);

        mLineView.setBottomTextList(monthsArray);
        mLineView.setDrawDotLine(true); //optional
        mLineView.setShowPopup(LineView.SHOW_POPUPS_MAXMIN_ONLY); //optional


        ArrayList<ArrayList<Integer>> allMarksData = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> marksData = new ArrayList<Integer>();

        for (int i = 0;i<mMarks.length;i++) {

            marksData.add(mMarks[i]);

        }

        ArrayList<Integer> averageMarksData = new ArrayList<Integer>();

        for (int i = 0;i<mAverageMarks.length;i++) {

            averageMarksData.add(mAverageMarks[i]);

        }


        allMarksData.add(marksData);
        allMarksData.add(averageMarksData);

        mLineView.setDataList(allMarksData);
        mLineView.animate();

    }


    private void setupChart(LineChart chart, LineData data, int color) {

        // no description text
        chart.setDescription("");
        chart.setNoDataTextDescription("You need to provide data for the chart.");

        // mChart.setDrawHorizontalGrid(false);
        //
        // enable / disable grid background
        chart.setDrawGridBackground(false);
//        chart.getRenderer().getGridPaint().setGridColor(Color.WHITE & 0x70FFFFFF);

        // enable touch gestures
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setBackgroundColor(color);

        // set custom chart offsets (automatic offset calculation is hereby disabled)
        chart.setViewPortOffsets(10, 0, 10, 0);

        // add data
        chart.setData(data);

        // get the legend (only possible after setting data)
        Legend l = chart.getLegend();
        l.setEnabled(false);

        chart.getAxisLeft().setEnabled(true);
        chart.getAxisRight().setEnabled(true);

        chart.getXAxis().setEnabled(true);

        // animate calls invalidate()...
        chart.animateX(2500);



    }

    private LineData getData(int count, float range) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add(mMonths[i % 12]);
        }

        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float val = (float) mMarks[i];
            yVals.add(new Entry(val, i));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(yVals, "DataSet 1");
        // set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);
        set1.setLineWidth(4f);
        set1.setCircleSize(6f);
        set1.setColor(Color.BLUE);
        set1.setCircleColor(Color.GREEN);
        set1.setHighLightColor(Color.TRANSPARENT);
        set1.setDrawValues(false);

        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);

        return data;
    }
}
