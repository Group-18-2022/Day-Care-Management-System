package za.ac.cput.repository.impl.lookup;

/* ESPRepositoryImpl.java
   Repository for the Emergency Service Provider
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import za.ac.cput.domain.lookup.EmergencyServiceProvider;
import za.ac.cput.repository.IESPRepository;

import java.util.HashSet;
import java.util.Set;

public class ESPRepositoryImpl implements IESPRepository {
    private static ESPRepositoryImpl repository = null;
    private Set<EmergencyServiceProvider> espDB = null;

    private ESPRepositoryImpl() {
        espDB = new HashSet<EmergencyServiceProvider>();
    }

    public static ESPRepositoryImpl getRepository() {
        if (repository == null){
            repository = new ESPRepositoryImpl();
        }
        return repository;
    }

    @Override
    public EmergencyServiceProvider create(EmergencyServiceProvider esp) {
        boolean success = espDB.add(esp);
        if(!success)
            return null;
        return esp;
    }

    @Override
    public EmergencyServiceProvider read(String serviceID) {
        EmergencyServiceProvider esp = espDB.stream()
                .filter(e -> e.getServiceID().equals(serviceID))
                .findAny()
                .orElse(null);
        return esp;
    }

    @Override
    public EmergencyServiceProvider update(EmergencyServiceProvider esp) {
        EmergencyServiceProvider oldEmergencyServiceProvider = read(esp.getServiceID());
        if (oldEmergencyServiceProvider !=null){
            espDB.remove(oldEmergencyServiceProvider);
            espDB.add(esp);
            return esp;
        }
        return null;
    }

    @Override
    public boolean delete(String serviceID) {
        EmergencyServiceProvider espToDelete = read(serviceID);
        if (espToDelete == null)
            return false;
        espDB.remove(espToDelete);
        return true;
    }

    @Override
    public Set<EmergencyServiceProvider> getAll() {
        return espDB;
    }

    @Override
    public boolean contains(String serviceID) {
        var esp = read(serviceID);
        if(esp != null) return true;
        return false;
    }
}
