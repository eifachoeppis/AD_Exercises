package ch.hslu.ad.sw12;

public class InvalidState implements WordState{

    private static final InvalidState INSTANCE = new InvalidState();

    private InvalidState(){

    }

    public static InvalidState getInstance(){
        return INSTANCE;
    }

    @Override
    public WordState Zero() {
        return INSTANCE;
    }

    @Override
    public WordState One() {
        return INSTANCE;
    }
}
