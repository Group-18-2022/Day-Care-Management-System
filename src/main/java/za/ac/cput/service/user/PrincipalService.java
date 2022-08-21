package za.ac.cput.service.user;

/* PrincipalService.java
   Service for the Principal
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import za.ac.cput.domain.user.Principal;
import za.ac.cput.service.IService;

import java.util.List;

public interface PrincipalService extends IService<Principal, String> {
    void deleteByID(String principalID);
    List<Principal> findAll();
}
