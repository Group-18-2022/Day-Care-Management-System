package za.ac.cput.controller.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.domain.lookup.GroupRoom;
import za.ac.cput.factory.entity.ClassRoomFactory;
import za.ac.cput.factory.lookup.GroupRoomFactory;
import za.ac.cput.service.entity.impl.ClassRoomServiceImpl;
import za.ac.cput.service.lookup.Impl.GroupRoomServiceImpl;

import javax.validation.Valid;
import java.util.List;

    @RestController
    @RequestMapping("api/v1/day-care/group-room/")
    public class GroupRoomController
    {

        private final GroupRoomServiceImpl groupRoomService;

        @Autowired
        public GroupRoomController(GroupRoomServiceImpl groupRoom) {
            this.groupRoomService = groupRoom;
        }

        @PostMapping("save")
        public ResponseEntity<GroupRoom> save(@Valid @RequestBody GroupRoom groupRoom) {
            GroupRoom groupRoom1 = GroupRoomFactory.build(groupRoom.getClassRoomId(), groupRoom.getClassGroupId());
            GroupRoom saved = groupRoomService.save(groupRoom1);
            return ResponseEntity.ok(saved);
        }

        @GetMapping("read/{id}")
        public ResponseEntity<GroupRoom> read(@PathVariable String id) {
            GroupRoom groupRoom =  this.groupRoomService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Classroom Not Found"));
            return  ResponseEntity.ok(groupRoom);
        }

        @DeleteMapping("delete")
        public ResponseEntity<Void> delete(GroupRoom groupRoom) {
            this.groupRoomService.delete(groupRoom);
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("delete/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable String id) {
            this.groupRoomService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("all")
        public ResponseEntity<List<GroupRoom>> findAll() {
            List<GroupRoom> list = this.groupRoomService.findAll();
            return ResponseEntity.ok(list);
        }


    }

