package za.ac.cput.service.lookup;

/* ESPService.java
   Service for the ESP
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import za.ac.cput.domain.lookup.EmergencyServiceProvider;
import za.ac.cput.service.IService;

import java.util.List;

public interface ESPService extends IService<EmergencyServiceProvider, String> {
    void deleteByID(String serviceID);
    List<EmergencyServiceProvider> findAll();
}
