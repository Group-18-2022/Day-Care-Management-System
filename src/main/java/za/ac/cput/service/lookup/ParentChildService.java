package za.ac.cput.service.lookup;

import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface ParentChildService extends IService<ParentChild, ParentChild.ParentChildID> {
    void deleteById(ParentChild.ParentChildID parentChildID);
    List<ParentChild> findAll();
}
