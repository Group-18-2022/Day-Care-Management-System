package za.ac.cput.service.lookup.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.repository.lookup.IParentChildRepository;
import za.ac.cput.service.lookup.ParentChildService;

import java.util.List;
import java.util.Optional;

@Service
public class ParentChildServiceImpl implements ParentChildService {

    private IParentChildRepository repository;

    @Autowired
    public ParentChildServiceImpl(IParentChildRepository repository) {
        this.repository = repository;
    }

    @Override
    public ParentChild save(ParentChild parentChild) {
        return this.repository.save(parentChild);
    }

    @Override
    public Optional<ParentChild> read(ParentChild.ParentChildID parentChildID) {
        return this.repository.findById(parentChildID);
    }

    @Override
    public void delete(ParentChild parentChild) {
        this.repository.delete(parentChild);
    }

    @Override
    public void deleteById(ParentChild.ParentChildID parentChildID) {
        this.repository.deleteById(parentChildID);
    }

    @Override
    public List<ParentChild> findAll() {
        return this.repository.findAll();
    }
}
