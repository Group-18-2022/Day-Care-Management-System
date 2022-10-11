package za.ac.cput.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.entity.Doctor;

import javax.print.Doc;
import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, String> {
}
