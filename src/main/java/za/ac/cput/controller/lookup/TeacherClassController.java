package za.ac.cput.controller.lookup;

/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.TeacherClass;
import za.ac.cput.factory.lookup.TeacherClassFactory;
import za.ac.cput.service.lookup.Impl.TeacherClassServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/day-care/teacher-class/")
public class TeacherClassController {
    private final TeacherClassServiceImpl teacherClassService;

    @Autowired
    public TeacherClassController(TeacherClassServiceImpl teacherClassService) {
        this.teacherClassService = teacherClassService;
    }

    @PostMapping("save")
    public ResponseEntity<TeacherClass> save(@Valid @RequestBody TeacherClass teacherClass) {
        TeacherClass newTeacherClass = TeacherClassFactory.build(teacherClass.getTeacherID(), teacherClass.getRoomID());
        TeacherClass teacherClassSaved = this.teacherClassService.save(newTeacherClass);
        return ResponseEntity.ok(teacherClassSaved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<TeacherClass> read(@PathVariable String id) {
        TeacherClass readTeacherClass = this.teacherClassService.read(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher/Class not found"));
        return ResponseEntity.ok(readTeacherClass);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(TeacherClass teacherClass) {
        this.teacherClassService.delete(teacherClass);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<TeacherClass>> findAll() {
        List<TeacherClass> findAllTeacherClassList = this.teacherClassService.findAll();
        return ResponseEntity.ok(findAllTeacherClassList);
    }
}
