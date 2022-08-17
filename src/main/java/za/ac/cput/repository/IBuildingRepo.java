package za.ac.cput.repository;

import za.ac.cput.domain.entity.Building;

import java.util.List;

public interface IBuildingRepo extends IRepository<Building, String>
{
    List<Building> getAllBuildings();

}
