package za.ac.cput.service.user;

/* SecretaryService.java
   Service for the Secretary
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import za.ac.cput.domain.user.Secretary;
import za.ac.cput.service.IService;

import java.util.List;

public interface SecretaryService extends IService<Secretary, String> {
    void deleteByID(String secretaryID);
    List<Secretary> findAll();
}
