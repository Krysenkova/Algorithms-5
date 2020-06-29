package Algorithmen.probing;

public class LinearProbing implements  IProbing {
    @Override
    public int probe(int key, int j) {
        return j;
    }
}
