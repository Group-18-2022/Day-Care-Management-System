package za.ac.cput.repository;
/**
 *
 * This is the Class Group Repository interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import za.ac.cput.domain.lookup.ClassGroup;
import java.util.Set;

public interface IClassGroupRepository extends IRepository<ClassGroup,String>{
    Set<ClassGroup> getAllClassGroups();
}
