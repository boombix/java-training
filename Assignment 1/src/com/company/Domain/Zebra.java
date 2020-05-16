package com.company.Domain;

public class Zebra implements Animal{
    private String colour;
    private String name;
    private double weight;
    private String className = "zebra";
    public int ID;

    public Zebra(int ID, String colour, String name, double weight)
    {
        this.ID = ID;
        this.colour = colour;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getClassName(){
        return className;
    }

    @Override
    public void speak() {
        System.out.println("Nihaha!");
    }

    @Override
    public String getColor() {
        return this.colour;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void printAnimal() {
        String printingString = "The zebra named " + this.name + " has colour " + this.colour + " and he weights " + this.weight + " kg\n";
        System.out.print(printingString);
    }
}
