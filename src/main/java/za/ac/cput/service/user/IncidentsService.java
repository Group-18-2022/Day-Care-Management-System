package za.ac.cput.service.user;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import za.ac.cput.domain.user.Incidents;
import za.ac.cput.service.IService;

import java.util.List;

public interface IncidentsService extends IService<Incidents, String> {
    void deleteById(String Id);
    List<Incidents> findAll();
}
