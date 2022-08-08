package za.ac.cput.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.entity.Building;
import za.ac.cput.domain.entity.DayCareVenue;

import java.util.List;

@Repository
public interface IVenueRepo extends JpaRepository<DayCareVenue, String>
{
}
