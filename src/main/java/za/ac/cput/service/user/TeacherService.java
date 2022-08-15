package za.ac.cput.service.user;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import za.ac.cput.domain.user.Teacher;
import za.ac.cput.service.IService;

import java.util.List;

public interface TeacherService extends IService<Teacher, String> {
    void deleteById(String Id);
    List<Teacher> findAll();
}
