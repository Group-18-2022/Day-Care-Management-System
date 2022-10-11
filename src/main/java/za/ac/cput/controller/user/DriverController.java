package za.ac.cput.controller.user;

/*
   Mponeng Ratego
   216178991
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.user.Driver;
import za.ac.cput.factory.user.DriverFactory;
import za.ac.cput.service.user.Impl.DriverServiceImpl;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/day-care/driver/")
public class DriverController {

    private final DriverServiceImpl driverService;

    @Autowired
    public DriverController(DriverServiceImpl service) {
        this.driverService = service;
    }

    @PostMapping("save")
    public ResponseEntity<Driver> save(@Valid @RequestBody Driver driver) {
        Driver newDriver = DriverFactory.createDriver(driver.getIdNumber(), driver.getFirstName(), driver.getLastName(), driver.getDriverCode());
        return ResponseEntity.ok(driverService.save(newDriver));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Driver> read(@PathVariable String id) {
        Driver readDriver = this.driverService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Driver not found"));
        return ResponseEntity.ok(readDriver);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Driver driver) {
        this.driverService.delete(driver);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.driverService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Driver>> findAll() {
        List<Driver> driverList = this.driverService.findAll();
        return ResponseEntity.ok(driverList);
    }

}
