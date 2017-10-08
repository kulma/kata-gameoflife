package com.mikaelkulma.kata.gameoflife;

public interface Playable {

    void nextGeneration();

    void newLivingCell(int x, int y);

    int numberOfCellsInGeneration();

}
