package ch.hslu.ad.sw14.statesearch;

public class InitialState implements State {

    private static final InitialState INSTANCE = new InitialState();

    private InitialState() {

    }

    public static InitialState getInstance() {
        return INSTANCE;
    }

    @Override
    public State change(char character) {
        if (character == 'A') {
            return StateOneA.getInstance();
        }
        return InitialState.INSTANCE;
    }
}
