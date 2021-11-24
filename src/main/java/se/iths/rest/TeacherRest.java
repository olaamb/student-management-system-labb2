package se.iths.rest;


import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("createteacher")
    @POST
    public Response createTeacher(Teacher teacher) {
        try {
            teacherService.createTeacher(teacher);
            return Response.ok(teacher).build();
        } catch (WebApplicationException w) {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Path("getall")
    @GET
    public Response getAllTeachers() {
        String responseIfEmpty = "{\"Error\": \"No teacher in list.\"}";
        List<Teacher> foundTeachers = teacherService.getAllTeachers();
        if (foundTeachers == null || foundTeachers.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(responseIfEmpty).type(MediaType.APPLICATION_JSON).build());
        }
        return Response.ok(foundTeachers).build();
    }

}
