package za.ac.cput.service.lookup;


import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.service.IService;

import java.util.List;
/**
 *
 * This is the Class Group Services Interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public interface ClassGroupService extends IService<ClassGroup, String> {

    void deleteById(String id);
    List<ClassGroup> findAll();

}
