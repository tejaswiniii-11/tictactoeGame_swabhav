package com.aurionpro.models;

public class Cell {
    private Mark mark;

    public Cell() {
        this.mark = Mark.EMPTY;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        if (this.mark != Mark.EMPTY) {
            throw new IllegalStateException("Cell already occupied!");
        }
        this.mark = mark;
    }

    public void reset() {
        this.mark = Mark.EMPTY;
    }
    
    @Override
    public String toString() {
        return mark == Mark.EMPTY ? " " : mark.toString();
    }

}
