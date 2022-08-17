package za.ac.cput.repository;

/* IESPRepository.java
   IRepository for the Emergency Service Provider
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import za.ac.cput.domain.lookup.EmergencyServiceProvider;

import java.util.Set;

public interface IESPRepository extends IRepository<EmergencyServiceProvider, String> {
    Set<EmergencyServiceProvider> getAll();
    boolean contains(String ID);
}
