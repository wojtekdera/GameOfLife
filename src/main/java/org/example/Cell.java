package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class   Cell {

    private boolean state;

    public String getStateChar(){
        return (state ? "#": ".");
    }

    public Cell(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }


}
