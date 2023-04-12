package com.digdes.school;

import com.digdes.school.models.Conditions;
import com.digdes.school.models.Query;
import com.digdes.school.services.Parser;
import com.digdes.school.utils.Database;
import com.digdes.school.models.Values;

import java.util.*;

import static com.digdes.school.services.Parser.parserString;

public class JavaSchoolStarter {

    private Database database;

    public JavaSchoolStarter() {
        database = new Database();
    }

    public List<Map<String, Object>> execute(String request) throws Exception {

        Query query = Parser.parserString(request);


        switch (Objects.requireNonNull(query).getMethod()) {
            case "INSERT" -> {
                return insert(query);

            }
            case "UPDATE" -> {
                return update(query);

            }
            case "DELETE" -> {
                return delete(query);

            }
            case "SELECT" -> {
                return select(query);

            }
            default -> {
                return null;
            }
        }


    }

    public List<Map<String, Object>> insert(Query query) {
        Map<String, Object> row = new HashMap<>();

        row.put("id", query.getValues().getId());
        row.put("lastName", query.getValues().getLastName());
        row.put("age", query.getValues().getAge());
        row.put("cost", query.getValues().getCost());
        row.put("active", query.getValues().isActive());


        database.getDataBase().add(row);
        List<Map<String, Object>> insertLines = new ArrayList<>();
        insertLines.add(row);
        return insertLines;

    }


    public List<Map<String, Object>> update(Query query) {
        List<Map<String, Object>> updateLines = new ArrayList<>();

        if ((query.getConditions()) == null) {


            for (int i = 0; i < database.getDataBase().size(); i++) {

                if ((query.getValues().getLastName()) != null) {
                    database.getDataBase().get(i).put("lastName", query.getValues().getLastName());
                    System.out.println(database.getDataBase().get(i));
                    updateLines.add(database.getDataBase().get(i));
                }

                if ((query.getValues().getId()) != null) {
                    database.getDataBase().get(i).put("id", query.getValues().getId());
                    System.out.println(database.getDataBase().get(i));
                    updateLines.add(database.getDataBase().get(i));
                }

                if ((query.getValues().getAge()) != null) {
                    database.getDataBase().get(i).put("age", query.getValues().getAge());
                    System.out.println(database.getDataBase().get(i));
                    updateLines.add(database.getDataBase().get(i));
                }

                if ((query.getValues().getCost()) != null) {
                    database.getDataBase().get(i).put("cost", query.getValues().getCost());
                    System.out.println(database.getDataBase().get(i));
                    updateLines.add(database.getDataBase().get(i));
                }

                if ((query.getValues().isActive() != null)) {
                    database.getDataBase().get(i).put("active", query.getValues().isActive());
                    System.out.println(database.getDataBase().get(i));
                    updateLines.add(database.getDataBase().get(i));
                }


            }

            return updateLines;

        } else {

            Conditions condition = query.getConditions().get(0);
            for (int i = 0; i < database.getDataBase().size(); i++) {
                if (database.getDataBase().get(i).get(condition.getKey()).equals(condition.getValue())) {
                    if ((query.getValues().getLastName()) != null) {
                        database.getDataBase().get(i).put("lastName", query.getValues().getLastName());
                        System.out.println(database.getDataBase().get(i));
                        updateLines.add(database.getDataBase().get(i));
                    }

                    if ((query.getValues().getId()) != null) {
                        database.getDataBase().get(i).put("id", query.getValues().getId());
                        System.out.println(database.getDataBase().get(i));
                        updateLines.add(database.getDataBase().get(i));
                    }

                    if ((query.getValues().getAge()) != null) {
                        database.getDataBase().get(i).put("age", query.getValues().getAge());
                        System.out.println(database.getDataBase().get(i));
                        updateLines.add(database.getDataBase().get(i));
                    }

                    if ((query.getValues().getCost()) != null) {
                        database.getDataBase().get(i).put("cost", query.getValues().getCost());
                        System.out.println(database.getDataBase().get(i));
                        updateLines.add(database.getDataBase().get(i));
                    }

                    if ((query.getValues().isActive() != null)) {
                        database.getDataBase().get(i).put("active", query.getValues().isActive());
                        System.out.println(database.getDataBase().get(i));
                        updateLines.add(database.getDataBase().get(i));
                    }
                }


            }
        }
        return new ArrayList<>();
    }

    public List<Map<String, Object>> select(Query query) {
        List<Map<String, Object>> selectAllLines = new ArrayList<>();

        if ((query.getConditions()) == null) {
            selectAllLines.addAll(database.getDataBase());
            System.out.println(selectAllLines);

        }
        else {

            Conditions condition = query.getConditions().get(0);
            for (int i = 0; i < database.getDataBase().size(); i++) {
                if (database.getDataBase().get(i).get(condition.getKey()).equals(condition.getValue())) {
                    selectAllLines.add(database.getDataBase().get(i));

                }
            }
            System.out.println(selectAllLines);

        }
        return selectAllLines;
    }


    public List<Map<String, Object>> delete(Query query) {
        List<Map<String, Object>> deleteLines = new ArrayList<>();

        if ((query.getConditions()) == null) {
            deleteLines.addAll(database.getDataBase());
            database.setBataBase(new ArrayList<>());
            //System.out.println(deleteLines);

        } else {

            Conditions condition = query.getConditions().get(0);
            for (int i = 0; i < database.getDataBase().size(); i++) {
                if (database.getDataBase().get(i).get(condition.getKey()).equals(condition.getValue())) {
                    deleteLines.add(database.getDataBase().get(i));
                    database.getDataBase().remove(i);
                }
            }

        }
        return deleteLines;


    }
}







