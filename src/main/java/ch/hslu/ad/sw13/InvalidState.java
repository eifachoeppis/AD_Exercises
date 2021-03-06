package ch.hslu.ad.sw13;

public class InvalidState implements WordState{

    private static final InvalidState INSTANCE = new InvalidState();

    private InvalidState(){

    }

    public static InvalidState getInstance(){
        return INSTANCE;
    }

    @Override
    public WordState zero() {
        return INSTANCE;
    }

    @Override
    public WordState one() {
        return INSTANCE;
    }
}
