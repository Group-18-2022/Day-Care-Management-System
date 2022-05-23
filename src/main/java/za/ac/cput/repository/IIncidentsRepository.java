package za.ac.cput.repository;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import za.ac.cput.domain.user.Incidents;

import java.util.List;

public interface IIncidentsRepository extends IRepository<Incidents, String>{
    List<Incidents> getAllIncidents();
    boolean contains(String ID);
}
