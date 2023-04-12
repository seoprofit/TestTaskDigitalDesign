package com.digdes.school.models;

public enum Relatiion {
    MORE (">"),
    LESS ("<"),

    MORE_EQUALS (">="),
    LESS_EQUALS ("<="),

    LIKE ("like"),

    QUALIFIER_LIKE ("ilike"),
    EQUALS ("="),
    NOT_EQUALS ("!=");

    private final String title;

    Relatiion (String title)
    {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Relatiion{" +
                "title='" + title + '\'' +
                '}';
    }
}
