package ch.hslu.ad.sw13;

public class WordProblem {

    private WordProblem(){

    }

    private static final WordState INVALID = InitialState.getInstance();
    private static final WordState FINAL_ONE = StateOne.getInstance();
    private static final WordState FINAL_FOUR = StateFour.getInstance();

    public static boolean isWordLanguage(final String word){
        if (word == null){
            throw new IllegalArgumentException("Word must not be null.");
        }

        WordState state = InitialState.getInstance();

        for (int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            if (character == '0'){
                state = state.Zero();
            } else if (character == '1'){
                state = state.One();
            } else {
                return false;
            }

            if (state == INVALID){
                return false;
            }
        }

        return state == FINAL_ONE || state == FINAL_FOUR;
    }
}
