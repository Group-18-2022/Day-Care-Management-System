package za.ac.cput.service.lookup;

import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface ParentDoctorService extends IService<ParentDoctor, ParentDoctor.ParentDoctorID> {
    void deleteById(ParentDoctor.ParentDoctorID parentDoctorID);
    List<ParentDoctor> findAll();
}
