
import dao.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import service.Rental;

class Main {

    public static void main(String[] args) {

        Rental r = new Rental();

        // test cases
        RentalBranch b1 = r.onBoardNewBranch("koramangala");
        // add cars to branch
        r.onBoardNewVehicle("SUV1", VehicleType.SUV, b1.getId(), 12.0);
        r.onBoardNewVehicle("SEDAN1", VehicleType.SEDAN, b1.getId(), 12.0);
        r.onBoardNewVehicle("SEDAN2", VehicleType.SEDAN, b1.getId(), 12.0);
        r.onBoardNewVehicle("SEDAN3", VehicleType.SEDAN, b1.getId(), 12.0);

        RentalBranch b2 = r.onBoardNewBranch("jayanagar");
        r.onBoardNewVehicle("SEDAN1", VehicleType.SEDAN, b2.getId(), 11.0);
        r.onBoardNewVehicle("SEDAN2", VehicleType.SEDAN, b2.getId(), 11.0);
        r.onBoardNewVehicle("SEDAN3", VehicleType.SEDAN, b2.getId(), 11.0);
        r.onBoardNewVehicle("BIKE1", VehicleType.BIKE, b2.getId(), 30.0);
        r.onBoardNewVehicle("HATCHBACK", VehicleType.HATCHBACK, b2.getId(), 8.0);
        r.onBoardNewVehicle("HATCHBACK2", VehicleType.HATCHBACK, b2.getId(), 8.0);
        r.onBoardNewVehicle("HATCHBACK3", VehicleType.HATCHBACK, b2.getId(), 8.0);
        r.onBoardNewVehicle("HATCHBACK4", VehicleType.HATCHBACK, b2.getId(), 8.0);

        // add sedan to koramangla
        r.onBoardNewVehicle("SEDAN5", VehicleType.SEDAN, b1.getId(), 12.0);

        // test cases for rent vehicle
        try {
            LocalDateTime dateTime = LocalDateTime.of(2024, 1, 2, 10, 0);
            Instant i = dateTime.atZone(ZoneId.systemDefault()).toInstant();
            r.rentVehicle(b1.getId(), VehicleType.BIKE, Date.from(i));

            // rent over this
            dateTime = LocalDateTime.of(2024, 1, 2, 12, 0);
            i = dateTime.atZone(ZoneId.systemDefault()).toInstant();

            double bill = r.endRentVehicle(7);
            System.out.println("Bill is " + bill);

            dateTime = LocalDateTime.of(2024, 1, 2, 10, 0);
            i = dateTime.atZone(ZoneId.systemDefault()).toInstant();
            r.rentVehicle(b1.getId(), VehicleType.TRUCK, Date.from(i));

        } catch (Exception e) {
            System.out.println("Failure");
            System.out.println(e);
        }

        r.System();

    }

}
