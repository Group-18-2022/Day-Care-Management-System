package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.DayCareVenue;
import za.ac.cput.factory.entity.DayCareVenueFactory;

import static org.junit.jupiter.api.Assertions.*;

class DayCareVenueFactoryTest
{
    DayCareVenue venue;

    @Test
    public void venueCreationTest()
    {
        venue = DayCareVenueFactory
                .build("Wonder Kids", "12 Gremlin Ave.", "666-6666", "yyy3445");
        assertNotNull(venue);
    }

    @Test
    public void venueInvalidDetails()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> DayCareVenueFactory.build("","","",""));
        String expectedMessage = "Daycare Name is invalid.";
        assertEquals(expectedMessage, exception.getMessage());
        System.out.println(exception.getMessage());

    }

}