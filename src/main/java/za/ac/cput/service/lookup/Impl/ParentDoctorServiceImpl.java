package za.ac.cput.service.lookup.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.repository.lookup.IParentDoctorRepository;
import za.ac.cput.service.lookup.ParentDoctorService;

import java.util.List;
import java.util.Optional;

@Service
public class ParentDoctorServiceImpl implements ParentDoctorService {

    private IParentDoctorRepository repository;

    @Autowired
    public ParentDoctorServiceImpl(IParentDoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public ParentDoctor save(ParentDoctor parentDoctor) {
        return this.repository.save(parentDoctor);
    }

    @Override
    public Optional<ParentDoctor> read(ParentDoctor.ParentDoctorID parentDoctorID) {
        return this.repository.findById(parentDoctorID);
    }

    @Override
    public void delete(ParentDoctor parentDoctor) {
        this.repository.delete(parentDoctor);
    }

    @Override
    public void deleteById(ParentDoctor.ParentDoctorID parentDoctorID) {
        this.repository.deleteById(parentDoctorID);
    }

    @Override
    public List<ParentDoctor> findAll() {
        return this.repository.findAll();
    }
}
