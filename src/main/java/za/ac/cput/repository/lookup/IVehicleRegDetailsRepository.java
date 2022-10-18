package za.ac.cput.repository.lookup;

import za.ac.cput.domain.lookup.VehicleRegDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IVehicleRegDetailsRepository extends JpaRepository<VehicleRegDetails, String> {
}
