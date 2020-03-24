package ch.hslu.ad.sw02.stack;

public interface Stack {
    void push(String item) throws Exception;
    String pop() throws Exception;
    int getCount();
}
