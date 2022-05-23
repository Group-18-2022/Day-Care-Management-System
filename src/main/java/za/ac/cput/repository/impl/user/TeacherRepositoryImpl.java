package za.ac.cput.repository.impl.user;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import za.ac.cput.domain.user.Teacher;
import za.ac.cput.repository.ITeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryImpl implements ITeacherRepository {
    private static TeacherRepositoryImpl repository;
    private List<Teacher> teacherDB;

    private TeacherRepositoryImpl() {
        this.teacherDB = new ArrayList<>();
    }

    public static TeacherRepositoryImpl getRepository() {
        if(repository == null) repository = new TeacherRepositoryImpl();
        return repository;
    }

    @Override
    public Teacher create(Teacher teacher) {
        boolean isSuccessful = teacherDB.add(teacher);
        if(!isSuccessful) return null;
        return teacher;
    }

    @Override
    public Teacher read(String teacherID) {
        return teacherDB
                .stream()
                .filter(p -> p.getTeacherID().equals(teacherID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Teacher update(Teacher teacher) {
        var currentTeacher = read(teacher.getTeacherID());
        if(currentTeacher != null) {
            teacherDB.remove(currentTeacher);
            teacherDB.add(teacher);
            return teacher;
        }
        return null;
    }

    @Override
    public boolean delete(String teacherID) {
        boolean isSuccessful = true;
        var teacherToDelete = read(teacherID);
        if(teacherToDelete != null) isSuccessful = teacherDB.remove(teacherToDelete);
        return isSuccessful;
    }

    @Override
    public List<Teacher> getTeacher() {
        return teacherDB;
    }

    @Override
    public boolean contains(String teacherID) {
        var teacher = read(teacherID);
        if(teacher != null) return true;
        return false;
    }

}
