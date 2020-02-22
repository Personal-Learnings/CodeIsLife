package com.learnings.practise.designpatterns;

import java.util.Locale;

/**
 * When we want to choose implementation at runtime or we are not aware of the
 * implementation during compile time we will go for factory.
 * All of the subclasses should have the same hierarchy (Same Super Class).
 */
public class Factory {
    public static Language create(Locale locale) {
        if(locale != null && locale.equals(Locale.ENGLISH)) return new English();
        else return new Tamil();
    }
}

interface Language {
    String greet();
}

class English implements Language {
    @Override
    public String greet() { return "Hello"; }
}

class Tamil implements Language {
    @Override
    public String greet() { return "வணக்கம்"; }
}

class Runner {
    public static void main(String[] args) {
        Language language = Factory.create(Locale.ENGLISH);
        System.out.println(language.greet());

        language = Factory.create(null);
        System.out.println(language.greet());
    }
}