package za.ac.cput.api.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.domain.lookup.ParentDoctor;
import za.ac.cput.service.entity.impl.DoctorServiceImpl;
import za.ac.cput.service.entity.impl.ParentServiceImpl;
import za.ac.cput.service.lookup.Impl.ParentDoctorServiceImpl;
import za.ac.cput.service.lookup.ParentChildService;

/*  Author : Karl Haupt
 *  Student Number: 220236585
 */

//TODO: Fix this class when Child is implement + Test Cases for the API and Controller

@Component
public class ParentChildAPI {
//    private final ParentServiceImpl parentService;
//    private final ChildServiceImpl childService;
//    private final ParentChildService parentChildService;
//
//    @Autowired
//    public ParentChildAPI(ParentServiceImpl parentService, ChildServiceImpl childService, ParentChildService parentChildService) {
//        this.parentService = parentService;
//        this.childService = childService;
//        this.parentChildService = parentChildService;
//    }
//
//    public ParentDoctor save(ParentChild parentChild) {
//        this.childService.read(parentChild.getChildID())
//                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Child Not Found"));
//        this.parentService.read(parentChild.getParentID())
//                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent Not Found"));
//        return this.parentChildService.save(parentChild);
//    }
}
