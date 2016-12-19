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
package org.mapstruct.ap.internal.model.source;

import org.mapstruct.ap.internal.model.common.Type;

public class ForgedMethodHistory {

    private final ForgedMethodHistory prevHistory;
    private final String sourceElement;
    private final String targetPropertyName;
    private final Type targetType;
    private final Type sourceType;
    private final boolean usePropertyNames;
    private String elementType;

    public ForgedMethodHistory(ForgedMethodHistory history, String sourceElement, String targetPropertyName,
                               Type sourceType, Type targetType, boolean usePropertyNames, String elementType) {
        prevHistory = history;
        this.sourceElement = sourceElement;
        this.targetPropertyName = targetPropertyName;
        this.sourceType = sourceType;
        this.targetType = targetType;
        this.usePropertyNames = usePropertyNames;
        this.elementType = elementType;
    }

    public String getTargetPropertyName() {
        return targetPropertyName;
    }

    public Type getTargetType() {
        return targetType;
    }

    public Type getSourceType() {
        return sourceType;
    }

    public String createSourcePropertyErrorMessage() {
        return elementType + " \"" + getSourceType() + " " +
            stripBrackets( getDottedSourceElement() ) + "\"";
    }

    public String createTargetPropertyName() {
        return stripBrackets( getDottedTargetPropertyName() );
    }

    private String getDottedSourceElement() {
        if (prevHistory == null) {
            return sourceElement;
        } else {
            if (usePropertyNames) {
                return prevHistory.getDottedSourceElement() + "." + sourceElement;
            } else {
                return prevHistory.getDottedSourceElement();
            }
        }
    }

    private String getDottedTargetPropertyName() {
        if (prevHistory == null) {
            return targetPropertyName;
        } else {
            if (usePropertyNames) {
                return prevHistory.getDottedTargetPropertyName() + "." + targetPropertyName;
            } else {
                return prevHistory.getDottedTargetPropertyName();
            }

        }
    }

    private String stripBrackets(String dottedName) {
        return dottedName;
//        if ( dottedName.endsWith( "[]" ) || dottedName.endsWith( "{}" )) {
//            dottedName = dottedName.substring( 0, dottedName.length() - 2 );
//        }
//        return dottedName;
    }
}
