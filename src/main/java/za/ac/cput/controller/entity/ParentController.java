package za.ac.cput.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.entity.Parent;
import za.ac.cput.factory.entity.ParentFactory;
import za.ac.cput.service.entity.impl.ParentServiceImpl;

import javax.validation.Valid;
import java.util.List;

/*  Author : Karl Haupt
 *  Student Number: 220236585
 */

@RestController
@RequestMapping("api/v1/day-care/parent/")
public class ParentController {
    private final ParentServiceImpl parentService;

    @Autowired
    public ParentController(ParentServiceImpl service) {
        this.parentService = service;
    }

    @PostMapping("save")
    public ResponseEntity<Parent> save(@Valid @RequestBody Parent parent) {
        Parent par = ParentFactory.buildParent(parent.getParentID(), parent.getFirstName(), parent.getLastName(), parent.getAddress(), parent.getPhoneNumber());
        return ResponseEntity.ok(parentService.save(par));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Parent> read(@PathVariable String id) {
        var par = this.parentService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent Not Found"));
        return  ResponseEntity.ok(par);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Parent parent) {
        this.parentService.delete(parent);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.parentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Parent>> findAll() {
        List<Parent> parentList = this.parentService.findAll();
        return ResponseEntity.ok(parentList);
    }
}
