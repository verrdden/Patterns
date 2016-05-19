package com.lab111.labwork6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


/**
 * Created by verrden on 06.05.16.
 */
public class BarChartDiagram extends Application implements Strategy {
    private String[][] table = Info.table;
    private Stage myStage;
    private Scene scene ;

    public BarChartDiagram() {
    }


    @Override
    public void showDiagram() {
        System.out.println("BarChart");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < table[i].length; j++) {

                System.out.print(" " + table[i][j] + " ");
            }
            System.out.print("%");
            System.out.println();
        }
        Application.launch();
        System.out.println("BarChartEnd");
    }

    @Override
    public void start(Stage stage) {

        myStage = stage;
        myStage.setTitle("Bar Chart");
        myStage.setWidth(500);
        myStage.setHeight(500);
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (int i = 0; i < table.length; i++) {
            pieChartData.add(new PieChart.Data(table[i][0], Integer.parseInt(table[i][1])));
        }

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Language Monitoring");
        scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().add(chart);
        myStage.setScene(scene);
        myStage.show();
    }


}
