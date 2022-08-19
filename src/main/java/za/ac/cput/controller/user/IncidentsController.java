package za.ac.cput.controller.user;

/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.user.Incidents;
import za.ac.cput.domain.user.Teacher;
import za.ac.cput.factory.user.IncidentsFactory;
import za.ac.cput.factory.user.TeacherFactory;
import za.ac.cput.service.user.Impl.IncidentsServiceImpl;
import za.ac.cput.service.user.Impl.TeacherServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/day-care/incidents/")
public class IncidentsController {
    private final IncidentsServiceImpl incidentsService;

    @Autowired
    public IncidentsController(IncidentsServiceImpl incidentsService) {
        this.incidentsService = incidentsService;
    }

    @PostMapping("save")
    public ResponseEntity<Incidents> save(@Valid @RequestBody Incidents incidents) {
        Incidents newIncidents = IncidentsFactory.build(incidents.getIncidentID(), incidents.getTeacherID(), incidents.getChildID(), incidents.getDate(), incidents.getLocation(), incidents.getInjuryDescription());
        Incidents IncidentsSaved = this.incidentsService.save(newIncidents);
        return ResponseEntity.ok(IncidentsSaved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Incidents> read(@PathVariable String id) {
        Incidents readIncidents = this.incidentsService.read(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Incident not found"));
        return ResponseEntity.ok(readIncidents);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Incidents incidents) {
        this.incidentsService.delete(incidents);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.incidentsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Incidents>> findAll() {
        List<Incidents> findAllIncidentsList = this.incidentsService.findAll();
        return ResponseEntity.ok(findAllIncidentsList);
    }
}
