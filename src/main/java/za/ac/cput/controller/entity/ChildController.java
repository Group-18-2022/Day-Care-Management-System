package za.ac.cput.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.entity.Child;
import za.ac.cput.factory.entity.ChildFactory;
import za.ac.cput.service.entity.impl.ChildServiceImpl;

import javax.validation.Valid;
import java.util.List;
/**
 *
 * This is the Child Controller
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
@RestController
@RequestMapping("api/v1/day-care/child/")
public class ChildController {

    private final ChildServiceImpl childService;

    @Autowired
    public ChildController(ChildServiceImpl childService){
        this.childService =childService;
    }
    @PostMapping("save")
    public ResponseEntity<Child> save(@Valid @RequestBody Child child) {
        Child childsave = ChildFactory.createChild(child.getChildID(),child.getFirstName()
        ,child.getLastName(),child.getAddress(),child.getDob(),child.getGender());
        Child saved = childService.save(childsave);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Child> read(@PathVariable String childID) {
        Child readChild =  this.childService.read( childID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Child Not Found"));
        return  ResponseEntity.ok(readChild);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Child child) {
        childService.delete(child);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String childID) {
        this.childService.deleteById(childID);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Child>> findAll() {
        List<Child> childList = this.childService.findAll();
        return ResponseEntity.ok(childList);
    }
}
