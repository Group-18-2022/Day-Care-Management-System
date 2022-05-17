package za.ac.cput.repository.impl.lookup;

import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.repository.IParentDoctorRepository;

import java.util.ArrayList;
import java.util.List;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

public class ParentDoctorRepositoryImpl implements IParentDoctorRepository {
    private static ParentDoctorRepositoryImpl repository = null;
    private List<ParentDoctor> parentDoctorDB;

    private ParentDoctorRepositoryImpl() {
        this.parentDoctorDB = new ArrayList<>();
    }

    public static ParentDoctorRepositoryImpl getRepository() {
        if(repository == null) repository = new ParentDoctorRepositoryImpl();
        return repository;
    }

    @Override
    public ParentDoctor create(ParentDoctor parentDoctor) {
        boolean isSuccessful = parentDoctorDB.add(parentDoctor);
        if(!isSuccessful) return null;
        return parentDoctor;
    }

    @Override
    public ParentDoctor read(String parentID) {
        return parentDoctorDB
                .stream()
                .filter(dp -> dp.getParentID().equals(parentID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ParentDoctor update(ParentDoctor parentDoctor) {
        var currentParentDoctor = read(parentDoctor.getParentID());
        if(currentParentDoctor != null) {
            parentDoctorDB.remove(parentDoctor);
            parentDoctorDB.add(parentDoctor);
            return parentDoctor;
        }
        return null;
    }

    @Override
    public boolean delete(String parentID) {
        boolean isSuccessful = true;
        var parDocToDelete = read(parentID);
        if(parDocToDelete != null) isSuccessful = parentDoctorDB.remove(parDocToDelete);
        return isSuccessful;
    }

    @Override
    public List<ParentDoctor> getAllParentDoctors() {
        return parentDoctorDB;
    }

    @Override
    public boolean contains(String parentID) {
        var doctor = read(parentID);
        if(doctor != null) return true;
        return false;
    }
}
