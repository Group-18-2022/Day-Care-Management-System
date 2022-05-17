package za.ac.cput.domain;
/**
 *
 * This is the ClassRegister Builder
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public class ClassRegister {
    private String rosterID;
    private String teacherID;
    private String classRoomID;
    private String date;
    private int numOfPresStudents;

    private ClassRegister(Builder build){
        this.rosterID = build.rosterID;
        this.teacherID = build.teacherID;
        this.classRoomID = build.classRoomID;
        this.date = build.date;
        this.numOfPresStudents =  build.numOfPresStudents;
    }

    public String getRosterID() {
        return rosterID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public String getClassRoomID() {
        return classRoomID;
    }

    public String getDate() {
        return date;
    }

    public int getNumOfPresStudents() {
        return numOfPresStudents;
    }

    @Override
    public String toString() {
        return "ClassRegister{" +
                "rosterID: '" + rosterID + '\'' +
                ", teacherID: '" + teacherID + '\'' +
                ", classRoomID: '" + classRoomID + '\'' +
                ", date: '" + date + '\'' +
                ", numOfPresStudents: " + numOfPresStudents +
                '}';
    }
    public class Builder{
        private String rosterID;
        private String teacherID;
        private String classRoomID;
        private String date;
        private int numOfPresStudents;

        public Builder setRosterID(String rosterID) {
            this.rosterID = rosterID;
            return this;
        }

        public Builder setTeacherID(String teacherID) {
            this.teacherID = teacherID;
            return this;
        }

        public Builder setClassRoomID(String classRoomID) {
            this.classRoomID = classRoomID;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setNumOfPresStudents(int numOfPresStudents) {
            this.numOfPresStudents = numOfPresStudents;
            return this;
        }

        public Builder copy(ClassRegister classRegister){
            this.rosterID = classRegister.rosterID;
            this.teacherID = classRegister.teacherID;
            this.classRoomID = classRegister.classRoomID;
            this.date = classRegister.date;
            this.numOfPresStudents = classRegister.numOfPresStudents;

            return this;
        }
        public ClassRegister build(){
            return new ClassRegister(this);
        }
    }
}
