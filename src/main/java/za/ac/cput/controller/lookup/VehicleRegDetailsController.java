package za.ac.cput.controller.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.VehicleRegDetails;
import za.ac.cput.factory.lookup.VehicleRegDetailsFactory;
import za.ac.cput.service.lookup.Impl.VehicleRegDetailsServiceImpl;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/day-care/vehicleregdetails/")
public class VehicleRegDetailsController {

    private final VehicleRegDetailsServiceImpl vehicleRegDetailsService;

    @Autowired
    public VehicleRegDetailsController(VehicleRegDetailsServiceImpl vehicleRegDetailsService){
        this.vehicleRegDetailsService = vehicleRegDetailsService;
    }
    @PostMapping("save")
    public ResponseEntity<VehicleRegDetails> save(@Valid @RequestBody VehicleRegDetails vehicleRegDetails) {
        VehicleRegDetails detailssave = VehicleRegDetailsFactory.createVehicleRegDetails(vehicleRegDetails.getVehicleId(),vehicleRegDetails.getBrand(),vehicleRegDetails.getModel()
                ,vehicleRegDetails.getYear(),vehicleRegDetails.getRegDate());
        VehicleRegDetails saved = vehicleRegDetailsService.save(detailssave);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<VehicleRegDetails> read(@PathVariable String vehicleId) {
        VehicleRegDetails readDetails=  this.vehicleRegDetailsService.read(vehicleId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle Not Found"));
        return  ResponseEntity.ok(readDetails);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(VehicleRegDetails vehicleRegDetails) {
        vehicleRegDetailsService.delete(vehicleRegDetails);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String vehicleId) {
        this.vehicleRegDetailsService.deleteById(vehicleId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<VehicleRegDetails>> findAll() {
        List<VehicleRegDetails> vehicleRegDetailsList = this.vehicleRegDetailsService.findAll();
        return ResponseEntity.ok(vehicleRegDetailsList);
    }

}
