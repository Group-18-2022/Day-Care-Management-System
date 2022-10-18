package za.ac.cput.service.user;

/*
   Mponeng Ratego
   216178991
 */

import za.ac.cput.domain.user.Driver;
import za.ac.cput.service.IService;

import java.util.List;

public interface DriverService extends IService<Driver, String> {
    void deleteByID(String idNumber);
    List<Driver> findAll();
}
