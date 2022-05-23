package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.Building;
import za.ac.cput.factory.entity.BuildingFactory;

import static org.junit.jupiter.api.Assertions.*;

class BuildingFactoryTest
{
    private Building building;

    @Test
    public void buildObjectTest()
    {
        building = BuildingFactory.build("Building 1", "Main Building");
        assertNotNull(building);
        System.out.println(building);
    }

    @Test
    public void testWithInvalidName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class,
                ()-> BuildingFactory.build("", "Main Building"));
        String expectedMessage = "Building name is empty or invalid";
        assertEquals(expectedMessage , exception.getMessage());
    }

}