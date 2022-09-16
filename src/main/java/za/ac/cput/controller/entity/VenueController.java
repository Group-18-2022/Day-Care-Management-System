package za.ac.cput.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.domain.entity.DayCareVenue;
import za.ac.cput.factory.entity.ClassRoomFactory;
import za.ac.cput.factory.entity.DayCareVenueFactory;
import za.ac.cput.service.entity.impl.ClassRoomServiceImpl;
import za.ac.cput.service.entity.impl.VenueServiceImpl;

import javax.validation.Valid;
import java.util.List;


    @RestController
    @RequestMapping("api/v1/day-care/venue/")
    public class VenueController
    {
        private final VenueServiceImpl venueService;

        @Autowired
        public VenueController(VenueServiceImpl venueService) {
            this.venueService = venueService;
        }

        @PostMapping("save")
        public ResponseEntity<DayCareVenue> save(@Valid @RequestBody DayCareVenue dayCareVenue) {
            DayCareVenue venue = DayCareVenueFactory.build(dayCareVenue.getDayCareName(), dayCareVenue.getAddress(), dayCareVenue.getPhone(), dayCareVenue.getPricipalId());
            DayCareVenue saved = venueService.save(venue);
            return ResponseEntity.ok(saved);
        }

        @GetMapping("read/{id}")
        public ResponseEntity<DayCareVenue> read(@PathVariable String id) {
            DayCareVenue venue =  this.venueService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venue Not Found"));
            return  ResponseEntity.ok(venue);
        }

        @DeleteMapping("delete")
        public ResponseEntity<Void> delete(DayCareVenue venue) {
            this.venueService.delete(venue);
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("delete/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable String id) {
            this.venueService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("all")
        public ResponseEntity<List<DayCareVenue>> findAll() {
            List<DayCareVenue> list = this.venueService.findAll();
            return ResponseEntity.ok(list);
        }

    }

