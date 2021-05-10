package com.vehicle.service;

import com.vehicle.dal.VehicleDB;
import com.vehicle.model.Vehicle;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehicleService {
    VehicleDB vehicleDB = new VehicleDB();
    Scanner sc = new Scanner(System.in);

    public void loadFile(){
        vehicleDB.read();
    }

    public void writeFile(){
        vehicleDB.write();
    }

    public void readFile(){
        displayHeader();
        for (Vehicle vh : vehicleDB.vehicleList){
            vh.displayVehicle();
        }
    }

    public void findVehicle(){
        boolean check = false;
        System.out.println("Input chassis number or name of the vehicle");
        String chas = sc.nextLine();
        String name = sc.nextLine();
        for (Vehicle vehicle : vehicleDB.vehicleList){
            if (vehicle.getChassisNumber().equals(chas) || vehicle.getName().equals(name)){
                check = true;
                displayHeader();
                vehicle.displayVehicle();
            }
        }
        if (!check){
            System.out.println("Invalid number!!!");
        }
    }

    public void deleteVehicle(){
        boolean check = false;
        System.out.println("Input chassis number of the Vehicle");
        String chas = sc.nextLine();
        for (int i = 0; i < vehicleDB.vehicleList.size(); i++){
            if (vehicleDB.vehicleList.get(i).getChassisNumber().equals(chas)){
                check = true;
                Vehicle temp = vehicleDB.vehicleList.get(i);
                vehicleDB.write();
                displayHeader();
                temp.displayVehicle();
                System.out.println("You just remove " + temp.getName() + " success!!");
            }
        }
        if (!check){
            System.out.println("Invalid number!!!");
        }
    }

    public void addVehicle(){
        String name = inputName();
        System.out.println("Chassis number: ");
        String chas = sc.nextLine();
        String type = inputType();
        String year = inputYear();
        String color = inputColor();
        String manuf = inputManu();
        Vehicle vh = new Vehicle(0,name,chas,type,year,color,manuf);
        vehicleDB.vehicleList.add(vh);
        vehicleDB.write();
        displayHeader();
        vh.displayVehicle();
        System.out.println("You just add " + name + " success!!");
    }

    public void updateVehicle(){
        System.out.println("Input chassis number: ");
        boolean check = false;
        String chas = sc.nextLine();
        for (Vehicle vh : vehicleDB.vehicleList){
            if (vh.getChassisNumber().equals(chas)){
                check = true;
                vh.setName(inputName());
                vh.setChassisNumber(inputChassis());
                vh.setType(inputType());
                vh.setYear(inputYear());
                vh.setColor(inputColor());
                vh.setManufacture(inputManu());
                displayHeader();
                vh.displayVehicle();
                System.out.println("You just update " + vh.getName() + " success!!");
            }
        }
        if (!check){
            System.out.println("Invalid number!!");
        }
    }

    public String inputChassis(){
        String chas;
        do {
            System.out.println("Input chassis number: ");
            chas = sc.nextLine();
        }while (!checkChassisExist(chas));
        return chas;
    }


    public boolean checkChassisExist(String chass){
        for (Vehicle vehicle : vehicleDB.vehicleList){
            if (vehicle.getChassisNumber().equals(chass)){
                System.out.println("Already existed!!!, again");
                return true;
            }
        }
        return false;
    }



    public String inputYear(){
        String year;
        do {
            System.out.println("Release day: ");
            year = sc.nextLine();
        }while (!checkYear(year));
        return year;
    }

    public boolean checkYear(String year){
        String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/1|2[0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(year);
        return matcher.find() ? true : false;
    }


    public String inputType(){
        String type;
        do {
            System.out.println("Input type of vehicle: ");
            type = sc.nextLine();
        }while (!checkType(type));
        return type;
    }

    public boolean checkColor(String color){
        String regex = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(color);
        return matcher.find() ? true : false;
    }

    public String inputColor(){
        String color;
        do {
            System.out.println("Input color: ");
            color = sc.nextLine();
        }while (!checkColor(color));
        return color;
    }

    public boolean checkManu(String manuf){
        String regex = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(manuf);
        return matcher.find() ? true : false;
    }

    public String inputManu(){
        String manuf;
        do {
            System.out.println("Input manufacture: ");
            manuf = sc.nextLine();
        }while (!checkManu(manuf));
        return manuf;
    }


    public boolean checkType(String type){
        String regrex = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regrex);
        Matcher matcher = pattern.matcher(type);
        return matcher.find() ? true : false;
    }

    public boolean checkName(String name){
        String regex = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.find() ? true : false;
    }

    public String inputName(){
        String name;
        do {
            System.out.println("Input name of vehicle: ");
            name = sc.next();
        }while (!checkName(name));
        return name;
    }

    public void displayVehicleList(){
        int size = vehicleDB.vehicleList.size();
        if (size == 0){
            System.out.println("Empty!!!");
        }else {
            displayHeader();
            for (int i = 0; i < size; i++){
                if (i == 0 || (i) % 10 != 0){
                    vehicleDB.vehicleList.get(i).displayVehicle();
                }else {
                    System.out.println("Next page: press ENTER");
                    switch (sc.nextLine()){
                        case "":
                            displayHeader();
                            vehicleDB.vehicleList.get(i).displayVehicle();
                            break;
                        default:
                            System.out.println("Exit");
                            return;
                    }
                }
            }
        }
    }

    public void displayHeader(){
        System.out.printf("|  %11s | %20s | %11s | %11s | %15s | %25s  |","Vehicle name","Chassis number","Type of vehicle","Release day","Color","Manufacture");
        System.out.println();
    }
}
