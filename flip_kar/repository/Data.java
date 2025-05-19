package repository;

import dao.*;
import java.util.LinkedList;
import java.util.List;

public class Data {

    public List<Vehicle> vehicles;
    public List<RentalBranch> branches;
    List<RentalLog> rentalLog;
    public List<Pricing> pricingList;

    public Data() {
        vehicles = new LinkedList<>();
        branches = new LinkedList<>();
        rentalLog = new LinkedList<>();
        pricingList = new LinkedList<>();
    }

    // add vehicle
    public Vehicle addVehicle(Vehicle v) {
        int index = vehicles.size();
        v.setId(index);

        vehicles.add(v);

        return v;
    }

    public Pricing addPricing(Pricing pricing) {
        int index = pricingList.size();
        pricing.setId(index);

        pricingList.add(pricing);

        return pricing;
    }

    public RentalBranch addBranch(RentalBranch branch) {
        int index = branches.size();
        branch.setId(index);

        branches.add(branch);

        return branch;
    }

}
