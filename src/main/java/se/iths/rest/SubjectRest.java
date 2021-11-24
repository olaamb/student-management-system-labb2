package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;


    @Path("")
    @POST
    public Response createSubject(Subject subject) {
        try {
            subjectService.createSubject(subject);
            return Response.ok(subject).build();
        } catch (WebApplicationException w) {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Path("getall")
    @GET
    public Response getAllSubjects() {
        String responseIfEmpty = "{\"Error\": \"No subjects in list.\"}";
        List<Subject> foundSubjects = subjectService.getAllSubjects();
        if (foundSubjects == null || foundSubjects.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(responseIfEmpty).type(MediaType.APPLICATION_JSON).build());
        }
        return Response.ok(foundSubjects).build();
    }

    @Path("query")
    @GET
    public Response getAllStudentsInSubject(@QueryParam("subjectname") String subjectname) {
        String responseIfEmpty = "{\"Error\": \"No student with that last name was found.\"}";
        List<Subject> foundSubjects = subjectService.getSubjectBySubjectName(subjectname);
        if (foundSubjects == null || foundSubjects.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(responseIfEmpty).type(MediaType.APPLICATION_JSON).build());
        }
        return Response.ok(foundSubjects).build();
    }
}
