package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.GroupRoom;

import java.util.List;

@Repository
public interface IGroupRoomRepo extends JpaRepository<GroupRoom, String>
{
}
