package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.entity.DayCareVenue;
import za.ac.cput.repository.entity.IVenueRepo;
import za.ac.cput.service.entity.VenueService;

import java.util.List;
import java.util.Optional;

@Service
public class VenueServiceImpl implements VenueService
{
    private IVenueRepo venueRepo;

    @Autowired
    public VenueServiceImpl(IVenueRepo venueRepo) {
        this.venueRepo = venueRepo;
    }

    @Override
    public DayCareVenue save(DayCareVenue dayCareVenue) {
        return this.venueRepo.save(dayCareVenue);
    }

    @Override
    public Optional<DayCareVenue> read(String s) {
        return this.venueRepo.findById(s);
    }

    @Override
    public void delete(DayCareVenue dayCareVenue)
    {
        this.venueRepo.delete(dayCareVenue);
    }

    @Override
    public void deleteById(String id)
    {
        this.deleteById(id);
    }

    @Override
    public List<DayCareVenue> findAll()
    {
        return this.venueRepo.findAll();
    }
}
