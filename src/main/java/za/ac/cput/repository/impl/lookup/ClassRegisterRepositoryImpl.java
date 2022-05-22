package za.ac.cput.repository.impl.lookup;
/**
 *
 * This is the Class Register Repository
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
import za.ac.cput.domain.lookup.ClassRegister;
import za.ac.cput.repository.IClassRegisterRepository;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClassRegisterRepositoryImpl implements IClassRegisterRepository {
    private static ClassRegisterRepositoryImpl classRegisterRepo = null;
    private static Set<ClassRegister> classRegisterDB = null;

    private ClassRegisterRepositoryImpl(){
        classRegisterDB = new LinkedHashSet<>();
    }

    public static ClassRegisterRepositoryImpl getClassRegisterRepo(){
        if(classRegisterRepo == null)
            return classRegisterRepo = new ClassRegisterRepositoryImpl();
        return classRegisterRepo;
    }


    @Override
    public ClassRegister create(ClassRegister classRegister) {
        boolean createClassRegister = classRegisterDB.add(classRegister);
        if(!createClassRegister) return null;
        return classRegister;
    }

    @Override
    public ClassRegister read(String classRegisterID) {
        for(ClassRegister classRegister: classRegisterDB)
            if(classRegister.getRosterID().equals(classRegisterID))
                return classRegister;
        return null;
    }

    @Override
    public ClassRegister update(ClassRegister classRegister) {
        ClassRegister updateClassRegister = read(classRegister.getRosterID());
        if(updateClassRegister != null){
            classRegisterDB.remove(updateClassRegister);
            classRegisterDB.add(updateClassRegister);
            return classRegister;
        }
        return null;
    }

    @Override
    public boolean delete(String classRegisterID) {
        ClassRegister  deleteClassRegister = read(classRegisterID);
        if(deleteClassRegister != null){
            classRegisterDB.remove(deleteClassRegister);
            return true;
        }
        return false;
    }

    @Override
    public Set<ClassRegister> getAllClassRegister() {
        return classRegisterDB;
    }
}
