package za.ac.cput.repository.impl.entity;

import za.ac.cput.domain.entity.Parent;
import za.ac.cput.repository.IParentRepository;

import java.util.ArrayList;
import java.util.List;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

public class ParentRepositoryImpl implements IParentRepository {
    private static ParentRepositoryImpl repository;
    private List<Parent> parentDB;

    private ParentRepositoryImpl() {
        this.parentDB = new ArrayList<>();
    }

    public static ParentRepositoryImpl getRepository() {
        if(repository == null) repository = new ParentRepositoryImpl();
        return repository;
    }

    @Override
    public Parent create(Parent parent) {
        boolean isSuccessful = parentDB.add(parent);
        if(!isSuccessful) return null;
        return parent;
    }

    @Override
    public Parent read(String parentID) {
        return parentDB
                .stream()
                .filter(p -> p.getParentID().equals(parentID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Parent update(Parent parent) {
        var currentParent = read(parent.getParentID());
        if(currentParent != null) {
            parentDB.remove(currentParent);
            parentDB.add(parent);
            return parent;
        }
        return null;
    }

    @Override
    public boolean delete(String parentID) {
        boolean isSuccessful = true;
        var parentToDelete = read(parentID);
        if(parentToDelete != null) isSuccessful = parentDB.remove(parentToDelete);
        return isSuccessful;
    }

    @Override
    public List<Parent> getParents() {
        return parentDB;
    }

    @Override
    public boolean contains(String parentID) {
        var parent = read(parentID);
        if(parent != null) return true;
        return false;
    }
}
