package za.ac.cput.repository.entity;
/**
 *
 * This is the Child Repository interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.entity.Child;
import java.util.Set;
@Repository
public interface IChildRepository extends JpaRepository<Child, String> {
    Set<Child> getAllChildren();
}
