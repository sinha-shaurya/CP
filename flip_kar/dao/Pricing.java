package dao;

public class Pricing {

    private Integer id;
    private Integer branchId;
    private VehicleType vehicleType;
    private Double price;

    public Pricing() {
    }

    public Pricing(Integer id, Integer branchId, VehicleType vehicleType, double price) {
        this.id = id;
        this.branchId = branchId;
        this.vehicleType = vehicleType;
        this.price = price;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
