package za.ac.cput.domain.lookup;

/* Mponeng Ratego
 * 216178991
 */

import za.ac.cput.domain.user.Driver;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Date;
@Entity
public class VehicleRegDetails {

    @NotNull
    @Id
    private String vehicleId;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private Date year;
    @NotNull
    private Date regDate;

    protected  VehicleRegDetails(){}
    private VehicleRegDetails(VehicleRegDetails.Builder build){
        this.vehicleId = build.vehicleId;
        this.brand = build.brand;
        this.model = build.model;
        this.year = build.year;
        this.regDate = build.regDate;

    }


    public String getVehicleId(){return vehicleId;}
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Date getYear() {
        return year;
    }

    public Date getRegDate() {
        return regDate;
    }



    @Override
    public String toString() {
        return "VehicleRegDetails{" +
                "vehicleId:" + vehicleId + '\'' +
                "brand: '" + brand + '\'' +
                ", model: '" + model + '\'' +
                ", year: '" + year + '\'' +
                ", regDate: '" + regDate +
                '}';
    }


    public static class Builder{

        private String vehicleId;
        private String brand;
        private String model;
        private Date year;
        private Date regDate;

        public VehicleRegDetails.Builder setVehicleId(String brand) {
            this.vehicleId = vehicleId;
            return this;
        }
        public VehicleRegDetails.Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public VehicleRegDetails.Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public VehicleRegDetails.Builder setYear(Date year) {
            this.year = year;
            return this;
        }

        public VehicleRegDetails.Builder setRegDate(Date regDate) {
            this.regDate = regDate;

            return this;
        }


        public VehicleRegDetails.Builder copy(VehicleRegDetails vehicleRegDetails){
            this.vehicleId = vehicleRegDetails.vehicleId;
            this.brand = vehicleRegDetails.brand;
            this.model = vehicleRegDetails.model;
            this.year = vehicleRegDetails.year;
            this.regDate = vehicleRegDetails.regDate;

            return this;
        }
        public VehicleRegDetails build(){
            return new VehicleRegDetails(this);
        }

    }

}
