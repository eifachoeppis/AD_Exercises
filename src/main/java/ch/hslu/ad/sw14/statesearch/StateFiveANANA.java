package ch.hslu.ad.sw14.statesearch;

public class StateFiveANANA implements State {

    private static final StateFiveANANA INSTANCE = new StateFiveANANA();

    private StateFiveANANA() {

    }

    public static StateFiveANANA getInstance() {
        return INSTANCE;
    }

    @Override
    public State change(char character) {
        if (character == 'S') {
            return StateSixANANAS.getInstance();
        } else if (character == 'N') {
            return StateFourANAN.getInstance();
        }
        return InitialState.getInstance();
    }
}
