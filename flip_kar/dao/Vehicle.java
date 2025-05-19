package dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehicle {

    private Integer id;
    private String name;
    private VehicleType vehicleType;
    private Integer branchId;
    private Date startTime;
    private Date endTime;

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start = "", end = "";
        if (startTime != null) {
            start = sdf.format(startTime);
        }
        if (endTime != null) {
            end = sdf.format(endTime);
        }

        return String.format("Vehicle : id: %d Name: %s Type: %s Branch : %d startTime:%s endTime:%s", id, name, vehicleType, branchId, start, end);
    }

    public Vehicle(Integer id, String name, VehicleType vehicleType, Integer branchId) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.branchId = branchId;
    }

    public Vehicle(String name, VehicleType vehicleType, int branchId) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.branchId = branchId;
    }

    public Vehicle() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Integer getBranchId() {
        return branchId;
    }

}
