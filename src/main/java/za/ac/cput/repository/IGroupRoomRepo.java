package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.GroupRoom;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IGroupRoomRepo extends JpaRepository<GroupRoom, String>
{
    @Query(value = "SELECT * FROM group_room WHERE class_group_id = ?1 AND class_room_id = ?2", nativeQuery = true)
    Optional<GroupRoom> readById(String groupId, String roomId);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM group_room WHERE class_group_id=?1 AND class_room_id =?2", nativeQuery = true)
    void deleteById(String groupId, String roomId);


}
