package za.ac.cput.service.user.Impl;

/*
   Mponeng Ratego
   216178991
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.Driver;
import za.ac.cput.repository.user.IDriverRepository;
import za.ac.cput.service.user.DriverService;


import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    private IDriverRepository repository;

    @Autowired
    public DriverServiceImpl(IDriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public Driver save(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public Optional<Driver> read(String idNumber) {
        return this.repository.findById(idNumber);
    }

    @Override
    public void delete(Driver driver) {
        this.repository.delete(driver);
    }

    @Override
    public void deleteByID(String idNumber) {
        this.repository.deleteById(idNumber);
    }

    @Override
    public List<Driver> findAll() {
        return this.repository.findAll();
    }
}
