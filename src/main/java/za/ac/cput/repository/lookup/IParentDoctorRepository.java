package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.ParentDoctor;

import java.util.List;

@Repository
public interface IParentDoctorRepository extends JpaRepository<ParentDoctor, ParentDoctor.ParentDoctorID> {
}
