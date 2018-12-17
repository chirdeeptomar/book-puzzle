package com.connectt.puzzle.models;

/**
 * Represents an entry in the b0dy table
 *
 */
public class Body {

    private int id;
    private String text;

    public Body(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
