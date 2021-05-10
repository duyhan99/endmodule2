package com.vehicle.presentation;

import com.vehicle.service.VehicleService;

import java.util.Scanner;

public class MainVehicle {
    static MainVehicle mainVehicle = new MainVehicle();
    static VehicleService vehicleService = new VehicleService();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mainVehicle.status();
        mainVehicle.chooseMenu();

    }

    public void status(){
        System.out.println("-----Vehicle management-----");
    }

    public void displayMenu(){
        System.out.println("\t1. Show vehicle list");
        System.out.println("\t2. Add new vehicle");
        System.out.println("\t3. Update vehicle");
        System.out.println("\t4. Remove vehicle");
        System.out.println("\t5. Finding vehicle");
        System.out.println("\t6. Read from file");
        System.out.println("\t7. Write to file");
        System.out.println("\t8. Quit");
        System.out.println("--------------------------------------");


    }

    public void chooseMenu(){
        do {

            displayMenu();
            System.out.println("Your choice: ");
            String choose = sc.nextLine();

            switch (choose) {
                case "1":
                    vehicleService.displayVehicleList();
                    break;
                case "2":
                    vehicleService.addVehicle();
                    break;
                case "3":
                    vehicleService.updateVehicle();
                    break;
                case "4":
                    vehicleService.deleteVehicle();
                    break;
                case "5":
                    vehicleService.findVehicle();
                    break;
                case "6":
                    vehicleService.loadFile();
                    break;
                case "7":
                    vehicleService.writeFile();
                    System.out.println("Success!!");
                    break;
                case "8":
                    System.out.println("Good bye!!");
                    System.exit(0);
                default:
                    System.out.println("Error, again!!");
                    chooseMenu();
            }
        }while (true);
    }
}
