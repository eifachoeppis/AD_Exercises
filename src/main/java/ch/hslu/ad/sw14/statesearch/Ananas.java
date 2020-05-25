package ch.hslu.ad.sw14.statesearch;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Arrays;

public class Ananas {

    private static final State FOUND = StateSixANANAS.getInstance();

    private Ananas() {

    }

    public static int stateSearch(final String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null.");
        }

        CharacterIterator characterIterator = new StringCharacterIterator(text);
        State state = InitialState.getInstance();
        char character = characterIterator.first();
        int index = 0;

        while (state != FOUND && character != CharacterIterator.DONE) {
            state = state.change(character);
            character = characterIterator.next();
            index++;
        }

        return state == FOUND ? index - "ANANAS".length() : -1;
    }
}
