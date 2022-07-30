package za.ac.cput.controller.lookup;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.lookup.ParentChildAPI;
import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.factory.lookup.ParentChildFactory;
import za.ac.cput.service.lookup.Impl.ParentChildServiceImpl;

import javax.validation.Valid;
import java.util.List;

/*  Author : Karl Haupt
 *  Student Number: 220236585
 */

@RestController
@RequestMapping("api/v1/day-care/parent-child/")
public class ParentChildController {
    private final ParentChildServiceImpl parentChildService;
    private final ParentChildAPI api;

    @Autowired
    public ParentChildController(ParentChildServiceImpl employeeAddressService, ParentChildAPI api) {
        this.parentChildService = employeeAddressService;
        this.api = api;
    }

//    @PostMapping("save")
//    public ResponseEntity<ParentChild> save(@Valid @RequestBody ParentChild parentChild) {
//        ParentChild buildParentChild = ParentChildFactory.buildParentChild(parentChild.getParentID(), parentChild.getChildID());
//        ParentChild parentChildSaved = this.api.save(buildParentChild);
//        return ResponseEntity.ok(parentChildSaved);
//    }

    @GetMapping("read/{id}")
    public ResponseEntity<ParentChild> read(@Valid @RequestBody ParentChild.ParentChildID parentChildID) {
        ParentChild readParentChild = this.parentChildService.read(parentChildID).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent/Child Not Found"));
        return ResponseEntity.ok(readParentChild);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(ParentChild parentChild) {
        this.parentChildService.delete(parentChild);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<ParentChild>> findAll() {
        List<ParentChild> findAllEmployeeAddressList = this.parentChildService.findAll();
        return ResponseEntity.ok(findAllEmployeeAddressList);
    }
}
