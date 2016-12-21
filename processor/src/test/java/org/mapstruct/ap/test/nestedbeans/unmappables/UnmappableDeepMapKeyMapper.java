package org.mapstruct.ap.test.nestedbeans.unmappables;

import org.mapstruct.Mapper;

@Mapper
public abstract class UnmappableDeepMapKeyMapper {

    abstract UserDto userToUserDto(User user);

    public CarDto map(Car carDto) {
        return new CarDto();
    }

    public HouseDto map(House house) {
        return new HouseDto();
    }

    public ForeignWordDto map(ForeignWord word) {
        return new ForeignWordDto();
    }
}
