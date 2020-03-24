package ch.hslu.ad.sw02.stack;

public class ArrayStack implements Stack {

    private int count = 0;
    private String[] memory;

    public ArrayStack(int size) {
        this.memory = new String[size];
    }

    @Override
    public void push(String item) throws Exception {
        if (count == memory.length) {
            throw new Exception("Stackoverflow");
        }

        memory[count] = item;
        count++;
    }

    @Override
    public String pop() throws Exception {
        if (count == 0) {
            throw new Exception("Stack is Empty");
        }

        count--;
        String item = memory[count];
        // Damit Objekt vom GC abgeräumt wird
        memory[count] = null;

        return item;
    }

    public int getCount() {
        return this.count;
    }
}
