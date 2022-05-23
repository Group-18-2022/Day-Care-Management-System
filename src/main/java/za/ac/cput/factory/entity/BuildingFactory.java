package za.ac.cput.factory.entity;

import za.ac.cput.domain.entity.Building;
import za.ac.cput.util.Helper;

public class BuildingFactory
{
    private String buildingId;
    private String buildingName;
    private String description;

    public static Building build( String buildingName, String description)
    {
        String identifier = Helper.generateID();
        String buildingId = Helper.generateID();

        if(Helper.isNullOrEmpty(buildingId))
            throw new IllegalArgumentException("Building ID is invalid");
        if(Helper.isNullOrEmpty(buildingName))
            throw new IllegalArgumentException("Building name is empty or invalid");
        if(Helper.isNullOrEmpty(description))
            throw new IllegalArgumentException("Description is empty or invalid");

        return new Building.Builder()
                .setBuildingId(identifier)
                .setBuildingName(buildingName)
                .setDescription(description).build();
    }
}
