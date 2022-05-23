package za.ac.cput.repository.impl.user;

/* SecretaryRepositoryImpl.java
   Repository for the Secretary
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import za.ac.cput.domain.user.Secretary;
import za.ac.cput.repository.ISecretaryRepository;

import java.util.HashSet;
import java.util.Set;

public class SecretaryRepositoryImpl implements ISecretaryRepository {
    private static SecretaryRepositoryImpl repository = null;
    private Set<Secretary> secretaryDB = null;

    private SecretaryRepositoryImpl() {
        secretaryDB = new HashSet<Secretary>();
    }

    public static SecretaryRepositoryImpl getRepository() {
        if (repository == null){
            repository = new SecretaryRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Secretary create(Secretary secretary) {
        boolean success = secretaryDB.add(secretary);
        if(!success)
            return null;
        return secretary;
    }

    @Override
    public Secretary read(String secretaryID) {
        Secretary secretary = secretaryDB.stream()
                .filter(e -> e.getSecretaryID().equals(secretaryID))
                .findAny()
                .orElse(null);
        return secretary;
    }

    @Override
    public Secretary update(Secretary secretary) {
        Secretary oldEmergencyServiceProvider = read(secretary.getSecretaryID());
        if (oldEmergencyServiceProvider !=null){
            secretaryDB.remove(oldEmergencyServiceProvider);
            secretaryDB.add(secretary);
            return secretary;
        }
        return null;
    }

    @Override
    public boolean delete(String secretaryID) {
        Secretary secretaryToDelete = read(secretaryID);
        if (secretaryToDelete == null)
            return false;
        secretaryDB.remove(secretaryToDelete);
        return true;
    }

    @Override
    public Set<Secretary> getAll() {
        return secretaryDB;
    }

    @Override
    public boolean contains(String secretaryID) {
        var secretary = read(secretaryID);
        if(secretary != null) return true;
        return false;
    }
}
