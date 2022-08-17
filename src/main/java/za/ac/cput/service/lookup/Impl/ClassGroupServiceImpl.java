package za.ac.cput.service.lookup.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.entity.Child;
import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.repository.entity.IChildRepository;
import za.ac.cput.repository.lookup.IClassGroupRepository;
import za.ac.cput.service.lookup.ClassGroupService;

import java.util.List;
import java.util.Optional;

/**
 *
 * This is the Class Group Service 
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
@Service
public class ClassGroupServiceImpl implements ClassGroupService {

    private IClassGroupRepository classGroupRepo;

    @Autowired
    public ClassGroupServiceImpl(IClassGroupRepository classGroupRepo){
        this.classGroupRepo = classGroupRepo;
    }
    @Override
    public ClassGroup save(ClassGroup classGroup) {
        return this.classGroupRepo.save(classGroup);
    }

    @Override
    public Optional<ClassGroup> read(String id) {
        return this.classGroupRepo.findById(id);
    }

    @Override
    public void delete(ClassGroup classGroup) {
        this.classGroupRepo.delete(classGroup);
    }

    @Override
    public void deleteById(String id) {
        this.classGroupRepo.deleteById(id);
    }

    @Override
    public List<ClassGroup> findAll() {
        return this.classGroupRepo.findAll();
    }
}
