package za.ac.cput.domain;

public class Doctor {
    private String doctorID, practiceName, firstName, secondName, phoneNumber;

    private Doctor(Builder builder) {
        this.doctorID = builder.doctorID;
        this.practiceName = builder.practiceName;
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public class Builder {
        private String doctorID, practiceName, firstName, secondName, phoneNumber;

        public Builder setDoctorID(String doctorID) {
            this.doctorID = doctorID;
            return this;
        }

        public Builder setPracticeName(String practiceName) {
            this.practiceName = practiceName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder copy(Doctor doctor) {
          this.doctorID = doctor.doctorID;
          this.practiceName = doctor.practiceName;
          this.firstName = doctor.firstName;
          this.secondName = doctor.secondName;
          this.phoneNumber = doctor.phoneNumber;
          return this;
        }

        public Doctor build() { return new Doctor(this); }
    }
}
