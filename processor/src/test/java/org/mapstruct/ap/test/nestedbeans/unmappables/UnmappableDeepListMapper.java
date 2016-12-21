package org.mapstruct.ap.test.nestedbeans.unmappables;

import org.mapstruct.Mapper;

@Mapper
public abstract class UnmappableDeepListMapper {

    abstract UserDto userToUserDto(User user);

    public HouseDto map(House house) {
        return new HouseDto();
    }

    public DictionaryDto map(Dictionary dictionary) {
        return new DictionaryDto();
    }
}
