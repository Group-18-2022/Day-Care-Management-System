package za.ac.cput.controller.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.lookup.GroupRoomAPI;
import za.ac.cput.domain.lookup.GroupRoom;
import za.ac.cput.factory.lookup.GroupRoomFactory;
import za.ac.cput.service.lookup.Impl.GroupRoomServiceImpl;

import javax.validation.Valid;
import java.util.List;

    @RestController
    @RequestMapping("api/v1/day-care/group-room/")
    public class GroupRoomController
    {

        private final GroupRoomServiceImpl groupRoomService;
        private final GroupRoomAPI groupRoomAPI;

        @Autowired
        public GroupRoomController(GroupRoomServiceImpl groupRoomService, GroupRoomAPI groupRoomAPI) {
            this.groupRoomService = groupRoomService;

            this.groupRoomAPI = groupRoomAPI;
        }

        @PostMapping("save")
        public ResponseEntity<GroupRoom> save(@Valid @RequestBody GroupRoom groupRoom) {
            GroupRoom groupRoom1 = GroupRoomFactory.build(groupRoom.getClassRoomId(), groupRoom.getClassGroupId());
            GroupRoom saved = this.groupRoomAPI.save(groupRoom1);
            return ResponseEntity.ok(saved);
        }

        @GetMapping("read/{id}")
        public ResponseEntity<GroupRoom> read(@PathVariable String id) {
            GroupRoom groupRoom =  this.groupRoomService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Classroom Not Found"));
            return  ResponseEntity.ok(groupRoom);
        }

        @GetMapping("readBy/{roomID}/{groupID}")
        public ResponseEntity<GroupRoom> readById(@PathVariable String roomID, @PathVariable String groupID) {
            GroupRoom groupRoom =  this.groupRoomService.readById(roomID, groupID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Classroom Not Found"));
            return  ResponseEntity.ok(groupRoom);
        }


        @DeleteMapping("deleteBy/{roomId}/{groupId}")
        public ResponseEntity<Void> deleteById(@PathVariable String roomId, @PathVariable String groupId) {
            this.groupRoomService.deleteById(roomId, groupId);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("all")
        public ResponseEntity<List<GroupRoom>> findAll() {
            List<GroupRoom> list = this.groupRoomService.findAll();
            return ResponseEntity.ok(list);
        }


    }

