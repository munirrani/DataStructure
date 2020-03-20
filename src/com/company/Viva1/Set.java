package com.company.Viva1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Set<T> {

    private ArrayList<T> arrayList;

    public Set(T[] arr) {
        arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) arrayList.add(arr[i]);
        }
    }

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public Set union(Set<T> newSet) {
        ArrayList<T> newArrayList = new ArrayList<>();
        newArrayList.addAll(arrayList);
        for (int i = 0; i < newSet.getArrayList().size(); i++) {
            if (!newArrayList.contains(newSet.getArrayList().get(i))) {
                newArrayList.add(newSet.getArrayList().get(i));
            }
        }
        return new Set((T[])newArrayList.toArray());
    }

    public Set intersection(Set<T> newSet) {
        ArrayList<T> newArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < newSet.getArrayList().size(); j++) {
                if (arrayList.get(i) == newSet.getArrayList().get(j)) {
                    newArrayList.add(arrayList.get(i));
                }
            }
        }
        return new Set((T[])newArrayList.toArray());
    }

    public Set complement(Set<T> newSet) {
        ArrayList<T> newArrayList = new ArrayList<>();
        newArrayList.addAll(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < newSet.getArrayList().size(); j++) {
                if (arrayList.get(i) == newSet.getArrayList().get(j)) {
                    newArrayList.remove(newArrayList.indexOf(arrayList.get(i)));
                }
            }
        }
        return new Set<T>((T[])newArrayList.toArray());
    }

    public boolean isSet(Set<T> set) {
        if(arrayList.containsAll(set.getArrayList())) return false;
        for (int j = 0; j < arrayList.size(); j++) {
            if (!set.getArrayList().contains(arrayList.get(j))) {
                return false;
            }
        }
        return true;
    }

    public int cardinality() {
        return arrayList.size();
    }

    public String toString() {
        String str = "{ ";
        for (int i = 0; i < arrayList.size(); i++) {
            str += arrayList.get(i) + ", ";
        }
        str += "}";
        str = str.replace(", }", " }");
        return str;
    }

    public Set PowerSet() {
        int powerSetSize = (int) Math.pow(2, cardinality());
        T[] powerSetElementArray = (T[]) getArrayList().toArray(); // Default set
        ArrayList<Set<T>> powerSetSubset = new ArrayList<>();
        ArrayList<T> elements = new ArrayList<>();
        for (int i = 0; i < powerSetSize; i++) {
            for (int j = 0; j < powerSetElementArray.length; j++) {
                if ((i & (1 << j)) > 0) {
                    elements.add(powerSetElementArray[j]);
                }
            }
            powerSetSubset.add(new Set(elements.toArray()));
            elements.clear();
        }

        //Sort the ArrayList<Set<T>> in ascending order size
        for (int i = 0; i < powerSetSubset.size() - 1; i++) {
            for (int j = 0; j < powerSetSubset.size() - 1; j++) {
                ArrayList<T> firstSet = powerSetSubset.get(j).getArrayList();
                ArrayList<T> secondSet = powerSetSubset.get(j+1).getArrayList();
                if (firstSet.size() > secondSet.size()) {
                    Collections.swap(powerSetSubset, j, j+1);
                } else if (firstSet.size() == secondSet.size()) {
                    int elem1;
                    int elem2;
                    for (int a = 0; a < firstSet.size(); a++) {
                        elem1 = (int) firstSet.get(a);
                        elem2 = (int) secondSet.get(a);
                        if (elem1 > elem2) {
                            Collections.swap(powerSetSubset, j, j+1);
                            break;
                        }
                    }
                }

            }
        }
        return new Set(powerSetSubset.toArray());
    }
}
