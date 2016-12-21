package org.mapstruct.ap.test.nestedbeans.unmappables;

import org.mapstruct.Mapper;

@Mapper
public abstract class UnmappableDeepNestingMapper {

    abstract UserDto userToUserDto(User user);

    public CarDto map(Car carDto) {
        return new CarDto();
    }

    public DictionaryDto map(Dictionary dictionary) {
        return new DictionaryDto();
    }

}
