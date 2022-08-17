package za.ac.cput.domain.user;

public class Principal {
    private String principalID;
    private String firstName;
    private String lastName;
    private String dob;

    private Principal(Builder builder) {
        this.principalID =builder.principalID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dob = builder.dob;
    }

    public String getPrincipalID() {
        return principalID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "principalID='" + principalID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

    public static class Builder {
        private String principalID;
        private String firstName;
        private String lastName;
        private String dob;

        public Builder setPrincipalID(String principalID) {
            this.principalID = this.principalID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = this.firstName;
            return  this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = this.lastName;
            return this;
        }

        public Builder setDob(String dob) {
            this.dob = this.dob;
            return this;
        }

        public Builder copy(Principal principal) {
            this.principalID = principal.principalID;
            this.firstName = principal.firstName;
            this.lastName = principal.lastName;
            this.dob = principal.dob;
            return this;
        }

        public Principal build() {
            return new Principal(this);
        }
    }
}
