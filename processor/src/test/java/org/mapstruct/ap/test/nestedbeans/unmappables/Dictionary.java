package org.mapstruct.ap.test.nestedbeans.unmappables;

import java.util.Map;

public class Dictionary {

    private Map<Word, ForeignWord> wordMap;

    public Map<Word, ForeignWord> getWordMap() {
        return wordMap;
    }

    public void setWordMap(
        Map<Word, ForeignWord> wordMap) {
        this.wordMap = wordMap;
    }
}
