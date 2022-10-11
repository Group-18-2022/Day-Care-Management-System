package za.ac.cput.service.lookup.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.ClassRegister;
import za.ac.cput.repository.lookup.IClassRegisterRepository;
import za.ac.cput.service.lookup.ClassRegisterService;

import java.util.List;
import java.util.Optional;

/**
 *
 * This is the Class Register Service
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
@Service
public class ClassRegisterServiceImpl implements ClassRegisterService {
    private IClassRegisterRepository classRegisterRepo;

    @Autowired
    public ClassRegisterServiceImpl(IClassRegisterRepository classRegisterRepo){
        this.classRegisterRepo = classRegisterRepo;
    }
    @Override
    public ClassRegister save(ClassRegister classRegister) {
        return this.classRegisterRepo.save(classRegister);
    }

    @Override
    public Optional<ClassRegister> read(String id) {
        return this.classRegisterRepo.findById(id);
    }

    @Override
    public void delete(ClassRegister classRegister) {
        this.classRegisterRepo.delete(classRegister);
    }

    @Override
    public void deleteById(String id) {
        this.classRegisterRepo.deleteById(id);
    }

    @Override
    public List<ClassRegister> findAll() {
        return this.classRegisterRepo.findAll();
    }
}
