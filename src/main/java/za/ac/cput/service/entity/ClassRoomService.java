package za.ac.cput.service.entity;

import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.service.IService;

import java.util.List;

public interface ClassRoomService extends IService<ClassRoom, String>
{
    void deleteById(String id);
    List<ClassRoom> findAll();
}
