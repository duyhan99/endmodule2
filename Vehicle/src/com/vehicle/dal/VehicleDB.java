package com.vehicle.dal;

import com.vehicle.model.Vehicle;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class VehicleDB {
    public List<Vehicle> vehicleList = new ArrayList<>();
    int count = 0;

    public void write(){
        File file = new File("vehicle.csv");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("vehicle.csv"));
            count = 0;
            for (Vehicle vehicle : vehicleList){
                vehicle.setVehicleId(++count);
                bufferedWriter.write(vehicle.toStringCSV());
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void add(Vehicle vehicle){
        vehicle.getVehicleId(++count);
        vehicleList.add(vehicle);
    }

    public void read(){
        File file = new File("vehicle.csv");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("vehicle.csv"));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] str = line.split(",");
                Vehicle vehicle = new Vehicle(Integer.parseInt(str[0]),str[1],str[2],str[3],str[4],str[5],str[6]);
                add(vehicle);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
