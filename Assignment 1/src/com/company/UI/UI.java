package com.company.UI;
import com.company.Exceptions.RepositoryException;
import com.company.Exceptions.ValidationException;
import com.company.Service.*;
import com.company.Repository.*;
import com.company.Domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    Service service;
    Scanner scanner = new Scanner(System.in);

    public UI(Service service) {
        this.service = service;
    }

    private void printStartMenu() {
        System.out.println("1. Animals options");
        System.out.println("2. Employee options");
        System.out.println("3. Exit");
    }

    private void printAnimalsMenu() {
        System.out.println("1. Add an animal");
        System.out.println("2. Delete an animal");
        System.out.println("3. Print all animals");
        System.out.println("4. Print all animals of a given species");
        System.out.println("5. Go back");
    }

    private void printEmployeeMenu() {
        System.out.println("1. Add an employee");
        System.out.println("2. Delete an employee");
        System.out.println("3. Print all employee");
        System.out.println("4. Print all employees with a given name");
        System.out.println("5. Print administrator menu");
        System.out.println("6. Go back");
    }

    private void addAnimal() {
        double weight = 0;
        int ID = 0;
        System.out.println("What type of animal do you want to add?");
        System.out.println("1. Monkey");
        System.out.println("2. Zebra");
        System.out.println("3. Tiger");
        int command = scanner.nextInt();
        if (command != 1 && command != 2 && command != 3) {
            System.out.println("Give a valid option");
            return;
        }
        System.out.print("Give the ID of the animal: ");
        try{
            ID = scanner.nextInt();
        }
        catch(Exception exception)
        {
            System.out.println("Please enter a number!");
            return;
        }
        System.out.print("Give the name of the animal: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Give the colour of the animal: ");
        String colour = scanner.nextLine();
        System.out.print("Give the weight of the animal: ");
        try{
            weight = scanner.nextDouble();
        }
        catch(Exception exception)
        {
            System.out.println("Please enter a number!");
            return;
        }
        if (command == 1) {
            try{
            service.addMonkey(ID, colour, name, weight);
            }
            catch(ValidationException exception)
            {
                System.out.println(exception.getMessage());
            }
            catch (RepositoryException exception)
            {
                System.out.println(exception.getMessage());
            }
        }
        else if (command == 2) {
            try{
                service.addZebra(ID, colour, name, weight);
            }
            catch(ValidationException exception)
            {
                System.out.println(exception.getMessage());
            }
            catch (RepositoryException exception)
            {
                System.out.println(exception.getMessage());
            }

        }
        else if (command == 3)
        {
            try {
                service.addTiger(ID, colour, name, weight);
            }
            catch(ValidationException exception)
            {
                System.out.println(exception.getMessage());
            }
            catch (RepositoryException exception)
            {
                System.out.println(exception.getMessage());
            }
        }

    }

    private void printAllAnimals() {
        ArrayList<Animal> animals = service.getAnimals();
        for (Animal animal : animals)
            animal.printAnimal();

    }

    private void deleteAnimal() {
        System.out.print("Give the ID of the animal you want to delete: ");
        int ID = scanner.nextInt();
        try {
            service.deleteAnimal(ID);
        }
        catch (RepositoryException exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    private void printAnimalsBySpecies() {
        System.out.print("Give the species of the animal(monkey, tiger, zebra): ");
        scanner.nextLine();
        String species = scanner.nextLine();
        ArrayList<Animal> animals = service.getAnimalsBySpecies(species);
        for (Animal animal : animals)
            animal.printAnimal();

    }

    private void addEmployee() {
        int ID = 0, salary = 0;
        System.out.print("Give the ID of the employee: ");
        try{
            ID = scanner.nextInt();
        }
        catch(Exception exception)
        {
            System.out.println("Please enter a number!");
            return;
        }
        System.out.print("Give the name of the employee: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Give the sector of work of the employee: ");
        String occupation = scanner.nextLine();
        System.out.print("Give the age of the employee: ");
        int age = scanner.nextInt();
        System.out.print("Give the salary of the employee: ");
        try {
            salary = scanner.nextInt();
        }
        catch(Exception exception)
        {
            System.out.println("Please enter a number!");
            return;
        }
        try {
            service.addEmployee(ID, name, age, occupation, salary);
        }
        catch(ValidationException exception)
        {
            System.out.println(exception.getMessage());
        }
        catch (RepositoryException exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    private void deleteEmployee() {
        System.out.print("Give the ID of the employee you want to delete: ");
        int ID = scanner.nextInt();
        try {
            service.deleteEmployee(ID);
        }
        catch (RepositoryException exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    private void printAllEmployees() {
        ArrayList<Employee> employees = service.getEmployees();
        for (Employee employee : employees)
            employee.printEmployee();

    }

    private void printEmployeesByName() {
        System.out.print("Give the name of employees you want to search: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        ArrayList<Employee> employees = service.getEmployeesByName(name);
        for (Employee employee : employees)
            employee.printEmployee();
    }

    private void printAdministratorDetails() {
        Administrator admin = Administrator.getInstance();
        String adminPrintable = "The administrator name is " + admin.getName() + " aged " + admin.getAge();
        System.out.println(adminPrintable);
    }


    public void startApp() {
        boolean inApp = true;
        System.out.println("Welcome to the zoo managment app!\nSelect one of the options below");
        while (inApp) {
            this.printStartMenu();
            int option = scanner.nextInt();
            if (option == 1) {
                while (true) {
                    this.printAnimalsMenu();
                    scanner.nextLine();
                    int optionAnimal = scanner.nextInt();
                    if (optionAnimal == 1)
                        this.addAnimal();
                    else if (optionAnimal == 2)
                        this.deleteAnimal();
                    else if (optionAnimal == 3)
                        this.printAllAnimals();
                    else if (optionAnimal == 4)
                        this.printAnimalsBySpecies();
                    else if (optionAnimal == 5)
                        break;
                    else
                        System.out.println("Give a valid option");
                }
            } else if (option == 2) {
                while (true) {
                    this.printEmployeeMenu();
                    scanner.nextLine();
                    int optionEmployee = scanner.nextInt();
                    if (optionEmployee == 1)
                        this.addEmployee();
                    else if (optionEmployee == 2)
                        this.deleteEmployee();
                    else if (optionEmployee == 3)
                        this.printAllEmployees();
                    else if (optionEmployee == 4)
                        this.printEmployeesByName();
                    else if (optionEmployee == 5)
                        this.printAdministratorDetails();
                    else if (optionEmployee == 6)
                        break;
                    else
                        System.out.println("Give a valid option");
                }
            } else if (option == 3)
                inApp = false;
            else
                System.out.println("Give a valid option!");
            }
        }


}
