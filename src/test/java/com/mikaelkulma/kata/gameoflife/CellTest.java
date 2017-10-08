package com.mikaelkulma.kata.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class CellTest {

    @Test
    public void should_be_dead_by_default() {
        Cell cell = new Cell(1, 2);
        assertThat(cell.isDead(), is(true));
    }

    @Test
    public void should_be_alive_after_being_resurrected() {
        Cell cell = new Cell(1, 2);
        cell.comeAlive();
        assertThat(cell.isAlive(), is(true));
    }

    @Test
    public void should_be_alive_when_set_alive_on_create() {
        Cell cell = new Cell(1, 2, true);
        assertThat(cell.isAlive(), is(true));
    }

    @Test
    public void should_treat_a_cell_with_the_same_position_as_equal() {
        Cell cell = new Cell(1, 2);
        Cell cell2 = new Cell(1, 2);

        assertThat(cell, is(equalTo(cell2)));
    }
}
