package za.ac.cput.controller.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.domain.lookup.ClassRegister;
import za.ac.cput.factory.lookup.ClassGroupFactory;
import za.ac.cput.factory.lookup.ClassRegisterFactory;
import za.ac.cput.service.lookup.Impl.ClassGroupServiceImpl;
import za.ac.cput.service.lookup.Impl.ClassRegisterServiceImpl;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * This is the Class Register Controller Interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
@RestController
@RequestMapping("api/v1/day-care/classregister/")
public class ClassRegisterController {
    private final ClassRegisterServiceImpl classRegisterService;

    @Autowired
    public ClassRegisterController(ClassRegisterServiceImpl classRegisterService){
        this.classRegisterService = classRegisterService;
    }
    @PostMapping("save")
    public ResponseEntity<ClassRegister> save(@Valid @RequestBody ClassRegister classRegister) {
        ClassRegister registersave = ClassRegisterFactory.createClassRegister(classRegister.getRosterID(),classRegister.getTeacherID(),classRegister.getChildID()
        ,classRegister.getClassID(),classRegister.getDate(),classRegister.getNumOfPresStudents());
        ClassRegister saved = classRegisterService.save(registersave);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<ClassRegister> read(@PathVariable String classRegisterID) {
        ClassRegister readRegister=  this.classRegisterService.read(classRegisterID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Child Not Found"));
        return  ResponseEntity.ok(readRegister);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(ClassRegister classRegister) {
        classRegisterService.delete(classRegister);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String classRegisterID) {
        this.classRegisterService.deleteById(classRegisterID);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<ClassRegister>> findAll() {
        List<ClassRegister> classRegisterList = this.classRegisterService.findAll();
        return ResponseEntity.ok(classRegisterList);
    }
}
