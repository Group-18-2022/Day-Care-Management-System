package za.ac.cput.controller.lookup;

/* ESPController.java
   Controller for the ESP
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.EmergencyServiceProvider;
import za.ac.cput.factory.lookup.ESPFactory;
import za.ac.cput.service.lookup.Impl.ESPServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/day-care/esp/")
public class ESPController {
    private final ESPServiceImpl espService;

    @Autowired
    public ESPController(ESPServiceImpl service) {
        this.espService = service;
    }

    @PostMapping("save")
    public ResponseEntity<EmergencyServiceProvider> save(@Valid @RequestBody EmergencyServiceProvider esp) {
        EmergencyServiceProvider newESP = ESPFactory.createESP(esp.getServiceID(), esp.getServiceName(), esp.getType(), esp.getPhoneNum());
        return ResponseEntity.ok(espService.save(newESP));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<EmergencyServiceProvider> read(@PathVariable String id) {
        EmergencyServiceProvider readESP = this.espService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Emergency Service Provider not found"));
        return ResponseEntity.ok(readESP);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(EmergencyServiceProvider esp) {
        this.espService.delete(esp);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.espService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmergencyServiceProvider>> findAll() {
        List<EmergencyServiceProvider> espList = this.espService.findAll();
        return ResponseEntity.ok(espList);
    }
}
