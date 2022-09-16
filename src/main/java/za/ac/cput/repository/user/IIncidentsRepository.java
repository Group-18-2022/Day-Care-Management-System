package za.ac.cput.repository.user;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.user.Incidents;

import java.util.List;
import java.util.Optional;

public interface IIncidentsRepository extends JpaRepository<Incidents, String> {
    //Optional<Incidents> findByIncidentId(String incidentId); Already provided for in JPA
}
