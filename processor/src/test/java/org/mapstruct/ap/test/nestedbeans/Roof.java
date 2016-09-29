package org.mapstruct.ap.test.nestedbeans;

public class Roof {
    private int color;

    public Roof() {
    }

    public Roof(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Roof{" +
                "color='" + color + '\'' +
                '}';
    }
}
