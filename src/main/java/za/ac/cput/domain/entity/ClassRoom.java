package za.ac.cput.domain.entity;

public class ClassRoom
{
    private final String classroomId;
    private final String roomNumber;


    private ClassRoom(Builder builder)
    {
        this.classroomId = builder.classroomId;
        this.roomNumber = builder.roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classroomId='" + classroomId + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }

    public static class Builder
    {
        private String classroomId;
        private String roomNumber;

        public Builder setClassroomId(String classroomId) {
            this.classroomId = classroomId;
            return  this;
        }

        public Builder setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder copy(ClassRoom crm)
        {
            this.classroomId = crm.classroomId;
            this.roomNumber = crm.roomNumber;
            return  this;

        }

        public ClassRoom build()
        {
            return new ClassRoom(this);
        }
    }
}
