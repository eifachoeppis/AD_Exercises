package ch.hslu.ad.sw13;

public class StateTwo implements WordState {

    private static final StateTwo INSTANCE = new StateTwo();

    private StateTwo(){

    }

    public static StateTwo getInstance(){
        return INSTANCE;
    }

    @Override
    public WordState zero() {
        return StateFour.getInstance();
    }

    @Override
    public WordState one() {
        return StateThree.getInstance();
    }
}
