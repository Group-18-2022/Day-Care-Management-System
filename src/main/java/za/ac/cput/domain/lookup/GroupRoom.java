package za.ac.cput.domain.lookup;

public class GroupRoom
{
    private String classRoomId, classGroupId;

    public GroupRoom(Builder builder)
    {
        this.classRoomId = builder.classRoomId;
        this.classGroupId = builder.classGroupId;
    }

    public String getClassRoomId() {
        return classRoomId;
    }

    public String getClassGroupId() {
        return classGroupId;
    }

    public static class Builder
    {
        private String classRoomId, classGroupId;

        public Builder setClassRoomId(String classRoomId)
        {
            this.classRoomId = classRoomId;
            return this;
        }

        public Builder setClassGroupId(String classGroupId)
        {
            this.classGroupId = classGroupId;
            return this;
        }

        public GroupRoom build()
        {
            return new GroupRoom(this);
        }
    }
}
