package za.ac.cput.service.user.Impl;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.Teacher;
import za.ac.cput.repository.user.ITeacherRepository;
import za.ac.cput.service.user.TeacherService;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    private ITeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(ITeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return this.repository.save(teacher);
    }

    @Override
    public Optional<Teacher> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(Teacher teacher) {
        this.repository.delete(teacher);
    }

    @Override
    public void deleteById(String Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public List<Teacher> findAll() {
        return this.repository.findAll();
    }

    public Optional<Teacher> findTeacherByTeacherId(String teacherId) {
        return this.repository.findTeacherByTeacherId(teacherId);

    }
}
