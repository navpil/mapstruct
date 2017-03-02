/**
 * Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 * and/or other contributors as indicated by the @authors tag. See the
 * copyright.txt file in the distribution for a full listing of all
 * contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mapstruct.ap.test.nestedbeans;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.ap.test.nestedbeans.recursive.RecursionMapper;
import org.mapstruct.ap.test.nestedbeans.recursive.TreeRecursionMapper;
import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;

@RunWith(AnnotationProcessorTestRunner.class)
public class RecursionTest {

    @WithClasses({
        RecursionMapper.class
    })
    @Test
    @IssueKey("1103")
    public void testRecursiveAutoMap() {
        RecursionMapper.Root root = RecursionMapper.INSTANCE.mapRoot(
            new RecursionMapper.RootDto(
                new RecursionMapper.ChildDto( "Sub Root", new RecursionMapper.ChildDto(
                    "Sub child", null
                ) )
            ) );

        Assert.assertEquals(
            new RecursionMapper.Root(
                new RecursionMapper.Child( "Sub Root", new RecursionMapper.Child(
                    "Sub child", null
                ) )
            ),
            root
        );
    }

    @WithClasses({
        TreeRecursionMapper.class
    })
    @Test
    @IssueKey("1103")
    public void testRecursiveAutoMap2() {
        TreeRecursionMapper.Root root = TreeRecursionMapper.INSTANCE.mapRoot(
            new TreeRecursionMapper.RootDto(
                Collections.singletonList( new TreeRecursionMapper.ChildDto(
                    "Sub Root",
                    Collections.singletonList( new TreeRecursionMapper.ChildDto(
                        "Sub child", null
                    ) )
                ) )
            ) );

        Assert.assertEquals(
            new TreeRecursionMapper.Root(
                Collections.singletonList(
                    new TreeRecursionMapper.Child(
                        "Sub Root",
                        Collections.singletonList( new TreeRecursionMapper.Child(
                            "Sub child", null
                        ) )
                    ) )
            ),
            root
        );
    }

}
