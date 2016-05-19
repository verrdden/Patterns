package com.lab111.labwork6;

/**
 * Created by verrden on 06.05.16.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void executeDiagram() throws Exception {
        strategy.showDiagram();
    }

    public void setStrategy(Strategy strategy) {

        this.strategy = strategy;
    }
}
