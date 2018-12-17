package com.connectt.puzzle.models;

public class Crypt {

    private int start;
    private int length;
    private int rotate;

    public Crypt(int start, int length, int rotate) {
        this.start = start;
        this.length = length;
        this.rotate = rotate;
    }

    public int getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public int getRotate() {
        return rotate;
    }
}
