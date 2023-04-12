package com.digdes.school.services;

import com.digdes.school.models.Conditions;
import com.digdes.school.models.Query;
import com.digdes.school.models.Relatiion;
import com.digdes.school.models.Values;

import javax.management.relation.Relation;
import java.util.*;

public class Parser {

    public static Query parserString(String s) {
        Query query = new Query();

        // если есть оператор "where"
        if (s.contains("where")) {
            // массив парааметров входной строки
            List<String> allInputArgs = new ArrayList<>(Arrays.asList(s.trim().split("where")));

            parseMethodsAndValues(allInputArgs.get(0), query);

            processWhereKey(allInputArgs.get(1), query);

        }

        // если нет оператора "where"
        else {


            parseMethodsAndValues(s, query);


        }


        return query;
    }

    public static void processWhereKey(String s, Query query) {

        List<Conditions> conditionsLst = new ArrayList<>();


        if (s.contains("and")) {

            List<String> inputConditions = new ArrayList<>(Arrays.stream(s.trim().replace("'", "").replace(",", "").split("and")).filter(w -> !(w.isEmpty())).toList());

            for (int i = 0; i < inputConditions.size(); i++) {
                conditionsLst.add(conditionsBuilder(inputConditions.get(i)));
            }
            query.setLogicOperator("and");

        } else if (s.contains("or")) {

            List<String> inputConditions = new ArrayList<>(Arrays.stream(s.trim().replace("'", "").replace(",", "").split("or")).filter(w -> !(w.isEmpty())).toList());

            for (int i = 0; i < inputConditions.size(); i++) {
                conditionsLst.add(conditionsBuilder(inputConditions.get(i)));
            }
            query.setLogicOperator("or");
        } else {
            conditionsLst.add(conditionsBuilder(s));
        }


        query.setConditions(conditionsLst);

        System.out.println(query);

    }

    public static Conditions conditionsBuilder(String s) {
        Conditions conditions = new Conditions();

        List<String> multiConditions = new ArrayList<>();

        Relatiion[] r1 = Relatiion.values();
        for (int i = 0; i < r1.length; i++) {
            if (s.contains(r1[i].getTitle())) {
                conditions.setRelation(r1[i]);
                multiConditions = sybmolHandler(r1[i].getTitle(), s);

            }

        }

        conditions.setKey(multiConditions.get(0));
        conditions.setValue(multiConditions.get(1));


        return conditions;
    }


    public static List<String> sybmolHandler(String symbol, String s) {  // age 10

        return new ArrayList<>(Arrays.stream(s.trim().replace(s, " ").replace(symbol, " ").replace(",", "").replace("'", "").split(" ")).filter(w -> !(w.isEmpty())).toList());


    }

    public static void parseMethodsAndValues(String s, Query query) {

        // массив значений из входной строки
        List<String> inputValuesAndMethod = new ArrayList<>(Arrays.stream(s.trim().replace("=", "").replace("'", "").replace(",", "").split(" ")).filter(w -> !(w.isEmpty())).toList());

        // заполнение полей объекта query
        query.setMethod(inputValuesAndMethod.get(0));
        inputValuesAndMethod.remove(0);

        try {
            if (inputValuesAndMethod.get(0).equalsIgnoreCase("VALUES")) {
                inputValuesAndMethod.remove(0);
            }
            Map<String, String> valuesObject = new HashMap<>();

            for (int i = 0; i < inputValuesAndMethod.size(); i = i + 2) {
                valuesObject.put(inputValuesAndMethod.get(i), inputValuesAndMethod.get(i + 1));
            }
            Values values = new Values();
            if (valuesObject.containsKey("age")) {
                values.setAge(Integer.parseInt(valuesObject.get("age")));
            }
            if (valuesObject.containsKey("lastName")) {
                values.setLastName(valuesObject.get("lastName"));
            }
            if (valuesObject.containsKey("cost")) {
                values.setCost(Integer.parseInt(valuesObject.get("cost")));
            }
            if (valuesObject.containsKey("active")) {
                values.setActive(Boolean.parseBoolean(valuesObject.get("active")));
            }
            if (valuesObject.containsKey("id")) {
                values.setId(Integer.parseInt(valuesObject.get("id")));
            }

            query.setValues(values);
        } catch (IndexOutOfBoundsException e) {

        }
    }

}
