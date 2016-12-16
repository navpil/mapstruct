package org.mapstruct.ap.test.nestedbeans.unmappable.map;


public class LandDto {
    private HouseDto house;

    public LandDto(HouseDto house) {
        this.house = house;
    }

    public HouseDto getHouse() {
        return house;
    }

    public void setHouse(HouseDto house) {
        this.house = house;
    }
}
