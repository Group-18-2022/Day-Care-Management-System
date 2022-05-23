package za.ac.cput.repository.impl.entity;
/**
 *
 * This is the Child Repository
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import za.ac.cput.domain.entity.Child;
import za.ac.cput.repository.IChildRepository;

import java.util.LinkedHashSet;
import java.util.Set;

public class ChildRepositoryImpl implements IChildRepository {
    private static ChildRepositoryImpl childRepo = null;
    private Set<Child> childDB = null;

    private ChildRepositoryImpl(){
        childDB = new LinkedHashSet<>();
    }

    public static ChildRepositoryImpl getChildRepo()
    {
        if(childRepo == null) childRepo = new ChildRepositoryImpl();
        return childRepo;
    }

    @Override
    public Child create(Child child) {
        boolean createChild = childDB.add(child);
        if(!createChild)return null;
        return child;
    }

    @Override
    public Child read(String childID) {
        for(Child child: childDB)
            if(child.getChildID().equals(childID)) return child;
        return null;
    }

    @Override
    public Child update(Child child) {
        Child childUpdate = read(child.getChildID());
        if(childUpdate != null){
            childDB.remove(childUpdate);
            childDB.add(childUpdate);
            return child;
        }
        return null;
    }

    @Override
    public boolean delete(String childID) {
        Child deleteChild = read(childID);
        if(deleteChild != null){
            childDB.remove(deleteChild);
            return true;
        }
        return false;
    }

    @Override
    public Set<Child> getAllChildren() {
        return childDB;
    }
}
