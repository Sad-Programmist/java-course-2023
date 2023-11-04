package edu.hw3.task6;

public class Stock implements Comparable<Stock> {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public int compareTo(Stock otherStock) {
        return Double.compare(otherStock.price, this.price);
    }
}
