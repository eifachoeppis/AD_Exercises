package ch.hslu.ad.sw01;

public interface Memory {
    Allocation malloc(int size);
    void free(Allocation allocation);
}
