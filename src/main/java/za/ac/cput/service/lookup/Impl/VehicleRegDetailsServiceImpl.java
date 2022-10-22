package za.ac.cput.service.lookup.Impl;

/*
   Mponeng Ratego
   216178991
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.VehicleRegDetails;
import za.ac.cput.repository.lookup.IVehicleRegDetailsRepository;
import za.ac.cput.service.lookup.VehicleRegDetailsService;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleRegDetailsServiceImpl implements VehicleRegDetailsService {

    private IVehicleRegDetailsRepository vehicleRegDetailsRepo;

    @Autowired
    public VehicleRegDetailsServiceImpl(IVehicleRegDetailsRepository vehicleRegDetailsRepo){
        this.vehicleRegDetailsRepo = vehicleRegDetailsRepo;
    }
    @Override
    public VehicleRegDetails save(VehicleRegDetails vehicleRegDetails) {
        return this.vehicleRegDetailsRepo.save(vehicleRegDetails);
    }

    @Override
    public Optional<VehicleRegDetails> read(String id) {
        return this.vehicleRegDetailsRepo.findById(id);
    }

    @Override
    public void delete(VehicleRegDetails vehicleRegDetails) {
        this.vehicleRegDetailsRepo.delete(vehicleRegDetails);
    }

    @Override
    public void deleteById(String id) {
        this.vehicleRegDetailsRepo.deleteById(id);
    }

    @Override
    public List<VehicleRegDetails> findAll() {
        return this.vehicleRegDetailsRepo.findAll();
    }
}
