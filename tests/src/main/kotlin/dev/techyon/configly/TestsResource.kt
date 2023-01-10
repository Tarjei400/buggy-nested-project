package dev.techyon.configly

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.spi.CDI
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@ApplicationScoped
@Path("/hello")
class TestsResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  fun hello2(): String {
    return "ASDASD";
  }
}
