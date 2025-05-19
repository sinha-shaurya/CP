package dao;

import java.util.Date;

public class RentalLog {

    private Integer id;
    private Integer branchId;
    private Integer VehicleId;
    private Date startTimeDate;
    private Date endTimeDate;

    public RentalLog() {
    }

    public RentalLog(Integer id, Integer branchId, Integer VehicleId, Date startTimeDate, Date endTimeDate) {
        this.id = id;
        this.branchId = branchId;
        this.VehicleId = VehicleId;
        this.startTimeDate = startTimeDate;
        this.endTimeDate = endTimeDate;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public Integer getVehicleId() {
        return VehicleId;
    }

    public Date getStartTimeDate() {
        return startTimeDate;
    }

    public Date getEndTimeDate() {
        return endTimeDate;
    }

    public void setEndTimeDate(Date endTimeDate) {
        this.endTimeDate = endTimeDate;
    }
}
