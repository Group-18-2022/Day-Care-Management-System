package za.ac.cput.service.lookup;

/*
   Mponeng Ratego
   216178991
 */


import za.ac.cput.domain.lookup.VehicleRegDetails;

import java.util.List;
import java.util.Optional;

public interface VehicleRegDetailsService {
    VehicleRegDetails save(VehicleRegDetails vehicleRegDetails);

    Optional<VehicleRegDetails> read(String id);

    void delete(VehicleRegDetails vehicleRegDetails);

    void deleteById(String id);

    List<VehicleRegDetails> findAll();
}
