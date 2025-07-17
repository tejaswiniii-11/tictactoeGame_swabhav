package com.aurionpro.models;

public class Player implements IPlayer {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
