package za.ac.cput.repository;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import za.ac.cput.domain.user.Teacher;

import java.util.List;

public interface ITeacherRepository extends IRepository<Teacher, String>{
    List<Teacher> getTeacher();
    boolean contains(String ID);
}
