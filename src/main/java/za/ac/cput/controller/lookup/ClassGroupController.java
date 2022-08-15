package za.ac.cput.controller.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.factory.lookup.ClassGroupFactory;
import za.ac.cput.service.lookup.Impl.ClassGroupServiceImpl;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * This is the Class Group Controller
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
@RestController
@RequestMapping("api/v1/day-care/classgroup/")
public class ClassGroupController {
    private final ClassGroupServiceImpl classGroupService;

    @Autowired
    public ClassGroupController(ClassGroupServiceImpl classGroupService){
        this.classGroupService = classGroupService;
    }
    @PostMapping("save")
    public ResponseEntity<ClassGroup> save(@Valid @RequestBody ClassGroup classGroup) {
        ClassGroup groupsave = ClassGroupFactory.createClassGroup(classGroup.getClassID(),classGroup.getNumOfRegStudent(),classGroup.isJunior());
        ClassGroup saved = classGroupService.save(groupsave);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<ClassGroup> read(@PathVariable String classGroupID) {
        ClassGroup readGroup =  this.classGroupService.read(classGroupID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Child Not Found"));
        return  ResponseEntity.ok(readGroup);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(ClassGroup classGroup) {
        classGroupService.delete(classGroup);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String classGroupID) {
        this.classGroupService.deleteById(classGroupID);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<ClassGroup>> findAll() {
        List<ClassGroup> classGroupList = this.classGroupService.findAll();
        return ResponseEntity.ok(classGroupList);
    }
}
