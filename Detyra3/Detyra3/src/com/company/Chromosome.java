package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Chromosome {
    private List<Bin> bins = new ArrayList<Bin>();
    private double fitness = 0;

    public double fitness() {
        double sum = 0;
        double F, f, c, k;

        k = 2;

        for (int i = 0; i < bins.size(); i++) {
            f = bins.get(i).getFilled();
            c = bins.get(i).getCapacity();
            sum = sum + Math.pow(f / c, k);
        }

        F = sum / bins.size();

        return F;
    }

    public void setFitness() {
        this.fitness = fitness();
    }

    public Double getFitness() {
        setFitness();

        return fitness;
    }

    public int countBins() {
        return this.bins.size();
    }

    public void insertRandom(List<Element> items) {
        firstFitItems(shuffleList(items));
    }


    private void firstFitItems(List<Element> items) {
        for (int i = 0; i < items.size(); i++) {
            Element elem = items.get(i);

            for (int j = 0; j < bins.size(); j++) {
                if (bins.get(j).addElement(elem)) {
                    return;
                }
            }

            Bin bin = new Bin();
            bin.addElement(elem);
            bins.add(bin);
        }
    }

    public static List<Element> shuffleList(List<Element> items) {
        long seed = System.nanoTime();
        Collections.shuffle(items, new Random(seed));

        return items;
    }


}
