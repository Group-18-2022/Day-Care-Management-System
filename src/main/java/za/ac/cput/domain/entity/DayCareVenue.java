package za.ac.cput.domain.entity;

public class DayCareVenue
{
    private final String dayCareName;
    private final String address;
    private final String phone;
    private final String pricipalId;

    private DayCareVenue(Builder builder) {
        this.dayCareName = builder.dayCareName;
        this.address = builder.address;
        this.phone = builder.phone;
        this.pricipalId = builder.principalId;
    }

    public String getDayCareName() {
        return dayCareName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getPricipalId() {
        return pricipalId;
    }

    @Override
    public String toString() {
        return "DayCareVenue{" +
                "dayCareName='" + dayCareName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", pricipalId='" + pricipalId + '\'' +
                '}';
    }

    public static class Builder
    {
        private String dayCareName;
        private String address;
        private String phone;
        private String principalId;

        public Builder setDayCareName(String dayCareName) {
            this.dayCareName = dayCareName;
            return  this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setPrincipalId(String principalId) {
            this.principalId = principalId;
            return this;
        }

        public DayCareVenue build(){return new DayCareVenue(this);}
    }
}
