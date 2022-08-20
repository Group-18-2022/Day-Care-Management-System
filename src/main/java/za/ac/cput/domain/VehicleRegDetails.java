package za.ac.cput.domain;


import java.util.Date;

public class VehicleRegDetails {

    private String brand;
    private String model;
    private Date year;
    private Date regDate;


    private VehicleRegDetails(VehicleRegDetails.Builder build){
        this.brand = build.brand;
        this.model = build.model;
        this.year = build.year;
        this.regDate = build.regDate;

    }

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
                "brand: '" + brand + '\'' +
                ", model: '" + model + '\'' +
                ", year: '" + year + '\'' +
                ", regDate: '" + regDate +
                '}';
    }


    public static class Builder{

        private String brand;
        private String model;
        private Date year;
        private Date regDate;

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
