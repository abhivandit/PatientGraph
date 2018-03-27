package com.example.abhivandit.graph;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX);
                } else {
                    // show currency for y values
                    if(value==(double)1){
                        return "None";//super.formatLabel(value, isValueX);
                        }
                    else if(value==(double)2) {
                        return "Moderate" ;//super.formatLabel(value, isValueX);
                    }
                    else if(value==(double)3){      return "Mild Severe" ;//    return super.formatLabel(value, isValueX);
                    }
                    else if(value==(double)4){
                        return "Mild";// super.formatLabel(value, isValueX)+"ssshkhu";
                    }
                    else if(value==(double)5){
                        return "Severe";//super.formatLabel(value, isValueX);
                    }
                    else {
                        return "";
                    }
                }
            }
        });
        DataPoint[] points = new DataPoint[11];
        for (int i = 0; i < points.length; i++) {
            if(i<=5){points[i] = new DataPoint(i,i);}
            else{
                points[i]=new DataPoint(i,(i-5));
            }
        }


        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);
        GridLabelRenderer gridLabelRenderer=new GridLabelRenderer(graph);
     //  gridLabelRenderer.isHorizontalLabelsVisible();
      //  gridLabelRenderer.isVerticalLabelsVisible();
       // gridLabelRenderer.setHorizontalLabelsVisible(true);
     //  gridLabelRenderer.setHumanRounding(false);
       graph.getGridLabelRenderer().setNumVerticalLabels(5);
        graph.getGridLabelRenderer().setVerticalLabelsVisible(true);
   graph.getGridLabelRenderer().setPadding(32);
       // series.setDataPointIndicatorRenderer(new SphericalDataPointIndicatorRenderer(series));

        // set manual X bounds
       graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(5.1);

      graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(5);
        graph.getViewport().setMaxX(10.1);
series.setDrawDataPoints(true);
        graph.getGridLabelRenderer().setVerticalLabelsAlign(Paint.Align.LEFT);
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(true);
      //  graph.getGridLabelRenderer().isHumanRounding(true);
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(MainActivity.this, "Series1: On Data Point clicked: "+dataPoint, Toast.LENGTH_SHORT).show();
            }
        });

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollable(true);



        graph.addSeries(series);
    }
}
