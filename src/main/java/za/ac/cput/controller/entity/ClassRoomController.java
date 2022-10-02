package za.ac.cput.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.factory.entity.ClassRoomFactory;
import za.ac.cput.factory.entity.DoctorFactory;
import za.ac.cput.service.entity.impl.ClassRoomServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/day-care/classroom/")
public class ClassRoomController
{
    private final ClassRoomServiceImpl classRoomService;

    @Autowired
    public ClassRoomController(ClassRoomServiceImpl classRoomService) {
        this.classRoomService = classRoomService;
    }

    @PostMapping("save")
    public ResponseEntity<ClassRoom> save(@Valid @RequestBody ClassRoom classRoom) {
        ClassRoom room = ClassRoomFactory.build(classRoom.getClassroomId(),classRoom.getRoomNumber());
        ClassRoom saved = classRoomService.save(room);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<ClassRoom> read(@PathVariable String id) {
        ClassRoom read =  this.classRoomService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Classroom Not Found"));
        return  ResponseEntity.ok(read);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(ClassRoom classRoom) {
        this.classRoomService.delete(classRoom);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.classRoomService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<ClassRoom>> findAll() {
        List<ClassRoom> list = this.classRoomService.findAll();
        return ResponseEntity.ok(list);
    }


}
