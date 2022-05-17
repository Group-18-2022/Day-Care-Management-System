package za.ac.cput.repository;

import za.ac.cput.domain.lookup.ParentChild;

import java.util.List;

public interface IParentChildRepository extends IRepository<ParentChild, String>{
    List<ParentChild> getAllParentChild();
    boolean contains(String ID);
}
