package edu.hw2;

import edu.hw2.task1.Expr.Addition;
import edu.hw2.task1.Expr.Constant;
import edu.hw2.task1.Expr.Exponent;
import edu.hw2.task1.Expr.Multiplication;
import edu.hw2.task1.Expr.Negate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

public class Task1Test {
    @Test
    @DisplayName("Вычисление значения константы 2")
    void constant1() {
        // given
        var constant = new Constant(2);

        // when
        double constantEvaluate = constant.evaluate();

        // then
        assertThat(constantEvaluate)
            .isCloseTo(2, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения константы -4.1")
    void constant2() {
        // given
        var constant = new Constant(-4.1);

        // when
        double constantEvaluate = constant.evaluate();

        // then
        assertThat(constantEvaluate)
            .isCloseTo(-4.1, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения константы 1 с инвертированным знаком")
    void negate1() {
        // given
        var negConstant = new Negate(new Constant(1));

        // when
        double negConstantEvaluate = negConstant.evaluate();

        // then
        assertThat(negConstantEvaluate)
            .isCloseTo(-1, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения суммы (40 + 50) с инвертированным знаком")
    void negate2() {
        // given
        var negConstant = new Negate(new Addition(new Constant(40), new Constant(50)));

        // when
        double negConstantEvaluate = negConstant.evaluate();

        // then
        assertThat(negConstantEvaluate)
            .isCloseTo(-90, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения null с инвертированным знаком")
    void negate3() {
        // given
        var negConstant = new Negate(null);

        // when
        double negConstantEvaluate = negConstant.evaluate();

        // then
        assertThat(negConstantEvaluate)
            .isCloseTo(0, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения суммы (2.5 + 9)")
    void addition1() {
        // given
        var sum = new Addition(new Constant(2.5), new Constant(9));

        // when
        double sumEvaluate = sum.evaluate();

        // then
        assertThat(sumEvaluate)
            .isCloseTo(11.5, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения суммы (-1 + 5.1 * 0.1)")
    void addition2() {
        // given
        var sum = new Addition(new Negate(new Constant(1)),
            new Multiplication(new Constant(5.1), new Constant(0.1)));

        // when
        double sumEvaluate = sum.evaluate();

        // then
        assertThat(sumEvaluate)
            .isCloseTo(-0.49, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения суммы (null + 1)")
    void addition3() {
        // given
        var sum = new Addition(null, new Constant(1));

        // when
        double sumEvaluate = sum.evaluate();

        // then
        assertThat(sumEvaluate)
            .isCloseTo(0, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения произведения (2 * 2)")
    void multiplication1() {
        // given
        var multiplication = new Multiplication(new Constant(2), new Constant(2));

        // when
        double multiplicationEvaluate = multiplication.evaluate();

        // then
        assertThat(multiplicationEvaluate)
            .isCloseTo(4, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения произведения (-2 * (3.3 + 2.2))")
    void multiplication2() {
        // given
        var multiplication = new Multiplication(new Negate(new Constant(2)),
            new Addition(new Constant(3.3), new Constant(2.2)));

        // when
        double multiplicationEvaluate = multiplication.evaluate();

        // then
        assertThat(multiplicationEvaluate)
            .isCloseTo(-11, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения произведения (5 * null)")
    void multiplication3() {
        // given
        var multiplication = new Multiplication(new Constant(5), null);

        // when
        double multiplicationEvaluate = multiplication.evaluate();

        // then
        assertThat(multiplicationEvaluate)
            .isCloseTo(0, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения возведения в степень (5.3^2)")
    void exponent1() {
        // given
        var exponent = new Exponent(new Constant(5.3), 2);

        // when
        double exponentEvaluate = exponent.evaluate();

        // then
        assertThat(exponentEvaluate)
            .isCloseTo(28.09, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения возведения в степень ((9 * 9)^0.5)")
    void exponent2() {
        // given
        var exponent = new Exponent(new Multiplication(new Constant(9), new Constant(9)), 0.5);

        // when
        double exponentEvaluate = exponent.evaluate();

        // then
        assertThat(exponentEvaluate)
            .isCloseTo(9, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения возведения в степень (null^5)")
    void exponent3() {
        // given
        var exponent = new Exponent(null, 5);

        // when
        double exponentEvaluate = exponent.evaluate();

        // then
        assertThat(exponentEvaluate)
            .isCloseTo(0, within(1e-10));
    }

    @Test
    @DisplayName("Вычисление значения выражения (((2.0+4.0)*(-(1.0)))^2.0+1.0)")
    void expression() {
        // given
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        // when
        double resEvaluate = res.evaluate();

        // then
        assertThat(resEvaluate)
            .isCloseTo(37, within(1e-10));
    }

    @Test
    @DisplayName("Строковое представление выражения (((2.0+4.0)*(-(1.0)))^2.0+1.0)")
    void expressionString() {
        // given
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        // when
        String resString = res.toString();

        // then
        assertThat(resString)
            .isEqualTo("(((2.0+4.0)*(-(1.0)))^2.0+1.0)");
    }
}
