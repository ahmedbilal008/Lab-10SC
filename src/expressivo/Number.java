package expressivo;

public class Number implements Expression {
    private final double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof Number)) return false;
        Number that = (Number) thatObject;
        return this.value == that.value;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}
