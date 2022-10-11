package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.ParentChild;

import java.util.List;

@Repository
public interface IParentChildRepository extends JpaRepository<ParentChild, ParentChild.ParentChildID> {
}
