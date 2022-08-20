package za.ac.cput.factory;

import za.ac.cput.domain.VehicleRegDetails;

import java.util.Date;
import za.ac.cput.util.Helper;

/*Mponeng Ratego
 216178991
 */

public class VehicleRegDetailsFactory {

    public static VehicleRegDetails createVehicleRegDetails(String brand, String model, Date year, Date regDate ) {

        if(isInvalidParameters(brand, model, year,regDate))
            throw new IllegalArgumentException("Error alert Invalid values");

        return new VehicleRegDetails.Builder()
                .setBrand(brand)
                .setModel(model)
                .setYear(year)
                .setRegDate(regDate)
                .build();

    }



    private static boolean isInvalidParameters(String brand, String model, Date year,Date regDate ) {
        return (
                Helper.isNullOrEmpty(brand) ||
                        Helper.isNullOrEmpty(model) || Helper.isNullOrEmpty(year) ||
                        Helper.isNullOrEmpty(regDate)
        );
    }
}
