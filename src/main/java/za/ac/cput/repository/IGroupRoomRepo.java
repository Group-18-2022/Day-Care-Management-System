package za.ac.cput.repository;

import za.ac.cput.domain.lookup.GroupRoom;

import java.util.List;

public interface IGroupRoomRepo extends IRepository<GroupRoom, String>
{
    List<GroupRoom> getAllGroupRoom();
}
