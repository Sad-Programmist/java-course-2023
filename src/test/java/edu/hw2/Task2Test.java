package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle(5, 2)),
            Arguments.of(new Square(5))
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect.setWidth(20);
        rect.setHeight(10);

        assertThat(rect.area()).isEqualTo(200.0);
    }

    @Test
    @DisplayName("Площадь прямоугольника 20 на 30")
    void rectangleArea1() {
        //given
        Rectangle rectangle = new Rectangle(20, 30);

        // when
        double area = rectangle.area();

        // then
        assertThat(area)
            .isEqualTo(600.0);
    }

    @Test
    @DisplayName("Площадь прямоугольника -20 на -30")
    void rectangleArea2() {
        //given
        Rectangle rectangle = new Rectangle(-20, -30);

        // when
        double area = rectangle.area();

        // then
        assertThat(area)
            .isEqualTo(0.0);
    }

    @Test
    @DisplayName("Установка значений высоты и длины прямоугольника на 3 и 2")
    void rectangleSet1() {
        //given
        Rectangle rectangle = new Rectangle(0, 0);

        // when
        rectangle.setHeight(3);
        rectangle.setWidth(2);

        // then
        assertThat(rectangle.area())
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Установка значений высоты и длины прямоугольника на -100 и -100")
    void rectangleSet2() {
        //given
        Rectangle rectangle = new Rectangle(0, 0);

        // when
        rectangle.setHeight(-100);
        rectangle.setWidth(-100);

        // then
        assertThat(rectangle.area())
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Площадь квадрата 20 на 20")
    void squareArea1() {
        //given
        Square square = new Square(20);

        // when
        double area = square.area();

        // then
        assertThat(area)
            .isEqualTo(400.0);
    }

    @Test
    @DisplayName("Площадь квадрата -20 на -20")
    void squareArea2() {
        //given
        Square square = new Square(-20);

        // when
        double area = square.area();

        // then
        assertThat(area)
            .isEqualTo(0.0);
    }

    @Test
    @DisplayName("Установка значений стороны квадарата на 3")
    void squareSet1() {
        //given
        Square square = new Square(0);

        // when
        square.setHeight(3);
        square.setWidth(3);

        // then
        assertThat(square.area())
            .isEqualTo(9);
    }

    @Test
    @DisplayName("Установка значений стороны квадарата на -100")
    void squareSet2() {
        //given
        Square square = new Square(0);

        // when
        square.setHeight(-100);
        square.setWidth(-100);

        // then
        assertThat(square.area())
            .isEqualTo(0);
    }
}
