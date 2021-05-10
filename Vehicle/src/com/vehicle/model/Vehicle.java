package com.vehicle.model;

public class Vehicle {
    private int vehicleId;
    private String name, chassisNumber, type, year, color, manufacture;

    public Vehicle(){}

    public Vehicle(int vehicleId, String name, String chassisNumber, String type, String year, String color, String manufacture) {
        this.vehicleId = vehicleId;
        this.name = name;
        this.chassisNumber = chassisNumber;
        this.type = type;
        this.year = year;
        this.color = color;
        this.manufacture = manufacture;
    }

    public int getVehicleId(int i) {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String engine) {
        this.chassisNumber = chassisNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String toStringCSV(){
        return vehicleId+","+name+","+chassisNumber+","+type+","+year+","+color+","+manufacture+"\n";
    }

    public void displayVehicle(){
        System.out.printf("|  %12s | %20s | %15s | %11s | %15s | %25s  |",name,chassisNumber,type,year,color,manufacture);
        System.out.println();
    }
}

