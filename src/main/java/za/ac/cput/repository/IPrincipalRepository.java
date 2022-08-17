package za.ac.cput.repository;

/* IPrincipalRepository.java
   IRepository for the Principal
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import za.ac.cput.domain.user.Principal;

import java.util.Set;

public interface IPrincipalRepository extends IRepository<Principal, String> {
    Set<Principal> getAll();
    boolean contains(String ID);
}
