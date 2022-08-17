package za.ac.cput.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.factory.entity.DoctorFactory;
import za.ac.cput.service.entity.impl.DoctorServiceImpl;

import javax.validation.Valid;
import java.util.List;

/*  Author : Karl Haupt
 *  Student Number: 220236585
 */

@RestController
@RequestMapping("api/v1/day-care/doctor/")
public class DoctorController {
    private final DoctorServiceImpl doctorService;

    @Autowired
    public DoctorController(DoctorServiceImpl service) {
        this.doctorService = service;
    }

    @PostMapping("save")
    public ResponseEntity<Doctor> save(@Valid @RequestBody Doctor doctor) {
        Doctor doc = DoctorFactory.buildDoctor(doctor.getDoctorID(), doctor.getPracticeName(), doctor.getFirstName(), doctor.getLastName(), doctor.getPhoneNumber());
        Doctor saved = doctorService.save(doc);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Doctor> read(@PathVariable String id) {
        Doctor read =  this.doctorService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor Not Found"));
        return  ResponseEntity.ok(read);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Doctor doctor) {
        doctorService.delete(doctor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Doctor>> findAll() {
        List<Doctor> list = this.doctorService.findAll();
        return ResponseEntity.ok(list);
    }
}
