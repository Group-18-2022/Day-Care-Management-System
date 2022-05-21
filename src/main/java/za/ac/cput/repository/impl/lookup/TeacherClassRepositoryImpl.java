package za.ac.cput.repository.impl.lookup;

import za.ac.cput.domain.lookup.TeacherClass;
import za.ac.cput.repository.ITeacherClassRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherClassRepositoryImpl implements ITeacherClassRepository {
    private static TeacherClassRepositoryImpl repository;
    private List<TeacherClass> teacherClassDB;

    private TeacherClassRepositoryImpl() {
        this.teacherClassDB = new ArrayList<>();
    }

    public static TeacherClassRepositoryImpl getRepository() {
        if(repository == null) repository = new TeacherClassRepositoryImpl();
        return repository;
    }

    @Override
    public TeacherClass create(TeacherClass teacherClass) {
        boolean isSuccessful = teacherClassDB.add(teacherClass);
        if(!isSuccessful) return null;
        return teacherClass;
    }

    @Override
    public TeacherClass read(String teacherID) {
        return teacherClassDB
                .stream()
                .filter(p -> p.getTeacherID().equals(teacherID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public TeacherClass update(TeacherClass teacherClass) {
        var currentTeacher = read(teacherClass.getTeacherID());
        if(currentTeacher != null) {
            teacherClassDB.remove(currentTeacher);
            teacherClassDB.add(teacherClass);
            return teacherClass;
        }
        return null;
    }

    @Override
    public boolean delete(String teacherID) {
        boolean isSuccessful = true;
        var teacherClassToDelete = read(teacherID);
        if(teacherClassToDelete != null) isSuccessful = teacherClassDB.remove(teacherClassToDelete);
        return isSuccessful;
    }

    @Override
    public List<TeacherClass> getAllTeacherClass() {
        return teacherClassDB;
    }

    @Override
    public boolean contains(String teacherID) {
        var teacher = read(teacherID);
        if(teacher != null) return true;
        return false;
    }
}
