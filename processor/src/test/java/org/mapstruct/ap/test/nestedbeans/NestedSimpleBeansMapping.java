/**
 * Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
 * and/or other contributors as indicated by the @authors tag. See the
 * copyright.txt file in the distribution for a full listing of all
 * contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mapstruct.ap.test.nestedbeans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@WithClasses({User.class, UserDto.class, Car.class, CarDto.class, House.class, HouseDto.class,
        Wheel.class, WheelDto.class,
        Roof.class, RoofDto.class,
        UserDtoMapperClassic.class,
        UserDtoMapperSmart.class
})
@RunWith(AnnotationProcessorTestRunner.class)
public class NestedSimpleBeansMapping {

    @Test
    public void shouldMapNestedBeans() {

        User user = new User("John", new Car("Chrysler", 1955, Arrays.asList(
                new Wheel().front().left(),
                new Wheel().front().right(),
                new Wheel().rear().left(),
                new Wheel().rear().right())),
                new House("Black", 1834, new Roof(1)));

        UserDto classicMapping = UserDtoMapperClassic.INSTANCE.userToUserDto(user);
        UserDto smartMapping = UserDtoMapperSmart.INSTANCE.userToUserDto(user);

        System.out.println(smartMapping);
        System.out.println(classicMapping);


        assertThat(smartMapping).isNotNull();
        assertThat(smartMapping).isEqualTo(classicMapping);

    }
}
