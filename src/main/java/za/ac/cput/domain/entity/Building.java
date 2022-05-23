package za.ac.cput.domain.entity;

public class Building
{
    private String buildingId;
    private String buildingName;
    private String description;

    private Building(Builder builder)
    {
        this.buildingId = builder.buildingId;
        this.buildingName = builder.buildingName;
        this.description = builder.description;
    }

    public String getBuildingId()
    {
        return buildingId;
    }

    public String getBuildingName()
    {
        return buildingName;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingId='" + buildingId + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder
    {
        private String buildingId;
        private String buildingName;
        private String description;

        public Builder setBuildingId(String buildingId) {
            this.buildingId = buildingId;
            return this;
        }

        public Builder setBuildingName(String buildingName) {
            this.buildingName = buildingName;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Building build()
        {
            return new Building(this);
        }
    }
}
