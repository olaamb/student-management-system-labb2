package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ListEmptyException extends WebApplicationException {
    public ListEmptyException(String errorMessage){
        super(Response.status(Response.Status.OK).entity(errorMessage).type(MediaType.APPLICATION_JSON).build());
    }
}
