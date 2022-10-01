package za.ac.cput.repository.lookup;
/**
 *
 * This is the Class Group Repository interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.ClassGroup;
import java.util.Set;
@Repository
public interface IClassGroupRepository extends JpaRepository<ClassGroup,String> {
    //Set<ClassGroup> getAllClassGroups();
    //Could not create query for public abstract java.util.Set za.ac.cput.repository.lookup.IClassGroupRepository.getAllClassGroups()!

}
