/**
 *  Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
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
package org.mapstruct.ap.test.nestedbeans.unmappable;

public class WheelDto {
    private boolean front;
    private boolean left;

    public WheelDto() {
    }

    public WheelDto(boolean front, boolean left) {
        this.front = front;
        this.left = left;
    }

    public boolean isFront() {
        return front;
    }

    public void setFront(boolean front) {
        this.front = front;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    @Override
    public boolean equals(Object o) {

        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }

        WheelDto wheel = (WheelDto) o;

        if ( front != wheel.front ) {
            return false;
        }
        return left == wheel.left;

    }

    @Override
    public int hashCode() {
        int result = ( front ? 1 : 0 );
        result = 31 * result + ( left ? 1 : 0 );
        return result;
    }

    @Override
    public String toString() {
        return "Wheel{" + ( front ? "front" : "rear" ) + ";" + ( left ? "left" : "left" ) + '}';
    }

}
