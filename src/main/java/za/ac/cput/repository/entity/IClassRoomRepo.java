package za.ac.cput.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.entity.ClassRoom;

import java.util.List;

@Repository
public interface IClassRoomRepo extends JpaRepository<ClassRoom, String>
{
}
