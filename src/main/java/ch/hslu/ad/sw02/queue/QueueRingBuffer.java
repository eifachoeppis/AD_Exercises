package ch.hslu.ad.sw02.queue;

public class QueueRingBuffer implements Queue{
    private static final int SIZE = 8;
    private char[] buffer = new char[SIZE];
    int count = 0;
    private int readPointer = 0;
    private int writePointer = 0;

    @Override
    public void queue(char item) throws Exception{
        if (count == 8){
            throw new Exception("Queue is full");
        }

        buffer[writePointer] = item;
        writePointer++;
        count++;

        if (writePointer > 7){
            writePointer = 0;
        }
    }

    @Override
    public char dequeue() throws Exception{
        if (count == 0){
            throw new Exception("Queue is empty");
        }

        char item = buffer[readPointer];
        readPointer++;
        count--;

        if (readPointer > 7){
            readPointer = 0;
        }

        return item;
    }

    @Override
    public int getCount() {
        return this.count;
    }
}
