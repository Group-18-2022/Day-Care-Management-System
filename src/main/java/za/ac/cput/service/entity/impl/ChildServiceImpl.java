package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.entity.Child;
import za.ac.cput.repository.entity.IChildRepository;
import za.ac.cput.service.entity.ChildService;

import java.util.List;
import java.util.Optional;
/**
 *
 * This is the Child Services
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
@Service
public class ChildServiceImpl implements ChildService {
    private IChildRepository childRepo;

    @Autowired
    public ChildServiceImpl(IChildRepository childRepo){
        this.childRepo = childRepo;
    }
    @Override
    public Child save(Child child) {
        return this.childRepo.save(child);
    }

    @Override
    public Optional<Child> read(String id) {
        return this.childRepo.findById(id);
    }

    @Override
    public void delete(Child child) {
        this.childRepo.delete(child);
    }

    @Override
    public void deleteById(String id) {
        this.childRepo.deleteById(id);
    }

    @Override
    public List<Child> findAll() {
        return this.childRepo.findAll();
    }
}
