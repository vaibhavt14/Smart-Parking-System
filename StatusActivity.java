/*
package com.example.vaibh.smartparking;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.macroyau.thingspeakandroid.ThingSpeakChannel;
import com.macroyau.thingspeakandroid.ThingSpeakLineChart;
import com.macroyau.thingspeakandroid.model.ChannelFeed;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class StatusActivity extends AppCompatActivity {

    private ThingSpeakChannel tsChannel;
    private ThingSpeakLineChart tsChart;
    private ThingSpeakLineChart tsChart1;
    private ThingSpeakLineChart tsChart2;
    private ThingSpeakLineChart tsChart3;
    private LineChartView chartView;
    private LineChartView chartView1;
    private LineChartView chartView2;
    private LineChartView chartView3;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        ctx = getApplicationContext();
        // Connect to ThinkSpeak Channel 9
        tsChannel = new ThingSpeakChannel(564368);
        // Set listener for Channel feed update events
        tsChannel.setChannelFeedUpdateListener(new ThingSpeakChannel.ChannelFeedUpdateListener() {
            @Override
            public void onChannelFeedUpdated(long channelId, String channelName, ChannelFeed channelFeed) {
                // Show Channel ID and name on the Action Bar
                getSupportActionBar().setTitle(channelName);
                getSupportActionBar().setSubtitle("Channel " + channelId);
                // Notify last update time of the Channel feed through a Toast message
                Date lastUpdate = channelFeed.getChannel().getUpdatedAt();
                Toast.makeText(StatusActivity.this, lastUpdate.toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(StatusActivity.this, channelFeed.getChannel().getField1(), Toast.LENGTH_LONG).show();
            }
        });
        // Fetch the specific Channel feed
        tsChannel.loadChannelFeed();

        // Create a Calendar object dated 5 minutes ago
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -5);

        // Configure LineChartView
        chartView = (LineChartView) findViewById(R.id.chart);
        chartView1 = (LineChartView) findViewById(R.id.chart1);
        chartView2 = (LineChartView) findViewById(R.id.chart2);
        chartView3 = (LineChartView) findViewById(R.id.chart3);
        chartView.setZoomEnabled(false);
        chartView.setValueSelectionEnabled(true);
        chartView1.setZoomEnabled(false);
        chartView1.setValueSelectionEnabled(true);
        // Create a line chart from Field1 of ThinkSpeak Channel 9
        tsChart = new ThingSpeakLineChart(564368, 1);
        // Get 200 entries at maximum
        tsChart.setNumberOfEntries(200);
        // Set value axis labels on 10-unit interval
        tsChart.setValueAxisLabelInterval(10);
        // Set date axis labels on 5-minute interval
        tsChart.setDateAxisLabelInterval(10);
        // Show the line as a cubic spline
        tsChart.useSpline(true);
        // Set the line color
        tsChart.setLineColor(Color.parseColor("#D32F2F"));
        // Set the axis color
        tsChart.setAxisColor(Color.parseColor("#455a64"));
        // Set the starting date (5 minutes ago) for the default viewport of the chart
        // tsChart.setChartStartDate(calendar.getTime());
        // Set listener for chart data update
        // Create a line chart from Field1 of ThinkSpeak Channel 9
        tsChart1 = new ThingSpeakLineChart(564368, 2);
        // Get 200 entries at maximum
        tsChart1.setNumberOfEntries(200);
        // Set value axis labels on 10-unit interval
        tsChart1.setValueAxisLabelInterval(10);
        // Set date axis labels on 5-minute interval
        tsChart1.setDateAxisLabelInterval(10);
        // Show the line as a cubic spline
        tsChart1.useSpline(true);
        // Set the line color
        tsChart1.setLineColor(Color.parseColor("#D32F2F"));
        // Set the axis color
        tsChart1.setAxisColor(Color.parseColor("#455a64"));
        // Set the starting date (5 minutes ago) for the default viewport of the chart
        // tsChart.setChartStartDate(calendar.getTime());
        // Set listener for chart data update
        tsChart2 = new ThingSpeakLineChart(564368, 3);
        // Get 200 entries at maximum
        tsChart2.setNumberOfEntries(200);
        // Set value axis labels on 10-unit interval
        tsChart2.setValueAxisLabelInterval(10);
        // Set date axis labels on 5-minute interval
        tsChart2.setDateAxisLabelInterval(10);
        // Show the line as a cubic spline
        tsChart2.useSpline(true);
        // Set the line color
        tsChart2.setLineColor(Color.parseColor("#D32F2F"));
        // Set the axis color
        tsChart2.setAxisColor(Color.parseColor("#455a64"));
        // Set the starting date (5 minutes ago) for the default viewport of the chart
        // tsChart.setChartStartDate(calendar.getTime());
        // Set listener for chart data update
        // Create a line chart from Field1 of ThinkSpeak Channel 9
        tsChart3 = new ThingSpeakLineChart(564368, 4);
        // Get 200 entries at maximum
        tsChart3.setNumberOfEntries(200);
        // Set value axis labels on 10-unit interval
        tsChart3.setValueAxisLabelInterval(10);
        // Set date axis labels on 5-minute interval
        tsChart3.setDateAxisLabelInterval(10);
        // Show the line as a cubic spline
        tsChart3.useSpline(true);
        // Set the line color
        tsChart3.setLineColor(Color.parseColor("#D32F2F"));
        // Set the axis color
        tsChart3.setAxisColor(Color.parseColor("#455a64"));
        // Set the starting date (5 minutes ago) for the default viewport of the chart
        // tsChart.setChartStartDate(calendar.getTime());
        // Set listener for chart data update

        tsChart.setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
            @Override
            public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData lineChartData, Viewport maxViewport, Viewport initialViewport) {



                chartView.setLineChartData(lineChartData);
                // Set scrolling bounds of the chart
                chartView.setMaximumViewport(maxViewport);
                // Set the initial chart bounds
                chartView.setCurrentViewport(initialViewport);
           */
/* LineChartData data = new LineChartData();
            float data1=data.getBaseValue();
            TextView tvName = (TextView)findViewById(R.id.textView);
            tvName.setText((int) data1);*//*


            }
        });
        // Load chart data asynchronously
        tsChart.loadChartData();
        tsChart1.setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
            @Override
            public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData lineChartData, Viewport maxViewport, Viewport initialViewport) {
                chartView1.setLineChartData(lineChartData);
                // Set scrolling bounds of the chart
                chartView1.setMaximumViewport(maxViewport);
                // Set the initial chart bounds
                chartView1.setCurrentViewport(initialViewport);
           */
/* LineChartData data = new LineChartData();
            float data1=data.getBaseValue();
            TextView tvName = (TextView)findViewById(R.id.textView);
            tvName.setText((int) data1);*//*


            }
        });
        // Load chart data asynchronously
        tsChart1.loadChartData();
        tsChart2.setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
            @Override
            public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData lineChartData, Viewport maxViewport, Viewport initialViewport) {
                chartView2.setLineChartData(lineChartData);
                // Set scrolling bounds of the chart
                chartView2.setMaximumViewport(maxViewport);
                // Set the initial chart bounds
                chartView2.setCurrentViewport(initialViewport);
           */
/* LineChartData data = new LineChartData();
            float data1=data.getBaseValue();
            TextView tvName = (TextView)findViewById(R.id.textView);
            tvName.setText((int) data1);*//*


            }
        });
        // Load chart data asynchronously
        tsChart2.loadChartData();
        tsChart3.setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
            @Override
            public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData lineChartData, Viewport maxViewport, Viewport initialViewport) {
                chartView3.setLineChartData(lineChartData);
                // Set scrolling bounds of the chart
                chartView3.setMaximumViewport(maxViewport);
                // Set the initial chart bounds
                chartView3.setCurrentViewport(initialViewport);
           */
/* LineChartData data = new LineChartData();
            float data1=data.getBaseValue();
            TextView tvName = (TextView)findViewById(R.id.textView);
            tvName.setText((int) data1);*//*


            }
        });
        // Load chart data asynchronously
        tsChart3.loadChartData();
    }


    }
*/
