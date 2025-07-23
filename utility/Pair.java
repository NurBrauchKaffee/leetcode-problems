package utility;

public class Pair<T, V> {
    private final T p1;
    private final V p2;

    public Pair(T p1, V p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public T first() {
        return p1;
    }

    public V second() {
        return p2;
    }
}
