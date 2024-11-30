package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTest {

    // Tests for Number class
    @Test
    public void testNumberToString() {
        Expression e = new Number(5.0);
        assertEquals("5.0", e.toString());
    }

    @Test
    public void testNumberEquals() {
        Expression e1 = new Number(5.0);
        Expression e2 = new Number(5.0);
        assertTrue(e1.equals(e2));
    }

    @Test
    public void testNumberNotEquals() {
        Expression e1 = new Number(5.0);
        Expression e2 = new Number(10.0);
        assertFalse(e1.equals(e2));
    }

    @Test
    public void testNumberHashCode() {
        Expression e1 = new Number(5.0);
        Expression e2 = new Number(5.0);
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testNumberHashCodeDifferentValues() {
        Expression e1 = new Number(5.0);
        Expression e2 = new Number(10.0);
        assertNotEquals(e1.hashCode(), e2.hashCode());
    }

    // Tests for Variable class
    @Test
    public void testVariableToString() {
        Expression e = new Variable("x");
        assertEquals("x", e.toString());
    }

    @Test
    public void testVariableEquals() {
        Expression e1 = new Variable("x");
        Expression e2 = new Variable("x");
        assertTrue(e1.equals(e2));
    }

    @Test
    public void testVariableNotEquals() {
        Expression e1 = new Variable("x");
        Expression e2 = new Variable("y");
        assertFalse(e1.equals(e2));
    }

    @Test
    public void testVariableHashCode() {
        Expression e1 = new Variable("x");
        Expression e2 = new Variable("x");
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testVariableHashCodeDifferentNames() {
        Expression e1 = new Variable("x");
        Expression e2 = new Variable("y");
        assertNotEquals(e1.hashCode(), e2.hashCode());
    }

    // Tests for Addition class
    @Test
    public void testAdditionToString() {
        Expression e = new Addition(new Number(5), new Variable("x"));
        assertEquals("5.0 + x", e.toString());
    }

    @Test
    public void testAdditionEquals() {
        Expression e1 = new Addition(new Number(5), new Variable("x"));
        Expression e2 = new Addition(new Number(5), new Variable("x"));
        assertTrue(e1.equals(e2));
    }

    @Test
    public void testAdditionNotEquals() {
        Expression e1 = new Addition(new Number(5), new Variable("x"));
        Expression e2 = new Addition(new Number(10), new Variable("x"));
        assertFalse(e1.equals(e2));
    }

    @Test
    public void testAdditionHashCode() {
        Expression e1 = new Addition(new Number(5), new Variable("x"));
        Expression e2 = new Addition(new Number(5), new Variable("x"));
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testAdditionHashCodeDifferent() {
        Expression e1 = new Addition(new Number(5), new Variable("x"));
        Expression e2 = new Addition(new Number(10), new Variable("y"));
        assertNotEquals(e1.hashCode(), e2.hashCode());
    }

    // Tests for Multiplication class
    @Test
    public void testMultiplicationToString() {
        Expression e = new Multiplication(new Variable("x"), new Variable("y"));
        assertEquals("x * y", e.toString());
    }

    @Test
    public void testMultiplicationEquals() {
        Expression e1 = new Multiplication(new Variable("x"), new Variable("y"));
        Expression e2 = new Multiplication(new Variable("x"), new Variable("y"));
        assertTrue(e1.equals(e2));
    }

    @Test
    public void testMultiplicationNotEquals() {
        Expression e1 = new Multiplication(new Variable("x"), new Variable("y"));
        Expression e2 = new Multiplication(new Variable("x"), new Variable("z"));
        assertFalse(e1.equals(e2));
    }

    @Test
    public void testMultiplicationHashCode() {
        Expression e1 = new Multiplication(new Variable("x"), new Variable("y"));
        Expression e2 = new Multiplication(new Variable("x"), new Variable("y"));
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testMultiplicationHashCodeDifferent() {
        Expression e1 = new Multiplication(new Variable("x"), new Variable("y"));
        Expression e2 = new Multiplication(new Variable("a"), new Variable("b"));
        assertNotEquals(e1.hashCode(), e2.hashCode());
    }

    // Additional Tests for edge cases
    @Test
    public void testAdditionAndMultiplicationEquals() {
        Expression e1 = new Addition(new Number(5), new Variable("x"));
        Expression e2 = new Addition(new Number(5), new Variable("x"));
        Expression e3 = new Multiplication(new Variable("x"), new Number(2));
        assertFalse(e1.equals(e3));  // Addition is not equal to Multiplication
    }

    @Test
    public void testComplexExpression() {
        Expression e = new Addition(new Multiplication(new Variable("x"), new Number(5)), new Variable("y"));
        assertEquals("x * 5.0 + y", e.toString());
    }

    @Test
    public void testMultiplicationWithNumber() {
        Expression e = new Multiplication(new Number(3), new Variable("z"));
        assertEquals("3.0 * z", e.toString());
    }

    @Test
    public void testAdditionWithNegative() {
        Expression e = new Addition(new Number(-5), new Variable("x"));
        assertEquals("-5.0 + x", e.toString());
    }
}
