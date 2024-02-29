package repetition.util;

public class RTPair<T, G> {
    private final T first;
    private final G second;

    public RTPair(final T first, final G second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public G getSecond() {
        return second;
    }
}
