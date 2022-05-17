package za.ac.cput.domain.lookup;

/* Author : Karl Haupt
*  Student Number: 220236585
*/
public class ParentChild {
    private String parentID, childID;

    private ParentChild(Builder builder) {
        this.parentID = builder.parentID;
        this.childID = builder.childID;
    }

    public String getParentID() {
        return parentID;
    }

    public String getChildID() {
        return childID;
    }

    public static class Builder {
        private String parentID, childID;

        public Builder setParentID(String parentID) {
            this.parentID = parentID;
            return this;
        }

        public Builder setChildID(String childID) {
            this.childID = childID;
            return this;
        }

        public Builder copy(ParentChild parentChild) {
            this.parentID = parentChild.parentID;
            this.childID = parentChild.childID;
            return this;
        }

        public ParentChild build() {
            return new ParentChild(this);
        }
    }
}
