package com.brunomilitzer.location.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class ReportUtilImpl implements ReportUtil {

    @Override
    public void generatePieChart(final String path, final List<Object[]> data) {

        final DefaultPieDataset dataset = new DefaultPieDataset();

        for (final Object[] objects : data) {
            dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
        }

        final JFreeChart chart = ChartFactory.createPieChart3D("Location Type Report", dataset);

        try {
            ChartUtilities.saveChartAsPNG(new File(path + "/pieChart.png"), chart, 300, 300);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
