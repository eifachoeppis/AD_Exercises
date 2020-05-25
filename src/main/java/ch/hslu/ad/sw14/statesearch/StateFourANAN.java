package ch.hslu.ad.sw14.statesearch;

public class StateFourANAN implements State {

    private static final StateFourANAN INSTANCE = new StateFourANAN();

    private StateFourANAN() {

    }

    public static StateFourANAN getInstance() {
        return INSTANCE;
    }

    @Override
    public State change(char character) {
        if (character == 'A') {
            return StateFiveANANA.getInstance();
        }
        return InitialState.getInstance();
    }
}
