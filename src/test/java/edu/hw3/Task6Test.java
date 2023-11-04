package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import edu.hw3.task6.StockMarketImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Добавление новой акции")
    void addStock() {
        // given
        StockMarket stockMarket = new StockMarketImpl();
        Stock stock1 = new Stock("AAPL", 150.0);
        Stock stock2 = new Stock("GOOGL", 2700.0);

        // when
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        Stock mostValuable = stockMarket.mostValuableStock();

        // then
        assertThat(mostValuable)
            .isEqualTo(stock2);
    }

    @Test
    @DisplayName("Удаление акции")
    void removeStock() {
        // given
        StockMarket stockMarket = new StockMarketImpl();
        Stock stock1 = new Stock("AAPL", 150.0);
        Stock stock2 = new Stock("GOOGL", 2700.0);

        // when
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.remove(stock2);
        Stock mostValuable = stockMarket.mostValuableStock();

        // then
        assertThat(mostValuable)
            .isEqualTo(stock1);
    }

    @Test
    @DisplayName("Поиск самой дорогой акции из трех")
    public void testMostValuableStock1() {
        // given
        StockMarket stockMarket = new StockMarketImpl();
        Stock stock1 = new Stock("AAPL", 150.0);
        Stock stock2 = new Stock("GOOGL", 2700.0);
        Stock stock3 = new Stock("TSLA", 800.0);

        // when
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);
        Stock mostValuable = stockMarket.mostValuableStock();

        // then
        assertThat(mostValuable)
            .isEqualTo(stock2);
    }

    @Test
    @DisplayName("Поиск самой дорогой акции на пустой бирже")
    public void testMostValuableStock2() {
        // given
        StockMarket stockMarket = new StockMarketImpl();

        // when
        Stock mostValuable = stockMarket.mostValuableStock();

        // then
        assertThat(mostValuable)
            .isEqualTo(null);
    }

    @Test
    @DisplayName("Поиск самой дорогой акции из трех одинаковых")
    public void testMostValuableStock3() {
        // given
        StockMarket stockMarket = new StockMarketImpl();
        Stock stock1 = new Stock("AAPL", 150.0);
        Stock stock2 = new Stock("GOOGL", 150.0);
        Stock stock3 = new Stock("TSLA", 150.0);

        // when
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);
        Stock mostValuable = stockMarket.mostValuableStock();

        // then
        assertThat(mostValuable)
            .isEqualTo(stock1);
    }
}
