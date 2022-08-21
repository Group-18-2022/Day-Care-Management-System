package za.ac.cput.controller.user;

/* SecretaryController.java
   Controller for the Secretary
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.user.Secretary;
import za.ac.cput.factory.user.SecretaryFactory;
import za.ac.cput.service.user.Impl.SecretaryServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/day-care/secretary/")
public class SecretaryController {
    private final SecretaryServiceImpl secretaryService;

    @Autowired
    public SecretaryController(SecretaryServiceImpl service) {
        this.secretaryService = service;
    }

    @PostMapping("save")
    public ResponseEntity<Secretary> save(@Valid @RequestBody Secretary secretary) {
        Secretary newSecretary = SecretaryFactory.createSecretary(secretary.getSecretaryID(), secretary.getFirstName(), secretary.getLastName(), secretary.getDob());
        return ResponseEntity.ok(secretaryService.save(newSecretary));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Secretary> read(@PathVariable String id) {
        Secretary readSecretary = this.secretaryService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Secretary not found"));
        return ResponseEntity.ok(readSecretary);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Secretary secretary) {
        this.secretaryService.delete(secretary);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.secretaryService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Secretary>> findAll() {
        List<Secretary> secretaryList = this.secretaryService.findAll();
        return ResponseEntity.ok(secretaryList);
    }
}
