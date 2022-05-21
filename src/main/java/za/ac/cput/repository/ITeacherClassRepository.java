package za.ac.cput.repository;


import za.ac.cput.domain.lookup.TeacherClass;

import java.util.List;

public interface ITeacherClassRepository extends IRepository<TeacherClass, String> {
    List<TeacherClass> getAllTeacherClass();
    boolean contains(String ID);
}
