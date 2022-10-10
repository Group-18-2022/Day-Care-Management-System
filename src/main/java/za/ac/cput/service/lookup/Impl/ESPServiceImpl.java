package za.ac.cput.service.lookup.Impl;

/* ESPServiceImpl.java
   Service Implementation for the ESP
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.EmergencyServiceProvider;
import za.ac.cput.repository.IESPRepository;
import za.ac.cput.service.lookup.ESPService;

import java.util.List;
import java.util.Optional;

@Service
public class ESPServiceImpl implements ESPService {
    private IESPRepository repository;

    @Autowired
    public ESPServiceImpl(IESPRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmergencyServiceProvider save(EmergencyServiceProvider esp) {
        return this.repository.save(esp);
    }

    @Override
    public Optional<EmergencyServiceProvider> read(String serviceID) {
        return this.repository.findById(serviceID);
    }

    @Override
    public void delete(EmergencyServiceProvider esp) {
        this.repository.delete(esp);
    }

    @Override
    public void deleteByID(String serviceID) {
        this.repository.deleteById(serviceID);
    }

    @Override
    public List<EmergencyServiceProvider> findAll() {
        return this.repository.findAll();
    }
}
