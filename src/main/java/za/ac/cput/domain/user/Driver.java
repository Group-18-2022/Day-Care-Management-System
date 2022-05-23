package za.ac.cput.domain.user;

import za.ac.cput.domain.Child;

public class Driver {

    private int idNumber;
    private String firstName;
    private String lastName;
    private int driverCode;

    private Driver(Driver.Builder build){
        this.idNumber = build.idNumber;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.driverCode = build.driverCode;

    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDriverCode() {
        return driverCode;
    }



    @Override
    public String toString() {
        return "Driver{" +
                "idNumber: '" + idNumber + '\'' +
                ", firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", driverCode: '" + driverCode +
                '}';
    }


    public class Builder{
        private int idNumber;
        private String firstName;
        private String lastName;
        private int driverCode;

        public Driver.Builder setIdNumber(int idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public Driver.Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Driver.Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Driver.Builder setDriverCode(int driverCode) {
            this.driverCode = driverCode;

            return this;
        }


        public Builder copy(Driver driver){
            this.idNumber = driver.idNumber;
            this.firstName = driver.firstName;
            this.lastName = driver.lastName;
            this.driverCode = driver.driverCode;

            return this;
        }
        public Driver build(){
            return new Driver(this);
        }

    }





}
