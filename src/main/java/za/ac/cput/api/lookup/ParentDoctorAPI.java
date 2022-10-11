package za.ac.cput.api.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.service.entity.impl.DoctorServiceImpl;
import za.ac.cput.service.entity.impl.ParentServiceImpl;
import za.ac.cput.service.lookup.Impl.ParentDoctorServiceImpl;

@Component
public class ParentDoctorAPI {
    private final ParentServiceImpl parentService;
    private final DoctorServiceImpl doctorService;
    private final ParentDoctorServiceImpl parentDoctorService;

    @Autowired
    public ParentDoctorAPI(ParentServiceImpl parentService, DoctorServiceImpl doctorService, ParentDoctorServiceImpl parentDoctorService) {
        this.parentService = parentService;
        this.doctorService = doctorService;
        this.parentDoctorService = parentDoctorService;
    }

    public ParentDoctor save(ParentDoctor parentDoctor) {
        this.doctorService.read(parentDoctor.getDoctorID())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor Not Found"));
        this.parentService.read(parentDoctor.getParentID())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent Not Found"));
        return this.parentDoctorService.save(parentDoctor);
    }
}
