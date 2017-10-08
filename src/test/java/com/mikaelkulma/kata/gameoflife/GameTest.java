package com.mikaelkulma.kata.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class GameTest {

    private Playable game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void should_have_0_cells_the_first_generation_when_started_with_no_cells() {
        game.nextGeneration();
        assertThat(game.numberOfCellsInGeneration(), is(0));
    }

    @Test
    public void should_update_number_of_cells_when_cells_are_added() {
        game.newLivingCell(2, 4);
        assertThat(game.numberOfCellsInGeneration(), is(1));
    }

    @Test
    public void should_have_0_cells_in_the_first_generation_when_started_with_1_cell() {
        game.newLivingCell(2, 4);
        game.nextGeneration();
        assertThat(game.numberOfCellsInGeneration(), is(0));
    }

    @Test
    public void should_have_8_cells_in_the_first_generation_when_started_with_a_cross_shape() {
        addACrossShape();
        game.nextGeneration();
        assertThat(game.numberOfCellsInGeneration(), is(8));
    }

    @Test
    public void should_have_8_cells_in_the_second_generation_when_started_with_a_cross_shape() {
        addACrossShape();
        game.nextGeneration();
        game.nextGeneration();
        assertThat(game.numberOfCellsInGeneration(), is(8));
    }

    @Test
    public void should_have_12_cells_in_the_third_generation_when_started_with_a_cross_shape() {
        addACrossShape();
        game.nextGeneration();
        game.nextGeneration();
        game.nextGeneration();
        assertThat(game.numberOfCellsInGeneration(), is(12));
    }

    @Test
    public void should_have_12_cells_in_the_100000th_generation_when_started_with_a_cross_shape() {
        addACrossShape();
        for (int i = 1; i < 100000; i++) {
            game.nextGeneration();
        }

        assertThat(game.numberOfCellsInGeneration(), is(12));
    }

    @Test
    public void should_have_0_cells_in_the_131th_generation_when_started_with_a_diehard() {
        addADiehard();
        for (int i = 1; i < 131; i++) {
            game.nextGeneration();
        }

        assertThat(game.numberOfCellsInGeneration(), is(0));
    }

    private void addADiehard() {
        game.newLivingCell(8, 1);
        game.newLivingCell(2, 2);
        game.newLivingCell(3, 2);
        game.newLivingCell(3, 3);
        game.newLivingCell(7, 3);
        game.newLivingCell(8, 3);
        game.newLivingCell(9, 3);
    }

    private void addACrossShape() {
        game.newLivingCell(2, 1);
        game.newLivingCell(1, 2);
        game.newLivingCell(2, 2);
        game.newLivingCell(3, 2);
        game.newLivingCell(2, 3);
    }
}
