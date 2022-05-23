package za.ac.cput.repository;

import za.ac.cput.domain.entity.ClassRoom;

import java.util.List;

public interface IClassRoomRepo extends IRepository<ClassRoom, String>
{
    List<ClassRoom> getAllClassRooms();
}
