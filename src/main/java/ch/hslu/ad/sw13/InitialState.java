package ch.hslu.ad.sw13;

public class InitialState implements WordState{
    private static final InitialState INSTANCE = new InitialState();
    private InitialState(){

    }

    public static InitialState getInstance(){
        return INSTANCE;
    }

    @Override
    public WordState Zero() {
        return StateOne.getInstance();
    }

    @Override
    public WordState One() {
        return InvalidState.getInstance();
    }
}
