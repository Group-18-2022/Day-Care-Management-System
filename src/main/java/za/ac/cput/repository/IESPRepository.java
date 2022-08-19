package za.ac.cput.repository;

/* IESPRepository.java
   IRepository for the Emergency Service Provider
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.EmergencyServiceProvider;

@Repository
public interface IESPRepository extends JpaRepository<EmergencyServiceProvider, String> {
}
