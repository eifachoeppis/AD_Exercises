package ch.hslu.ad.sw14.statesearch;

public class StateOneA implements State {

    private static final StateOneA INSTANCE = new StateOneA();

    private StateOneA() {

    }

    public static StateOneA getInstance() {
        return INSTANCE;
    }

    @Override
    public State change(char character) {
        if (character == 'N') {
            return StateTwoAN.getInstance();
        }
        return InitialState.getInstance();
    }
}
