package org.mapstruct.ap.test.nestedbeans.unmappable.map;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LandMapper {

    LandMapper INSTANCE = Mappers.getMapper( LandMapper.class );

    LandDto landToDto(Land land);

}
