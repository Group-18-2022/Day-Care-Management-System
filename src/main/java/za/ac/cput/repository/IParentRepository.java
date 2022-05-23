package za.ac.cput.repository;

import za.ac.cput.domain.entity.Parent;

import java.util.List;

public interface IParentRepository extends IRepository<Parent, String> {
    List<Parent> getParents();
    boolean contains(String ID);
}
