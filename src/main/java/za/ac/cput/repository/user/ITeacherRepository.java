package za.ac.cput.repository.user;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.user.Teacher;

import java.util.List;
import java.util.Optional;

public interface ITeacherRepository extends JpaRepository<Teacher, String> {
    Optional<Teacher> findTeacherByTeacherId(String teacherId);
}
