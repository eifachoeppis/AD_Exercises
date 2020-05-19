package ch.hslu.ad.sw12;

public class StateOne implements WordState {
    private static final StateOne INSTANCE = new StateOne();

    private StateOne(){

    }

    public static StateOne getInstance(){
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
