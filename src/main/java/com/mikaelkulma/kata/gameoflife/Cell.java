package com.mikaelkulma.kata.gameoflife;

class Cell implements AliveStateAware, Resurrectable {

    final int x;
    final int y;
    boolean alive;

    Cell(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    Cell(int x, int y) {
        this(x, y, false);
    }

    public Cell comeAlive() {
        this.alive = true;
        return this;
    }

    public boolean isDead() {
        return !alive;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell point = (Cell) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + (alive? "alive ": "dead");
    }
}
