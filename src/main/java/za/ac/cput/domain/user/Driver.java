package za.ac.cput.domain.user;

public class Driver {

    private String idNumber;
    private String firstName;
    private String lastName;
    private String driverCode;

    private Driver(Driver.Builder build){
        this.idNumber = build.idNumber;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.driverCode = build.driverCode;

    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDriverCode() {
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

    public Object idNumber() {
        this.idNumber = idNumber;
        return this;
    }


    public static class Builder{
        private String idNumber;
        private String firstName;
        private String lastName;
        private String driverCode;

        public Driver.Builder setIdNumber(String idNumber) {
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

        public Driver.Builder setDriverCode(String driverCode) {
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
