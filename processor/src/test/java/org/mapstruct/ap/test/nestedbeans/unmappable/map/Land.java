package org.mapstruct.ap.test.nestedbeans.unmappable.map;


public class Land {
    private House house;

    public Land(House house) {
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
