package za.ac.cput.service.lookup;

import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.domain.lookup.GroupRoom;
import za.ac.cput.service.IService;

import java.util.List;

public interface GroupRoomService extends IService<GroupRoom, String>
{
    void deleteById(String idOne, String idTwo);
    List<GroupRoom> findAll();
}
