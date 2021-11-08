package com.company;

public class Main {

    public static void main(String[] args) {
        int elements[] = {5, 3, 2, 6, 3, 1, 8, 7, 1, 2, 4, 1, 6, 2, 3, 4, 5, 2, 3, 2, 6, 1, 1, 8, 7, 1, 2, 4, 1, 2, 2, 3, 4, 5, 2, 3, 2, 6, 1, 1, 8, 7, 1, 2, 4, 1, 1, 2, 3, 4, 5, 2, 3, 2, 6, 1, 1, 8, 7, 1, 2, 4, 7, 1, 2, 3, 4, 5, 2, 3, 5, 6, 1, 1, 8, 7, 1, 2, 4, 1, 1, 2, 3, 4, 5, 2};

        Generation gen = Generation.initFirstGeneration(Element.intArrToList(elements), 100);
        gen.countFitness();

    }
}
