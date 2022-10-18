package za.ac.cput.service.user.Impl;

/* PrincipalServiceImpl.java
   Service Implementation for the Principal
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.Principal;
import za.ac.cput.repository.IPrincipalRepository;
import za.ac.cput.service.user.PrincipalService;

import java.util.List;
import java.util.Optional;

@Service
public class PrincipalServiceImpl implements PrincipalService {
    private IPrincipalRepository repository;

    @Autowired
    public PrincipalServiceImpl(IPrincipalRepository repo) {
        this.repository = repo;
    }

    @Override
    public Principal save(Principal principal) {

        return this.repository.save(principal); //problem here probably
    }

    @Override
    public Optional<Principal> read(String principalID) {
        return this.repository.findById(principalID);
    }

    @Override
    public void delete(Principal principal) {
        this.repository.delete(principal);
    }

    @Override
    public void deleteByID(String principalID) {
        this.repository.deleteById(principalID);
    }

    @Override
    public List<Principal> findAll() {
        return this.repository.findAll();
    }
}
