package ch.hslu.ad.sw14.statesearch;

public class StateSixANANAS implements State {

    private static final StateSixANANAS INSTANCE = new StateSixANANAS();

    private StateSixANANAS() {

    }

    public static StateSixANANAS getInstance() {
        return INSTANCE;
    }

    @Override
    public State change(char character) {
        return INSTANCE;
    }
}
