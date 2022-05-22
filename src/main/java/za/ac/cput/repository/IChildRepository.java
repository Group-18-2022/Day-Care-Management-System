package za.ac.cput.repository;
/**
 *
 * This is the Child Repository interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import za.ac.cput.domain.user.Child;
import java.util.Set;

public interface IChildRepository extends IRepository<Child, String> {
    Set<Child> getAllChildren();
}
