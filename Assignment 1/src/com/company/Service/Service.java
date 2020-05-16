package com.company.Service;
import com.company.Exceptions.RepositoryException;
import com.company.Exceptions.ValidationException;
import com.company.Repository.*;
import com.company.Domain.*;

import com.company.Repository.AnimalRepository;
import com.company.Validators.AnimalValidator;
import com.company.Validators.EmployeeValidator;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class Service {
    private AnimalRepository aRepo;
    private EmployeeRepository eRepo;

    public Service(AnimalRepository repositoryAnimals, EmployeeRepository repositoryEmployees)
    {
        this.aRepo = repositoryAnimals;
        this.eRepo = repositoryEmployees;
    }

    public void addTiger(int ID, String colour, String name, double weight) throws RepositoryException, ValidationException {
        Tiger tiger = new Tiger(ID, colour, name, weight);
        try {
            AnimalValidator.validate(tiger);
            aRepo.addElement(tiger);
        }
        catch(ValidationException exception)
        {
            throw exception;
        }
        catch(RepositoryException exception)
        {
            throw exception;
        }

    }

    public void addMonkey(int ID, String colour, String name, double weight) throws RepositoryException, ValidationException {
        Monkey monkey = new Monkey(ID, colour, name, weight);
        try {
            AnimalValidator.validate(monkey);
            aRepo.addElement(monkey);
        }
        catch(ValidationException exception)
        {
            throw exception;
        }
        catch(RepositoryException exception)
        {
            throw exception;
        }
    }

    public void addZebra(int ID, String colour, String name, double weight) throws RepositoryException, ValidationException {
        Zebra zebra = new Zebra(ID, colour, name, weight);
        try {
            AnimalValidator.validate(zebra);
            aRepo.addElement(zebra);
        }
        catch(ValidationException exception)
        {
            throw exception;
        }
        catch(RepositoryException exception)
        {
            throw exception;
        }
    }

    public void addEmployee(int ID, String name, int age, String occupation, int salary) throws RepositoryException, ValidationException {
        Employee employee = new Employee(ID, name, age, occupation, salary);
        try {
            EmployeeValidator.validate(employee);
            eRepo.addElement(employee);
        }
        catch(ValidationException exception)
        {
            throw exception;
        }
        catch(RepositoryException exception)
        {
            throw exception;
        }
    }

    public void deleteAnimal(int ID) throws RepositoryException {
        try {
            aRepo.deleteElement(ID);
        }
        catch(RepositoryException exception)
        {
            throw exception;
        }
    }

    public void deleteEmployee(int ID) throws RepositoryException {
        try {
            eRepo.deleteElement(ID);
        }
        catch(RepositoryException exception)
        {
            throw exception;
        }
    }

    public ArrayList<Animal> getAnimals(){
        return aRepo.getElements();
    }

    public ArrayList<Employee> getEmployees(){
        return eRepo.getElements();
    }

    public ArrayList<Animal> getAnimalsBySpecies (String species){
        return aRepo.getAllElementsbySpecies(species);
    }

    public ArrayList<Employee> getEmployeesByName(String name){
        return eRepo.getAllElementsbyName(name);
    }
}
