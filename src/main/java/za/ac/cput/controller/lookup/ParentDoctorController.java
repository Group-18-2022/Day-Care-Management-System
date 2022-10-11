package za.ac.cput.controller.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.factory.lookup.ParentDoctorFactory;
import za.ac.cput.service.lookup.Impl.ParentDoctorServiceImpl;

import javax.validation.Valid;
import java.util.List;

/*  Author : Karl Haupt
 *  Student Number: 220236585
 */

@RestController
@RequestMapping("api/v1/day-care/parent-doctor/")
public class ParentDoctorController {
    private final ParentDoctorServiceImpl parentDoctorService;

    @Autowired
    public ParentDoctorController(ParentDoctorServiceImpl parentDoctorService) {
        this.parentDoctorService = parentDoctorService;
    }

    @PostMapping("save")
    public ResponseEntity<ParentDoctor> save(@Valid @RequestBody ParentDoctor parentDoctor) {
        ParentDoctor newParentDoctor = ParentDoctorFactory.buildParentDoctor(parentDoctor.getDoctorID(), parentDoctor.getParentID());
        ParentDoctor parentDoctorSaved = this.parentDoctorService.save(newParentDoctor);
        return ResponseEntity.ok(parentDoctorSaved);
    }

    @GetMapping("read/")
    public ResponseEntity<ParentDoctor> read(@Valid @RequestBody ParentDoctor.ParentDoctorID parentDoctor) {
        ParentDoctor readParentDoctor = this.parentDoctorService.read(parentDoctor).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent/Doctor not found"));
        return ResponseEntity.ok(readParentDoctor);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(ParentDoctor parentDoctor) {
        this.parentDoctorService.delete(parentDoctor);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<ParentDoctor>> findAll() {
        List<ParentDoctor> parentDoctorList = this.parentDoctorService.findAll();
        return ResponseEntity.ok(parentDoctorList);
    }
}
