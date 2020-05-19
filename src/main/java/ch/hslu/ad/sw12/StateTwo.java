package ch.hslu.ad.sw12;

public class StateTwo implements WordState {

    private static final StateTwo INSTANCE = new StateTwo();

    private StateTwo(){

    }

    public static StateTwo getInstance(){
        return INSTANCE;
    }

    @Override
    public WordState Zero() {
        return StateFour.getInstance();
    }

    @Override
    public WordState One() {
        return StateThree.getInstance();
    }
}
