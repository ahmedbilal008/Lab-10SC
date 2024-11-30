package expressivo;

public class Multiplication implements Expression {
    private final Expression left;
    private final Expression right;

    public Multiplication(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof Multiplication)) return false;
        Multiplication that = (Multiplication) thatObject;
        return this.left.equals(that.left) && this.right.equals(that.right);
    }

    @Override
    public int hashCode() {
        return left.hashCode() * right.hashCode();
    }
}
