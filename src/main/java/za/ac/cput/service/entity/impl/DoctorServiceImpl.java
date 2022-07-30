package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.repository.entity.IDoctorRepository;
import za.ac.cput.service.entity.DoctorService;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorServiceImpl implements DoctorService {
    private IDoctorRepository repository;

    @Autowired
    public DoctorServiceImpl(IDoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return this.repository.save(doctor);
    }

    @Override
    public Optional<Doctor> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Doctor doctor) {
        this.repository.delete(doctor);
    }

    @Override
    public void deleteById(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Doctor> findAll() {
        return this.repository.findAll();
    }
}
