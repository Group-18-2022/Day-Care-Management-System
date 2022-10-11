package za.ac.cput.repository.user;

/*
   Mponeng Ratego
   216178991
 */

import za.ac.cput.domain.user.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDriverRepository extends JpaRepository<Driver, String> {
}
