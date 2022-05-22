package za.ac.cput.repository.impl.lookup;
/**
 *
 * This is the Class Group Repository
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.repository.IClassGroupRepository;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClassGroupRespositoryImpl implements IClassGroupRepository {
    private static ClassGroupRespositoryImpl classGroupRepo = null;
    private Set<ClassGroup> classGroupDB = null;

    private ClassGroupRespositoryImpl(){
        classGroupDB = new LinkedHashSet<>();
    }

    public static ClassGroupRespositoryImpl getClassGroupRepo(){
        if(classGroupRepo == null) classGroupRepo = new ClassGroupRespositoryImpl();
        return classGroupRepo;
    }

    @Override
    public ClassGroup create(ClassGroup classGroup) {
        boolean createClassGroup = classGroupDB.add(classGroup);
        if(!createClassGroup)return null;
        return classGroup;
    }

    @Override
    public ClassGroup read(String classGroupID) {
        for(ClassGroup classGroup: classGroupDB)
            if(classGroup.getClassID().equals(classGroupID)) return classGroup;
        return null;
    }

    @Override
    public ClassGroup update(ClassGroup classGroup) {
        ClassGroup  updateClassGroup = read(classGroup.getClassID());
        if(updateClassGroup != null){
            classGroupDB.remove(updateClassGroup);
            classGroupDB.add(updateClassGroup);
            return classGroup;
        }
        return null;
    }

    @Override
    public boolean delete(String classGroupID) {
        ClassGroup deleteClassGroup = read(classGroupID);
        if(deleteClassGroup != null){
            classGroupDB.remove(deleteClassGroup);
            return true;
        }
        return false;
    }

    @Override
    public Set<ClassGroup> getAllClassGroups() {
        return classGroupDB;
    }
}
