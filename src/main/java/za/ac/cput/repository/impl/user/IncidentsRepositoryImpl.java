package za.ac.cput.repository.impl.user;


import za.ac.cput.domain.user.Incidents;
import za.ac.cput.repository.IIncidentsRepository;

import java.util.ArrayList;
import java.util.List;

public class IncidentsRepositoryImpl implements IIncidentsRepository {
    private static IncidentsRepositoryImpl repository;
    private List<Incidents> incidentsDB;

    private IncidentsRepositoryImpl() {
        this.incidentsDB = new ArrayList<>();
    }

    public static IncidentsRepositoryImpl getRepository() {
        if(repository == null) repository = new IncidentsRepositoryImpl();
        return repository;
    }

    @Override
    public Incidents create(Incidents incidents) {
        boolean isSuccessful = incidentsDB.add(incidents);
        if(!isSuccessful) return null;
        return incidents;
    }

    @Override
    public Incidents read(String incidentID) {
        return incidentsDB
                .stream()
                .filter(p -> p.getIncidentID().equals(incidentID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Incidents update(Incidents incidents) {
        var currentIncident = read(incidents.getIncidentID());
        if(currentIncident != null) {
            incidentsDB.remove(currentIncident);
            incidentsDB.add(incidents);
            return incidents;
        }
        return null;
    }

    @Override
    public boolean delete(String incidentID) {
        boolean isSuccessful = true;
        var incidentToDelete = read(incidentID);
        if(incidentToDelete != null) isSuccessful = incidentsDB.remove(incidentToDelete);
        return isSuccessful;
    }

    @Override
    public List<Incidents> getAllIncidents() {
        return incidentsDB;
    }

    @Override
    public boolean contains(String incidentID) {
        var incidents = read(incidentID);
        if(incidents != null) return true;
        return false;
    }

}
