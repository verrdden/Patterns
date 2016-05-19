package com.lab111.labwork6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * Created by verrden on 06.05.16.
 */
public class LineChartDiagram extends Application implements Strategy {
    private String[][] table = Info.table;

    public LineChartDiagram() {
    }

    @Override
    public void showDiagram() {
        System.out.println("LineChart");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < table[i].length; j++) {

                System.out.print(" " + table[i][j] + " ");
            }
            System.out.print("%");
            System.out.println();
        }
        Application.launch();
        System.out.println("LineChart");
    }


    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Line Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");


        final LineChart<String, Number> lineChart =
                new LineChart<String, Number>(xAxis, yAxis);

        lineChart.setTitle("Language Monitoring");

        XYChart.Series series = new XYChart.Series();
        series.setName("Line Chart");
        for (int i = 0; i < table.length; i++) {
            series.getData().add(new XYChart.Data(table[i][0], Integer.valueOf(table[i][1])));
        }
        Scene scene = new Scene(lineChart, 800, 800);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

}

