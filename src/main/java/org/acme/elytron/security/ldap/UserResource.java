package org.acme.elytron.security.ldap;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;


    @Path("/api")
    public class UserResource {

    @GET
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String publicResource() {
        return "public";
   }

    @GET
    @RolesAllowed("adminRole")
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/admin")
    public String adminResource() {
         return "admin";
    }

    @GET
    @RolesAllowed("standardRole")
    @Path("/me")
    public String me(@Context SecurityContext securityContext) {
        return securityContext.getUserPrincipal().getName();
    }
}