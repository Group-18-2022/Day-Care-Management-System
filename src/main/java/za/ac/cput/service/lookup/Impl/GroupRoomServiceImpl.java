package za.ac.cput.service.lookup.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.GroupRoom;
import za.ac.cput.repository.IGroupRoomRepo;
import za.ac.cput.repository.entity.IClassRoomRepo;
import za.ac.cput.service.lookup.GroupRoomService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupRoomServiceImpl implements GroupRoomService
{
    private IGroupRoomRepo groupRoomRepo;

    @Autowired
    public GroupRoomServiceImpl(IGroupRoomRepo groupRoomRepo) {
        this.groupRoomRepo = groupRoomRepo;
    }

    @Override
    public GroupRoom save(GroupRoom groupRoom) {
        return this.groupRoomRepo.save(groupRoom);
    }

    @Override
    public Optional<GroupRoom> read(String s) {
        return this.groupRoomRepo.findById(s);
    }

    @Override
    public void delete(GroupRoom groupRoom) {
        this.groupRoomRepo.delete(groupRoom);
    }

    @Override
    public void deleteById(String id)
    {
        this.groupRoomRepo.deleteById(id);
    }

    @Override
    public List<GroupRoom> findAll() {
        return this.groupRoomRepo.findAll();
    }
}
