package za.ac.cput.service.lookup;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import za.ac.cput.domain.lookup.TeacherClass;
import za.ac.cput.service.IService;

import java.util.List;

public interface TeacherClassService extends IService<TeacherClass, String> {
    void deleteById(String Id);
    List<TeacherClass> findAll();
}
