package za.ac.cput.domain;
/**
 *
 * This is the ClassGroup Builder
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public class ClassGroup {

    private String classID;
    private int numOfRegStudent;
    private boolean isJunior;

    private ClassGroup(Builder builder){
        this.classID = builder.classID;
        this.numOfRegStudent = builder.numOfRegStudent;
        this.isJunior = builder.isJunior;
    }

    public String getClassID() {
        return classID;
    }

    public int getNumOfRegStudent() {
        return numOfRegStudent;
    }

    public boolean isJunior() {
        return isJunior;
    }

    @Override
    public String toString() {
        return "ClassGroup{" +
                "classID: '" + classID + '\'' +
                ", numOfRegStudent: " + numOfRegStudent +
                ", isJunior: " + isJunior +
                '}';
    }

    public class Builder{
        private String classID;
        private int numOfRegStudent;
        private boolean isJunior;

        public Builder setClassID(String classID) {
            this.classID = classID;
            return this;
        }

        public Builder setNumOfRegStudent(int numOfRegStudent) {
            this.numOfRegStudent = numOfRegStudent;
            return this;
        }

        public Builder setJunior(boolean junior) {
            isJunior = junior;
            return this;
        }
        public Builder copy(ClassGroup classGroup){
            this.classID = classGroup.classID;
            this.numOfRegStudent = classGroup.numOfRegStudent;
            this.isJunior = classGroup.isJunior;
            return this;
        }

        public ClassGroup build(){
            return new ClassGroup(this);
        }
    }
}
