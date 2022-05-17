package za.ac.cput.domain;
/**
 *
 * This is the Child Builder
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public class Child {
    private String childID;
    private String firstName;
    private String lastName;
    private String Address;
    private String DOB;
    private String Gender;

    private Child(Builder build){
        this.childID = build.childID;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.Address = build.Address;
        this.DOB = build.DOB;
        this.Gender = build.Gender;
    }

    public String getChildID() {
        return childID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return Address;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return Gender;
    }

    @Override
    public String toString() {
        return "Child{" +
                "childID: '" + childID + '\'' +
                ", firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", Address: '" + Address + '\'' +
                ", DOB: '" + DOB + '\'' +
                ", Gender: '" + Gender + '\'' +
                '}';
    }
    public class Builder{
        private String childID;
        private String firstName;
        private String lastName;
        private String Address;
        private String DOB;
        private String Gender;

        public Builder setChildID(String childID) {
            this.childID = childID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAddress(String address) {
            Address = address;
            return this;
        }

        public Builder setDOB(String DOB) {
            this.DOB = DOB;
            return this;
        }

        public Builder setGender(String gender) {
            Gender = gender;
            return this;
        }

        public Builder copy(Child child){
            this.childID = child.childID;
            this.firstName = child.firstName;
            this.lastName = child.lastName;
            this.Address = child.Address;
            this.DOB = child.DOB;
            this.Gender = child.Gender;
            return this;
        }
        public Child build(){
            return new Child(this);
        }

    }
}
