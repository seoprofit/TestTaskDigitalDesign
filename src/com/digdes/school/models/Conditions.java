package com.digdes.school.models;

public class Conditions {
    private String key;
    private String value;

    private Relatiion relation;

    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Relatiion getRelation() {
        return relation;
    }

    public void setRelation(Relatiion relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }
}

