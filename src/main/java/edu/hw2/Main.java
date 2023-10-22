package edu.hw2;

import edu.hw2.task1.Expr.Addition;
import edu.hw2.task1.Expr.Constant;
import edu.hw2.task1.Expr.Exponent;
import edu.hw2.task1.Expr.Multiplication;
import edu.hw2.task1.Expr.Negate;
import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.CallingInfoUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) throws Exception {
        //Task 1
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        LOGGER.info(res + " = " + res.evaluate());

        //Task 2
        Rectangle rectangle = new Rectangle(10, 2);
        Square square = new Square(10);

        LOGGER.info("Area of a 10 by 2 rectangle = " + rectangle.area());
        LOGGER.info("Area of a 10 by 10 square = " + square.area());

        //Task 3
        PopularCommandExecutor defaultExecutor = new PopularCommandExecutor(new DefaultConnectionManager(), 1);
        defaultExecutor.updatePackages();

        PopularCommandExecutor faultyExecutor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        faultyExecutor.updatePackages();

        //Task 4
        CallingInfo callingInfo = CallingInfoUtil.callingInfo();
        LOGGER.info(
            "Class name is \"" + callingInfo.className() + "\" and method name is \"" + callingInfo.methodName()
                + "\"");
    }
}
