package ch.hslu.ad.sw13;

public class StateThree implements WordState {

    private static final StateThree INSTANCE = new StateThree();

    private StateThree(){

    }

    public static StateThree getInstance(){
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
