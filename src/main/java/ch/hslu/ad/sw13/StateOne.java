package ch.hslu.ad.sw13;

public class StateOne implements WordState {
    private static final StateOne INSTANCE = new StateOne();

    private StateOne(){

    }

    public static StateOne getInstance(){
        return INSTANCE;
    }

    @Override
    public WordState zero() {
        return InvalidState.getInstance();
    }

    @Override
    public WordState one() {
        return StateTwo.getInstance();
    }
}
