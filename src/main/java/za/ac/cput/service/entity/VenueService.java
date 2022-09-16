package za.ac.cput.service.entity;

import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.domain.entity.DayCareVenue;
import za.ac.cput.service.IService;

import java.util.List;

public interface VenueService extends IService<DayCareVenue, String>
{
    void deleteById(String id);
    List<DayCareVenue> findAll();
}
