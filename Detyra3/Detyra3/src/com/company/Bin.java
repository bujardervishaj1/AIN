package com.company;

import java.util.ArrayList;
import java.util.List;

public class Bin {

    private int capacity = 50;
    private int filled = 0;
    private List<Element> elements = new ArrayList<Element>();

    public boolean addElement(Element elem) {
        if (filled + elem.getValue() <= capacity) {
            filled += elem.getValue();
            elements.add(elem);
            return true;
        }

        return false;
    }


    public int getCapacity() {
        return capacity;
    }

    public int getFilled() {
        return filled;
    }

    public String toString() {

        String ret = new String();
        for (int i = 0; i < elements.size(); i++) {

            if (ret.length() > 0) {
                ret = ret + ',';
            }

            ret = ret + elements.get(i).toString();

        }

        return '[' + ret + ']';
    }
}
