package ch.hslu.ad.sw12;

public class StateThree implements WordState {

    private static final StateThree INSTANCE = new StateThree();

    private StateThree(){

    }

    public static StateThree getInstance(){
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
