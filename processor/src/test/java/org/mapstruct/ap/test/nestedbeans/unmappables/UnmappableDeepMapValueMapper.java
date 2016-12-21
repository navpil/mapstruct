package org.mapstruct.ap.test.nestedbeans.unmappables;

import org.mapstruct.Mapper;

@Mapper
public abstract class UnmappableDeepMapValueMapper {

    abstract UserDto userToUserDto(User user);

    public CarDto map(Car carDto) {
        return new CarDto();
    }

    public HouseDto map(House house) {
        return new HouseDto();
    }

    public WordDto map(Word word) {
        return new WordDto();
    }
}
