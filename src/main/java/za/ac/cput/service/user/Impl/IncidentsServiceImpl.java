package za.ac.cput.service.user.Impl;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.Incidents;
import za.ac.cput.repository.user.IIncidentsRepository;
import za.ac.cput.service.user.IncidentsService;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentsServiceImpl implements IncidentsService {
    private IIncidentsRepository repository;

    @Autowired
    public IncidentsServiceImpl(IIncidentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Incidents save(Incidents incidents) {
        return this.repository.save(incidents);
    }

    @Override
    public Optional<Incidents> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(Incidents incidents) {
        this.repository.delete(incidents);
    }

    @Override
    public void deleteById(String Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public List<Incidents> findAll() {
        return this.repository.findAll();
    }

    public Optional<Incidents> findByIncidentId(String incidentId) {
        return this.repository.findByIncidentId(incidentId);

    }
}
