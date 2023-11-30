package com.example.graph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GraphApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        Button lineChartButton = new Button("Линейный график");
        Button barChartButton = new Button("Столбчатая диаграмма");

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);


        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Данные");
        for (int i = 0; i < 10; i++) {
            series.getData().add(new XYChart.Data<>(i, Math.random() * 100));
        }
        lineChart.getData().add(series);


        lineChartButton.setOnAction(event -> {

            primaryStage.setScene(createSceneWithChart(lineChart));
        });

        barChartButton.setOnAction(event -> {

        });


        VBox root = new VBox(10);
        root.getChildren().addAll(lineChartButton, barChartButton, lineChart);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Построение графиков");
        primaryStage.show();
    }


    private Scene createSceneWithChart(LineChart<Number, Number> chart) {
        return new Scene(new VBox(chart), 600, 400);
    }

    public static void main(String[] args) {
        launch(args);
    }
}