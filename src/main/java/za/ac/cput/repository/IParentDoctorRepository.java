package za.ac.cput.repository;

import za.ac.cput.domain.lookup.ParentDoctor;

import java.util.List;

public interface IParentDoctorRepository extends IRepository<ParentDoctor, String> {
    List<ParentDoctor> getAllParentDoctors();
    boolean contains(String ID);
}
