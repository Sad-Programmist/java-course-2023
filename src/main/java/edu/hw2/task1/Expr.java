package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double constant) implements Expr {
        @Override
        public double evaluate() {
            return constant;
        }

        @Override
        public String toString() {
            return String.valueOf(constant);
        }
    }

    public record Negate(Expr expression) implements Expr {
        @Override
        public double evaluate() {
            if (expression == null) {
                return 0;
            }
            return -expression.evaluate();
        }

        @Override
        public String toString() {
            return "(-(" + expression + "))";
        }
    }

    public record Exponent(Expr expression, double pow) implements Expr {
        @Override
        public double evaluate() {
            if (expression == null) {
                return 0;
            }
            return Math.pow(expression.evaluate(), pow);
        }

        @Override
        public String toString() {
            return expression + "^" + pow;
        }
    }

    public record Addition(Expr expression1, Expr expression2) implements Expr {
        @Override
        public double evaluate() {
            if (expression1 == null || expression2 == null) {
                return 0;
            }
            return expression1.evaluate() + expression2.evaluate();
        }

        @Override
        public String toString() {
            return "(" + expression1 + "+" + expression2 + ")";
        }
    }

    public record Multiplication(Expr expression1, Expr expression2) implements Expr {
        @Override
        public double evaluate() {
            if (expression1 == null || expression2 == null) {
                return 0;
            }
            return expression1.evaluate() * expression2.evaluate();
        }

        @Override
        public String toString() {
            return "(" + expression1 + "*" + expression2 + ")";
        }
    }
}
