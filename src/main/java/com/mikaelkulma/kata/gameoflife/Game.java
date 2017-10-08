package com.mikaelkulma.kata.gameoflife;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Game implements Playable {

    private HashSet<Cell> currentGeneration;

    Game() {
        this.currentGeneration = new HashSet<>();
    }

    @Override
    public void nextGeneration() {

        HashSet<Cell> nextGeneration = new HashSet<>();

        currentGeneration.forEach((Cell cell) -> {

            for (Cell neighbour : neighbours(cell)) {

                int numberOfNeighbours = 0;

                for (Cell neighbourOfNeighbour : neighbours(neighbour)) {

                    if (currentGeneration.contains(neighbourOfNeighbour)) {
                        numberOfNeighbours++;
                    }
                }

                if (neighbour.isDead() && numberOfNeighbours == 3) {
                    neighbour.comeAlive();
                    nextGeneration.add(neighbour);

                }

                if (neighbour.isAlive() && (numberOfNeighbours == 2 || numberOfNeighbours == 3)) {
                    nextGeneration.add(neighbour);
                }

            }
        });

        currentGeneration = nextGeneration;
    }

    private List<Cell> neighbours(Cell p) {

        return (Arrays.asList(
                neighbour(new Cell(p.x - 1, p.y - 1)),
                neighbour(new Cell(p.x, p.y - 1)),
                neighbour(new Cell(p.x + 1, p.y - 1)),
                neighbour(new Cell(p.x - 1, p.y)),
                neighbour(new Cell(p.x + 1, p.y)),
                neighbour(new Cell(p.x - 1, p.y + 1)),
                neighbour(new Cell(p.x, p.y + 1)),
                neighbour(new Cell(p.x + 1, p.y + 1))
        ));
    }

    private Cell neighbour(Cell p) {
        return (currentGeneration.contains(p)) ? p.comeAlive() : p;
    }

    @Override
    public void newLivingCell(int x, int y) {
        currentGeneration.add(new Cell(x, y, true));
    }

    @Override
    public int numberOfCellsInGeneration() {
        return currentGeneration.size();
    }
}