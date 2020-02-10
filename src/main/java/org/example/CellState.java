package org.example;

public enum CellState{
    ALIVE('#'),
    DEAD('.');

    private char state;

    CellState(char state) {
        this.state = state;
    }

    public String getStateValue(){
        return String.valueOf(state);
    }


}