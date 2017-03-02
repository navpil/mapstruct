/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.test.nestedbeans.recursive;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class TreeRecursionMapper {

    public static final TreeRecursionMapper INSTANCE = Mappers.getMapper( TreeRecursionMapper.class );

    public abstract Root mapRoot(RootDto rootDto);

    public static class Root {
        private List<Child> child;

        public Root() {
        }

        public Root(List<Child> child) {
            this.child = child;
        }

        public List<Child> getChild() {
            return child;
        }

        public void setChild(List<Child> child) {
            this.child = child;
        }

        @Override
        public boolean equals(Object o) {
            if ( this == o ) {
                return true;
            }
            if ( o == null || getClass() != o.getClass() ) {
                return false;
            }

            Root root = (Root) o;

            return child != null ? child.equals( root.child ) : root.child == null;

        }

        @Override
        public int hashCode() {
            return child != null ? child.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Root{" +
                "child=" + child +
                '}';
        }
    }

    public static class Child {
        private String name;
        private List<Child> child; // recursion doesn't work

        public Child() {
        }

        public Child(String name, List<Child> child) {
            this.name = name;
            this.child = child;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Child> getChild() {
            return child;
        }

        public void setChild(List<Child> child) {
            this.child = child;
        }

        @Override
        public boolean equals(Object o) {
            if ( this == o ) {
                return true;
            }
            if ( o == null || getClass() != o.getClass() ) {
                return false;
            }

            Child child1 = (Child) o;

            if ( name != null ? !name.equals( child1.name ) : child1.name != null ) {
                return false;
            }
            return child != null ? child.equals( child1.child ) : child1.child == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + ( child != null ? child.hashCode() : 0 );
            return result;
        }

        @Override
        public String toString() {
            return "Child{" +
                "name='" + name + '\'' +
                ", child=" + child +
                '}';
        }
    }

    public static class RootDto {
        private List<ChildDto> child;

        public RootDto() {
        }

        public RootDto(List<ChildDto> child) {
            this.child = child;
        }

        public List<ChildDto> getChild() {
            return child;
        }

        public void setChild(List<ChildDto> child) {
            this.child = child;
        }

    }

    public static class ChildDto {
        private String name;
        private List<ChildDto> child;

        public ChildDto() {
        }

        public ChildDto(String name, List<ChildDto> child) {
            this.name = name;
            this.child = child;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ChildDto> getChild() {
            return child;
        }

        public void setChild(List<ChildDto> child) {
            this.child = child;
        }

    }
}
