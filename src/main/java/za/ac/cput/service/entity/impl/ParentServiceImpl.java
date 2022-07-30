package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.entity.Parent;
import za.ac.cput.repository.entity.IParentRepository;
import za.ac.cput.service.entity.ParentService;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {
    private IParentRepository repository;

    @Autowired
    public ParentServiceImpl(IParentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Parent save(Parent parent) {
        return this.repository.save(parent);
    }

    @Override
    public Optional<Parent> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Parent parent) {
        this.repository.delete(parent);
    }

    @Override
    public void deleteById(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Parent> findAll() {
        return this.repository.findAll();
    }
}
