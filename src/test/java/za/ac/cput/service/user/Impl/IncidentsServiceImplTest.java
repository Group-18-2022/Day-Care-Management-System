package za.ac.cput.service.user.Impl;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.user.Incidents;
import za.ac.cput.factory.user.IncidentsFactory;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IncidentsServiceImplTest {
    private Incidents incidents;

    @Autowired
    private IncidentsServiceImpl incidentsService;

    @BeforeEach
    public void startUp(){
        this.incidents = IncidentsFactory.build("incident-id","teacher-id","child-id","date","location","injury-description");
    }

    @Test
    @Order(1)
    void save() {
        Incidents saveIncidents = this.incidentsService.save(incidents);
        assertEquals(this.incidents, saveIncidents);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Incidents> readIncidents = this.incidentsService.read(incidents.getIncidentID());
        assertAll(
                () -> assertTrue(readIncidents.isPresent()),
                () -> assertEquals(incidents, readIncidents.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        this.incidentsService.delete(this.incidents);
        findAll();
    }


    void findAll(){
        List<Incidents> incidentsList = this.incidentsService.findAll();
        assertEquals(0, incidentsList.size());
    }
    @Test
    @Order(3)
    void deleteById() {
        this.incidentsService.deleteById(incidents.getIncidentID());
        findAll();
    }


}