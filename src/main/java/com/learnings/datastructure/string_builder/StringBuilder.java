package com.learnings.datastructure.string_builder;

public class StringBuilder {

    private char [] builder = new char[20];

    private void append(String str) {

    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("Hi");
        builder.append(" ");
        builder.append("Hello");
        System.out.println(builder);
    }

    private void increaseSizeAndAddNewElement(String newElement) {
        char [] tempBuilder = new char[builder.length];
        for(int i = 0; i < builder.length; i++) {
            newBuilder[i] = builder[i];
        }
        newBuilder =
    }

    @Override
    public String toString() {
        return builder;
    }
}