package se.iths.rest;


import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createStudent(Student student) {
        try {
            studentService.createStudent(student);
            return Response.ok(student).build();
        } catch (WebApplicationException w) {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Path("getall")
    @GET
    public Response getAllStudents() {
        String responseIfEmpty = "{\"Error\": \"No students in list.\"}";
            List<Student> foundStudents = studentService.getAllStudents();
            if (foundStudents == null || foundStudents.isEmpty()) {
                throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(responseIfEmpty).type(MediaType.APPLICATION_JSON).build());
            }
            return Response.ok(foundStudents).build();
    }

    @Path("query")
    @GET
    public Response getStudentByLastName(@QueryParam("lastname") String lastname) {
        String responseIfEmpty = "{\"Error\": \"No student with that last name was found.\"}";
            List<Student> foundStudents = studentService.getStudentByLastname(lastname);
            if (foundStudents == null || foundStudents.isEmpty()) {
                throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(responseIfEmpty).type(MediaType.APPLICATION_JSON).build());
            }
            return Response.ok(foundStudents).build();
    }

    @Path("")
    @PUT
    public Response updateStudent(Student student) {
        try {
            studentService.updateStudent(student);
            return Response.ok().build();
        } catch (WebApplicationException w) {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Path("{id}")
    @PATCH
    public Response updateLastName(@PathParam("id") Long id, @QueryParam("lastname") String lastname) {
        try {
            Student updatedStudent = studentService.updateStudentLastName(id, lastname);
            return Response.ok(updatedStudent).build();
        } catch (WebApplicationException w) {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        try {
            studentService.deleteStudent(id);
            return Response.ok().build();
        } catch (WebApplicationException w) {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
        }
    }
}
