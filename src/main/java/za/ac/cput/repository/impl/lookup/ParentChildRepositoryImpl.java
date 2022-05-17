package za.ac.cput.repository.impl.lookup;

import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.repository.IParentChildRepository;

import java.util.ArrayList;
import java.util.List;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

public class ParentChildRepositoryImpl implements IParentChildRepository {
    private static ParentChildRepositoryImpl repository = null;
    private List<ParentChild> parentChildrenDB;

    private ParentChildRepositoryImpl() {
        this.parentChildrenDB = new ArrayList<>();
    }

    public static ParentChildRepositoryImpl getRepository() {
        if(repository == null) repository = new ParentChildRepositoryImpl();
        return repository;
    }

    @Override
    public ParentChild create(ParentChild parentChild) {
        boolean isSuccessful = parentChildrenDB.add(parentChild);
        if(!isSuccessful) return null;
        return parentChild;
    }

    @Override
    public ParentChild read(String parentID) {
        return parentChildrenDB
                .stream()
                .filter(parChild -> parChild.getParentID().equals(parentID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ParentChild update(ParentChild parentChild) {
        var currentParentChild = read(parentChild.getParentID());
        if(currentParentChild != null) {
            parentChildrenDB.remove(currentParentChild);
            parentChildrenDB.add(parentChild);
            return parentChild;
        }
        return null;
    }

    @Override
    public boolean delete(String parentID) {
        boolean isSuccessful = true;
        var parentChildToDelete = read(parentID);
        if(parentChildToDelete != null) isSuccessful = parentChildrenDB.remove(parentChildToDelete);
        return isSuccessful;
    }

    @Override
    public List<ParentChild> getAllParentChild() {
        return parentChildrenDB;
    }

    @Override
    public boolean contains(String parentID) {
        var parentChild = read(parentID);
        if(parentChild != null) return true;
        return false;
    }
}
