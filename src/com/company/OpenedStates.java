package com.company;

import javafx.util.Pair;

import java.util.*;

public class OpenedStates {

    TreeMap<Float, List<String>> open;

    public OpenedStates() {
        this.open = new TreeMap<>();
    }

    public void insert(float fValue, String state) {
        List<String> temp = new ArrayList<>();
        if (open.containsKey(fValue)) {
            temp = open.get(fValue);
        }
        temp.add(state);
        open.put(fValue, temp);
    }

    public Pair<String, Float> popMinValue() {
        Map.Entry<Float, List<String>> minFEntry = open.firstEntry();
        Pair<String, Float> minPair = new Pair<>(minFEntry.getValue().get(0), minFEntry.getKey());
        open.get(minFEntry.getKey()).remove(0);
        if (open.get(minFEntry.getKey()).isEmpty()) {
            open.remove(minFEntry.getKey());
        }
        return minPair;
    }

    public boolean isEmpty() {
        return open.isEmpty();
    }

    public boolean contains(String state) {
        boolean found = false;
        Collection<List<String>> values = open.values();
        for (List<String> value : values) {
            if (value.contains(state)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public float getFValue(String state) {
        float fValue = 0;
        for (Map.Entry<Float, List<String>> entry : open.entrySet()) {
            if (entry.getValue().contains(state)) {
                fValue = entry.getKey();
                break;
            }
        }
        return fValue;
    }

    public void update(String state, float fValue) {
        float oldFValue = getFValue(state);
        open.get(oldFValue).remove(state);
        if (open.get(oldFValue).isEmpty())
            open.remove(oldFValue);
        insert(fValue, state);
    }

    public int getLength() {
        Collection<List<String>> values = open.values();
        int len = 0;
        for (Map.Entry<Float, List<String>> val : open.entrySet()) {
            len += val.getValue().size();
        }
        return len;
    }
}
