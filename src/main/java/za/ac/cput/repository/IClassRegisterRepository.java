package za.ac.cput.repository;
/**
 *
 * This is the Class Register Repository interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import za.ac.cput.domain.lookup.ClassRegister;
import java.util.Set;

public interface IClassRegisterRepository extends IRepository<ClassRegister,String> {
    Set<ClassRegister> getAllClassRegister();
}
