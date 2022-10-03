package za.ac.cput.api.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.domain.lookup.GroupRoom;
import za.ac.cput.service.entity.impl.ClassRoomServiceImpl;
import za.ac.cput.service.lookup.Impl.ClassGroupServiceImpl;
import za.ac.cput.service.lookup.Impl.GroupRoomServiceImpl;

@Component
public class GroupRoomAPI //Example of Facade pattern
{
    private GroupRoomServiceImpl groupRoomService;
    private ClassGroupServiceImpl classGroupService;
    private ClassRoomServiceImpl classRoomService;

    @Autowired
    public GroupRoomAPI(GroupRoomServiceImpl groupRoomService, ClassGroupServiceImpl classGroupService, ClassRoomServiceImpl classRoomService) {
        this.groupRoomService = groupRoomService;
        this.classGroupService = classGroupService;
        this.classRoomService = classRoomService;
    }

    public GroupRoom save(GroupRoom gr)
    {
        this.classRoomService.read(gr.getClassRoomId()).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Classroom Not Found"));
        this.classGroupService.read(gr.getClassGroupId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group Not Found"));
        return this.groupRoomService.save(gr);
    }

}
