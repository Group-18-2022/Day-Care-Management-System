package za.ac.cput.service.lookup;


import za.ac.cput.domain.lookup.ClassRegister;
import za.ac.cput.service.IService;

import java.util.List;
/**
 *
 * This is the Class Register Services Interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public interface ClassRegisterService extends IService<ClassRegister, String> {
    void deleteById(String id);
    List<ClassRegister> findAll();
}
