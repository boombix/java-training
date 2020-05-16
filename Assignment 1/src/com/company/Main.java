package com.company;

import com.company.Repository.AnimalRepository;
import com.company.Repository.EmployeeRepository;
import com.company.Service.Service;
import com.company.UI.UI;

public class Main {

    public static void main(String[] args) {
	    AnimalRepository animalRepository = new AnimalRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Service service = new Service(animalRepository, employeeRepository);
        UI ui = new UI(service);
        ui.startApp();
    }
}
