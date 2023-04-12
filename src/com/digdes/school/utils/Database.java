package com.digdes.school.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {
    private List<Map<String, Object>> dataBase = new ArrayList<>();

    public List<Map<String, Object>> getDataBase() {
        return dataBase;
    }

    public void setBataBase(List<Map<String, Object>> arrayList) {
        this.dataBase = arrayList;
    }
}
