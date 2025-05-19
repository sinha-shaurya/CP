package service;

import dao.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import repository.Data;

public class Rental {

    Data data;

    public Rental() {
        data = new Data();
    }

    // onboard new vehicle to branch 
    public void onBoardNewVehicle(String name, VehicleType vehicleType, int branchId, double price) {
        // create new instance of vehicle

        Vehicle v = new Vehicle(name, vehicleType, branchId);

        // write this to repository
        v = data.addVehicle(v);

        // add pricing for this 
        Pricing pricing = new Pricing(0, branchId, vehicleType, price);
        pricing = data.addPricing(pricing);

    }

    public RentalBranch onBoardNewBranch(String name) {
        RentalBranch branch = new RentalBranch(0, name);
        branch = data.addBranch(branch);

        return branch;
    }

    public Vehicle selectVehicle(int branchId, VehicleType vt) {
        // filter empty 
        List<Vehicle> availableVehicles = new LinkedList<>();
        List<Vehicle> branchVehicles = new LinkedList<>();

        for (Vehicle v : data.vehicles) {
            if (v.getStartTime() != null || v.getVehicleType() != vt) {
                continue;
            }
            if (v.getBranchId() == branchId) {
                branchVehicles.add(v);
            }
            availableVehicles.add(v);
        }

        if (!branchVehicles.isEmpty()) {
            availableVehicles = branchVehicles;
        }

        if (!availableVehicles.isEmpty()) {
        } else {
            throw new IllegalArgumentException("No vehicles available");
        }

        return availableVehicles.get(0);
    }

    public void rentVehicle(int branchId, VehicleType vt, Date startTime) {
        Vehicle v = selectVehicle(branchId, vt);

        // start rent
        Date now = new Date();
        v.setStartTime(startTime);

        data.vehicles.set(v.getId(), v);
    }

    public Vehicle getVehicleFromId(int id) {
        return data.vehicles.get(id);
    }

    public double endRentVehicle(int id) {
        Vehicle v = getVehicleFromId(id);

        // start rent
        Date now = new Date();
        v.setEndTime(now);

        data.vehicles.set(v.getId(), v);

        double price = getPrice(v.getVehicleType());

        // empty this vehicle
        double p = ((v.getEndTime().getTime() - v.getStartTime().getTime()) / (1000 * 60 * 60)) * price;
        v.setStartTime(null);
        v.setEndTime(null);
        data.vehicles.set(v.getId(), v);

        return p;
    } 

    

    public double getPrice(VehicleType vt) {
        for (Pricing price : data.pricingList) {
            if (price.getVehicleType() == vt) {
                return price.getPrice();
            }
        }

        return 0.0;
    }

    // system view
    public void System() {
        // print branch
        for (RentalBranch rb : data.branches) {
            System.out.println(rb);
        }

        System.out.println();

        // print vehicles
        for (Vehicle v : data.vehicles) {
            System.out.println(v);
        }
    }
}
