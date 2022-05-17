package za.ac.cput.repository.impl.user;

import za.ac.cput.domain.user.Doctor;
import za.ac.cput.repository.IDoctorRepository;

import java.util.ArrayList;
import java.util.List;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

public class DoctorRepositoryImpl implements IDoctorRepository {
    private static DoctorRepositoryImpl repository = null;
    private List<Doctor> doctorDB;

    private DoctorRepositoryImpl() {
        this.doctorDB = new ArrayList<>();
    }

    public static DoctorRepositoryImpl getRepository() {
        if(repository == null) repository = new DoctorRepositoryImpl();
        return repository;
    }

    @Override
    public Doctor create(Doctor doctor) {
        boolean isSuccessful = doctorDB.add(doctor);
        if(!isSuccessful) return null;
        return doctor;
    }

    @Override
    public Doctor read(String doctorID) {
        return doctorDB
                .stream()
                .filter(doc -> doc.getDoctorID().equals(doctorID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Doctor update(Doctor doctor) {
        var currentDoctor = read(doctor.getDoctorID());
        if(currentDoctor != null) {
            doctorDB.remove(currentDoctor);
            doctorDB.add(doctor);
            return doctor;
        }
        return null;
    }

    @Override
    public boolean delete(String doctorID) {
        boolean isSuccessful = true;
        var doctorToDelete = read(doctorID);
        if(doctorToDelete != null) isSuccessful = doctorDB.remove(doctorToDelete);
        return isSuccessful;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDB;
    }

    @Override
    public boolean contains(String doctorID) {
        var doctor = read(doctorID);
        if(doctor != null) return true;
        return false;
    }
}
