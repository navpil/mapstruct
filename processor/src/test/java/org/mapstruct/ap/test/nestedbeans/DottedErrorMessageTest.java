package org.mapstruct.ap.test.nestedbeans;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mapstruct.ap.test.nestedbeans.unmappables.Dictionary;
import org.mapstruct.ap.test.nestedbeans.unmappables.DictionaryDto;
import org.mapstruct.ap.test.nestedbeans.unmappables.ForeignWord;
import org.mapstruct.ap.test.nestedbeans.unmappables.ForeignWordDto;
import org.mapstruct.ap.test.nestedbeans.unmappables.UnmappableDeepListMapper;
import org.mapstruct.ap.test.nestedbeans.unmappables.UnmappableDeepMapKeyMapper;
import org.mapstruct.ap.test.nestedbeans.unmappables.UnmappableDeepMapValueMapper;
import org.mapstruct.ap.test.nestedbeans.unmappables.UserDto;
import org.mapstruct.ap.test.nestedbeans.unmappables.User;
import org.mapstruct.ap.test.nestedbeans.unmappables.WheelDto;
import org.mapstruct.ap.test.nestedbeans.unmappables.Wheel;
import org.mapstruct.ap.test.nestedbeans.unmappables.Car;
import org.mapstruct.ap.test.nestedbeans.unmappables.CarDto;
import org.mapstruct.ap.test.nestedbeans.unmappables.House;
import org.mapstruct.ap.test.nestedbeans.unmappables.HouseDto;
import org.mapstruct.ap.test.nestedbeans.unmappables.Color;
import org.mapstruct.ap.test.nestedbeans.unmappables.ColorDto;
import org.mapstruct.ap.test.nestedbeans.unmappables.Roof;
import org.mapstruct.ap.test.nestedbeans.unmappables.RoofDto;
import org.mapstruct.ap.test.nestedbeans.unmappables.UnmappableDeepNestingMapper;
import org.mapstruct.ap.test.nestedbeans.unmappables.Word;
import org.mapstruct.ap.test.nestedbeans.unmappables.WordDto;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.compilation.annotation.CompilationResult;
import org.mapstruct.ap.testutil.compilation.annotation.Diagnostic;
import org.mapstruct.ap.testutil.compilation.annotation.ExpectedCompilationOutcome;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;

@WithClasses({
    Car.class, CarDto.class, Color.class, ColorDto.class,
    House.class, HouseDto.class, Roof.class, RoofDto.class,
    User.class, UserDto.class, Wheel.class, WheelDto.class,
    Dictionary.class, DictionaryDto.class, Word.class, WordDto.class,
    ForeignWord.class, ForeignWordDto.class
})
@RunWith(AnnotationProcessorTestRunner.class)
public class DottedErrorMessageTest {

    private static final String PROPERTY = "property";
    private static final String COLLECTION_ELEMENT = "collection element";
    private static final String MAP_KEY = "map key";
    private static final String MAP_VALUE = "map value";

    @Test
    @WithClasses({
        UnmappableDeepNestingMapper.class
    })
    @ExpectedCompilationOutcome(
        value = CompilationResult.FAILED,
        diagnostics = {
            @Diagnostic(type = UnmappableDeepNestingMapper.class,
                kind = javax.tools.Diagnostic.Kind.ERROR,
                messageRegExp = "Can't map " + PROPERTY +
                    " \".*Color house\\.roof\\.color\" to \".*house\\.roof\\.color\"\\. " +
                    "Consider to declare/implement a mapping method: .*.")
        }
    )
    public void testDeepNestedBeans() {
    }

    @Test
    @WithClasses({
        UnmappableDeepListMapper.class
    })
    @ExpectedCompilationOutcome(
        value = CompilationResult.FAILED,
        diagnostics = {
            @Diagnostic(type = UnmappableDeepListMapper.class,
                kind = javax.tools.Diagnostic.Kind.ERROR,
                messageRegExp = "Can't map " + COLLECTION_ELEMENT +
                    " \".*Wheel car\\.wheels\\[\\]\" to \".*car\\.wheels\\[\\]\"\\. " +
                    "Consider to declare/implement a mapping method: .*.")
        }
    )
    public void testIterables() {
    }

    @Test
    @WithClasses({
        UnmappableDeepMapKeyMapper.class
    })
    @ExpectedCompilationOutcome(
        value = CompilationResult.FAILED,
        diagnostics = {
            @Diagnostic(type = UnmappableDeepMapKeyMapper.class,
                kind = javax.tools.Diagnostic.Kind.ERROR,
                messageRegExp = "Can't map " + MAP_KEY +
                    " \".*Word dictionary\\.wordMap\\{\\}\\.word\" to \".*dictionary\\.wordMap\\{\\}\\.wordDto\"\\. " +
                    "Consider to declare/implement a mapping method: .*.")
        }
    )
    public void testMapKeys() {
    }

    @Test
    @WithClasses({
        UnmappableDeepMapValueMapper.class
    })
    @ExpectedCompilationOutcome(
        value = CompilationResult.FAILED,
        diagnostics = {
            @Diagnostic(type = UnmappableDeepMapValueMapper.class,
                kind = javax.tools.Diagnostic.Kind.ERROR,
                messageRegExp = "Can't map " + MAP_VALUE +
                    " \".*Word dictionary\\.wordMap\\{\\}\\.foreignWord\" to \".*dictionary\\.wordMap\\{\\}\\.foreignWordDto\"\\. " +
                    "Consider to declare/implement a mapping method: .*.")
        }
    )
    public void testMapValues() {
    }

}
