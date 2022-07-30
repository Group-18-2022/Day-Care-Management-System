package za.ac.cput.service.entity;

import za.ac.cput.domain.entity.Parent;
import za.ac.cput.service.IService;

import java.util.List;

public interface ParentService extends IService<Parent, String> {
    void deleteById(String id);
    List<Parent> findAll();
}
