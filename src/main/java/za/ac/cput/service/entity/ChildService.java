package za.ac.cput.service.entity;

import za.ac.cput.domain.entity.Child;
import za.ac.cput.service.IService;

import java.util.List;
/**
 *
 * This is the Child Services Interface
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public interface ChildService extends IService<Child, String> {

    void deleteById(String id);
    List<Child> findAll();

}
