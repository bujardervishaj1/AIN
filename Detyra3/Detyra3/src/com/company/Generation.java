package com.company;

import java.util.ArrayList;
import java.util.List;

public class Generation {

    private List<Chromosome> population = new ArrayList<Chromosome>();
    private List<Double> fitnessArr;
    private double bestFitOnGeneration = 0;

    public static Generation initFirstGeneration(List<Element> items, int sop) {
        Generation gen = new Generation();

        for (int i = 0; i < sop; i++) {
            Chromosome chromosome = new Chromosome();
            chromosome.insertRandom(items);
            gen.addChromosome(chromosome);
        }

        return gen;
    }

    private void addChromosome(Chromosome chromosome) {
        population.add(chromosome);
    }

    public Integer bestBinsCount;

    public void countFitness() {
        this.fitnessArr = new ArrayList<Double>();

        for (int i = 0; i < population.size(); i++) {
            this.fitnessArr.add(this.population.get(i).getFitness());

            if (this.bestFitOnGeneration < this.population.get(i).getFitness()) {

                this.bestFitOnGeneration = this.population.get(i).getFitness();
                this.bestBinsCount = this.population.get(i).countBins();

            }

        }
    }


}
