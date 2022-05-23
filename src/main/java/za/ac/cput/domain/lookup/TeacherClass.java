package za.ac.cput.domain.lookup;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

public class TeacherClass {
    private String roomID, teacherID;

    private TeacherClass(TeacherClass.Builder builder) {
        this.roomID = builder.roomID;
        this.teacherID = builder.teacherID;
    }

    public String getTeacherID() {
        return roomID;
    }

    public String getRoomID() {
        return teacherID;
    }

    public static class Builder {
        private String roomID, teacherID;

        public TeacherClass.Builder setTeacherID(String teacherID) {
            this.teacherID = teacherID;
            return this;
        }

        public TeacherClass.Builder setRoomID(String roomID) {
            this.roomID = roomID;
            return this;
        }

        public TeacherClass.Builder copy(TeacherClass teacherClass) {
            this.teacherID = teacherClass.teacherID;
            this.roomID = teacherClass.roomID;
            return this;
        }

        public TeacherClass build() { return new TeacherClass(this); }


    }

}
