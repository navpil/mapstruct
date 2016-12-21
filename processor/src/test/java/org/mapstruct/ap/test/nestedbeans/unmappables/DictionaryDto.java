package org.mapstruct.ap.test.nestedbeans.unmappables;

import java.util.Map;

public class DictionaryDto {

    private Map<WordDto, ForeignWordDto> wordMap;

    public Map<WordDto, ForeignWordDto> getWordMap() {
        return wordMap;
    }

    public void setWordMap(
        Map<WordDto, ForeignWordDto> wordMap) {
        this.wordMap = wordMap;
    }
}
