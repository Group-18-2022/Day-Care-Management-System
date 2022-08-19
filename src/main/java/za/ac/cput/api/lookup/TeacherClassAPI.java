package za.ac.cput.api.lookup;

/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */
//Include Test case once ClassRoom Service Is Implemented

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.TeacherClass;
import za.ac.cput.service.lookup.Impl.TeacherClassServiceImpl;
import za.ac.cput.service.user.Impl.TeacherServiceImpl;

@Component
public class TeacherClassAPI {
    /*
    private final TeacherServiceImpl teacherService;
    private final ClassRoomServiceImpl classRoomService;
    private final TeacherClassServiceImpl teacherClassService;

    @Autowired
    public TeacherClassAPI(TeacherServiceImpl teacherService, ClassRoomServiceImpl classRoomService, TeacherClassServiceImpl teacherClassService) {
        this.teacherService = teacherService;
        this.classRoomService = classRoomService;
        this.teacherClassService = teacherClassService;
    }

    public TeacherClass save(TeacherClass teacherClass) {
        this.teacherService.read(teacherClass.getTeacherID())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher Not Found"));
        this.classRoomService.read(teacherClass.getClassRoomId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Classroom Not Found"));
        return this.teacherClassService.save(teacherClass);
    }
*/
}
