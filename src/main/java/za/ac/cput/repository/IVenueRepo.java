package za.ac.cput.repository;

import za.ac.cput.domain.entity.Building;
import za.ac.cput.domain.entity.DayCareVenue;

import java.util.List;

public interface IVenueRepo extends IRepository<DayCareVenue, String>
{
    List<Building> getAllVenues();
}
