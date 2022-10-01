package za.ac.cput.service.lookup.Impl;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.TeacherClass;
import za.ac.cput.repository.lookup.ITeacherClassRepository;
import za.ac.cput.service.lookup.TeacherClassService;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherClassServiceImpl implements TeacherClassService {

    private ITeacherClassRepository repository;

    @Autowired
    public TeacherClassServiceImpl(ITeacherClassRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeacherClass save(TeacherClass teacherClass) {
        return this.repository.save(teacherClass);
    }

    @Override
    public Optional<TeacherClass> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(TeacherClass teacherClass) {
        this.repository.delete(teacherClass);
    }

    @Override
    public void deleteById(String Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public List<TeacherClass> findAll() {
        return this.repository.findAll();
    }
/*
    public Optional<TeacherClass> findTeacherClassByRoomId(String roomId) {
        return this.repository.findTeacherClassByRoomId(roomId);

    }

 */
}
