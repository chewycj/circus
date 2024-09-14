package circus;

import circus.animal.*; // try not to have wildcards

import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

import static circus.animal.Animal.AnimalNameComparator;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    private static void printNumberOfAnimalsInCircus(String animalArrayList) {
        System.out.println(animalArrayList);
    }

    public static void main(String[] args) {
        System.out.println("Number of animals in the array are: " + animals.length);
        // animals[3] = new Elephant("Eli");
        ArrayList<Animal> animalArrayList = new ArrayList<Animal>(Arrays.asList(animals));

        printAllAnimals(animalArrayList);
        printNumberOfAnimalsInCircus("Size of our animal array list: " + animalArrayList.size());

        Elephant strongOne = new Elephant("Strong One");
        animalArrayList.add(strongOne);
        Duck andy = new Duck("Andy");
        animalArrayList.add(andy);

        printAllAnimals(animalArrayList);
        printNumberOfAnimalsInCircus("Size of our animal array list: " + animalArrayList.size());

        System.out.println("Before sorting...");
        System.out.println("Strong One is in position: " + (animalArrayList.indexOf(strongOne)+1));

        animalArrayList.sort(AnimalNameComparator);

        System.out.println("After sorting...");
        printAllAnimals(animalArrayList);
        //makeAnimalsTalk();
        //System.out.println("Total value of animals " + calculateAssetValue(animals));
        //System.out.println("Total value of equipments " + calculateAssetValue(equipments));


        animalArrayList.add(new Tiger("Sherkhan"));
        System.out.println("Number of animals: " + animalArrayList.size());
        animalArrayList.add(strongOne);

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Henry");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Peter");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        Cage<Elephant> elephantCage = new Cage<>();
        elephantCage.lockUp(strongOne);
        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);
        cages.add(elephantCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
