package za.ac.cput.controller.user;

/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.user.Teacher;
import za.ac.cput.factory.user.TeacherFactory;
import za.ac.cput.service.user.Impl.TeacherServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/day-care/teacher/")
public class TeacherController {
    private final TeacherServiceImpl teacherService;

    @Autowired
    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("save")
    public ResponseEntity<Teacher> save(@Valid @RequestBody Teacher teacher) {
        Teacher newTeacher = TeacherFactory.build(teacher.getTeacherID(),teacher.getClassNumber(), teacher.getFirstName(), teacher.getLastName(), teacher.getDateOfBirth());
        Teacher teacherSaved = this.teacherService.save(newTeacher);
        return ResponseEntity.ok(teacherSaved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Teacher> read(@PathVariable String id) {
        Teacher readTeacher = this.teacherService.read(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
        return ResponseEntity.ok(readTeacher);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Teacher teacher) {
        this.teacherService.delete(teacher);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.teacherService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Teacher>> findAll() {
        List<Teacher> findAllTeacherList = this.teacherService.findAll();
        return ResponseEntity.ok(findAllTeacherList);
    }

}
