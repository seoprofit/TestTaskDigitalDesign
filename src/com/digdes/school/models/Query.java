package com.digdes.school.models;

import java.util.List;

public class Query {
    private String method;
    private Values values;
    private List <Conditions> conditions;
    private String logicOperator;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Values getValues() {
        return values;
    }

    public void setValues(Values values) {
        this.values = values;
    }

    public List<Conditions> getConditions() {
        return conditions;
    }

    public void setConditions(List<Conditions> conditions) {
        this.conditions = conditions;
    }

    public String getLogicOperator() {
        return logicOperator;
    }

    public void setLogicOperator(String logicOperator) {
        this.logicOperator = logicOperator;
    }

    @Override
    public String toString() {
        return "Query{" +
                "method='" + method + '\'' +
                ", values=" + values +
                ", conditions=" + conditions +
                ", logicOperator='" + logicOperator + '\'' +
                '}';
    }
}

