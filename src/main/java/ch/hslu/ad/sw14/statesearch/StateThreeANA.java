package ch.hslu.ad.sw14.statesearch;

public class StateThreeANA implements State {

    private static final StateThreeANA INSTANCE = new StateThreeANA();

    private StateThreeANA() {

    }

    public static StateThreeANA getInstance() {
        return INSTANCE;
    }

    @Override
    public State change(char character) {
        if (character == 'N') {
            return StateFourANAN.getInstance();
        }
        return InitialState.getInstance();
    }
}
