package za.ac.cput.service.user.Impl;

/* SecretaryServiceImpl.java
   Service Implementation for the Secretary
   Author: Joshua Daniel Jonkers(215162668)
   Date: 17/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.Secretary;
import za.ac.cput.repository.ISecretaryRepository;
import za.ac.cput.service.user.SecretaryService;

import java.util.List;
import java.util.Optional;

@Service
public class SecretaryServiceImpl implements SecretaryService {
    private ISecretaryRepository repository;

    @Autowired
    public SecretaryServiceImpl(ISecretaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Secretary save(Secretary secretary) {
        return this.repository.save(secretary);
    }

    @Override
    public Optional<Secretary> read(String secretaryID) {
        return this.repository.findById(secretaryID);
    }

    @Override
    public void delete(Secretary secretary) {
        this.repository.delete(secretary);
    }

    @Override
    public void deleteByID(String secretaryID) {
        this.repository.deleteById(secretaryID);
    }

    @Override
    public List<Secretary> findAll() {
        return this.repository.findAll();
    }
}
