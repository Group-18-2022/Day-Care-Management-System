package za.ac.cput.repository;

import za.ac.cput.domain.user.Doctor;

import java.util.List;

public interface IDoctorRepository extends IRepository<Doctor, String> {
    List<Doctor> getAllDoctors();
    boolean contains(String ID);
}
