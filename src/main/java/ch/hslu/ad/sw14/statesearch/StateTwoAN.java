package ch.hslu.ad.sw14.statesearch;

public class StateTwoAN implements State {

    private static final StateTwoAN INSTANCE = new StateTwoAN();

    private StateTwoAN() {

    }

    public static StateTwoAN getInstance() {
        return INSTANCE;
    }

    @Override
    public State change(char character) {
        if (character == 'A') {
            return StateThreeANA.getInstance();
        }
        return InitialState.getInstance();
    }
}
