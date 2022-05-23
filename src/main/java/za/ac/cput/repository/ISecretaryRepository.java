package za.ac.cput.repository;

/* ISecretaryRepository.java
   IRepository for the Secretary
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import za.ac.cput.domain.user.Secretary;

import java.util.Set;

public interface ISecretaryRepository extends IRepository<Secretary, String> {
    Set<Secretary> getAll();
    boolean contains(String ID);
}
