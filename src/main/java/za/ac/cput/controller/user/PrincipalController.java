package za.ac.cput.controller.user;

/* PrincipalController.java
   Controller for the Principal
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.user.Principal;
import za.ac.cput.factory.user.PrincipalFactory;
import za.ac.cput.service.user.Impl.PrincipalServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/day-care/principal/")
public class PrincipalController {
    private final PrincipalServiceImpl principalService;

    @Autowired
    public PrincipalController(PrincipalServiceImpl service) {
        this.principalService = service;
    }

    @PostMapping("save")
    public ResponseEntity<Principal> save(@Valid @RequestBody Principal principal) {
        Principal newPrincipal = PrincipalFactory.createPrincipal(principal.getPrincipalID(), principal.getFirstName(), principal.getLastName(), principal.getDob());
        return ResponseEntity.ok(principalService.save(newPrincipal));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Principal> read(@PathVariable String id) {
        Principal readPrincipal = this.principalService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Principal not found"));
        return ResponseEntity.ok(readPrincipal);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Principal principal) {
        this.principalService.delete(principal);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.principalService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Principal>> findAll() {
        List<Principal> principalList = this.principalService.findAll();
        return ResponseEntity.ok(principalList);
    }
}
