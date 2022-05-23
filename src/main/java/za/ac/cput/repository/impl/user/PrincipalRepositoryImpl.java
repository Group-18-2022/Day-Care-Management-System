package za.ac.cput.repository.impl.user;

/* PrincipalRepositoryImpl.java
   Repository for the Principal
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import za.ac.cput.domain.user.Principal;
import za.ac.cput.repository.IPrincipalRepository;

import java.util.HashSet;
import java.util.Set;

public class PrincipalRepositoryImpl implements IPrincipalRepository {
    private static PrincipalRepositoryImpl repository = null;
    private Set<Principal> principalDB = null;

    private  PrincipalRepositoryImpl () {
        principalDB = new HashSet<Principal>();
    }

    public static PrincipalRepositoryImpl getRepository() {
        if (repository == null){
            repository = new PrincipalRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Principal create(Principal principal) {
        boolean success = principalDB.add(principal);
        if(!success)
            return null;
        return principal;
    }

    @Override
    public Principal read(String principalID) {
        Principal principal = principalDB.stream()
                .filter(e -> e.getPrincipalID().equals(principalID))
                .findAny()
                .orElse(null);
        return principal;
    }

    @Override
    public Principal update(Principal principal) {
        Principal oldPrincipal = read(principal.getPrincipalID());
        if (oldPrincipal !=null){
            principalDB.remove(oldPrincipal);
            principalDB.add(principal);
            return principal;
        }
        return null;
    }

    @Override
    public boolean delete(String principalID) {
        Principal principalToDelete = read(principalID);
        if (principalToDelete == null)
            return false;
        principalDB.remove(principalToDelete);
        return true;
    }

    @Override
    public Set<Principal> getAll() {
        return principalDB;
    }

    @Override
    public boolean contains(String principalID) {
        var principal = read(principalID);
        if(principal != null) return true;
        return false;
    }
}
