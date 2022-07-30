package za.ac.cput.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.entity.Parent;

import java.util.List;

@Repository
public interface IParentRepository extends JpaRepository<Parent, String> {
}
