package za.ac.cput.repository;

/* IPrincipalRepository.java
   IRepository for the Principal
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user.Principal;

@Repository
public interface IPrincipalRepository extends JpaRepository<Principal, String> {
}
