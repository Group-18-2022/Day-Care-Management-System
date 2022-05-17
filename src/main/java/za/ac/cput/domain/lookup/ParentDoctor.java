package za.ac.cput.domain.lookup;
/* Author : Karl Haupt
 *  Student Number: 220236585
 */

public class ParentDoctor {
    private String doctorID, parentID;

    private ParentDoctor(Builder builder) {
        this.doctorID = builder.doctorID;
        this.parentID = builder.parentID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getParentID() {
        return parentID;
    }

    public static class Builder {
        private String doctorID, parentID;

        public Builder setDoctorID(String doctorID) {
            this.doctorID = doctorID;
            return this;
        }

        public Builder setParentID(String parentID) {
            this.parentID = parentID;
            return this;
        }

        public Builder copy(ParentDoctor parentDoctor) {
            this.doctorID = parentDoctor.doctorID;
            this.parentID = parentDoctor.parentID;
            return this;
        }

        public ParentDoctor build() { return new ParentDoctor(this); }


    }
}
