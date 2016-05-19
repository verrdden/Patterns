package com.lab111.labwork6;

/**
 * Created by verrden on 06.05.16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Context context = new Context(new BarChartDiagram());
        context.setStrategy(new LineChartDiagram());
        context.executeDiagram();
    }
}
