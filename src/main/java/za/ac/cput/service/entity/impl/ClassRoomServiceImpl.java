package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.repository.entity.IClassRoomRepo;
import za.ac.cput.service.entity.ClassRoomService;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomServiceImpl implements ClassRoomService
{
    private IClassRoomRepo classRoomRepo;

    @Autowired
    public ClassRoomServiceImpl(IClassRoomRepo classRoomRepo) {
        this.classRoomRepo = classRoomRepo;
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return this.classRoomRepo.save(classRoom);
    }

    @Override
    public Optional<ClassRoom> read(String id) {
        return this.classRoomRepo.findById(id);
    }

    @Override
    public void delete(ClassRoom classRoom) {
        this.classRoomRepo.delete(classRoom);

    }

    @Override
    public void deleteById(String id) {
        this.classRoomRepo.deleteById(id);

    }

    @Override
    public List<ClassRoom> findAll() {
        return this.classRoomRepo.findAll();
    }
}
