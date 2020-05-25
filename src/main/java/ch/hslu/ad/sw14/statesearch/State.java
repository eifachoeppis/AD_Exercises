package ch.hslu.ad.sw14.statesearch;

public interface State {
    State change(final char character);
}
