package za.ac.cput.repository.lookup;
/**
 *
 * This is the Class Register Repository interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.ClassRegister;
import java.util.Set;

@Repository
public interface IClassRegisterRepository extends JpaRepository<ClassRegister,String> {
    Set<ClassRegister> getAllClassRegister();
}
