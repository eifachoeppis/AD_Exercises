package ch.hslu.ad.sw13;

public class StateFour implements WordState {

    private static final StateFour INSTANCE = new StateFour();

    private StateFour(){

    }

    public static StateFour getInstance(){
        return INSTANCE;
    }

    @Override
    public WordState Zero() {
        return InvalidState.getInstance();
    }

    @Override
    public WordState One() {
        return StateTwo.getInstance();
    }
}
