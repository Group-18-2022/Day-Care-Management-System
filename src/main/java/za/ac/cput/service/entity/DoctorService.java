package za.ac.cput.service.entity;

import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.service.IService;

import java.util.List;

public interface DoctorService extends IService<Doctor, String> {
    void deleteById(String id);
    List<Doctor> findAll();
}
