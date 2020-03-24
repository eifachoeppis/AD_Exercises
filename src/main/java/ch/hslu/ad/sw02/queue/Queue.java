package ch.hslu.ad.sw02.queue;

public interface Queue {
    void queue(char item) throws Exception;
    char dequeue() throws Exception;
    int getCount();
}
