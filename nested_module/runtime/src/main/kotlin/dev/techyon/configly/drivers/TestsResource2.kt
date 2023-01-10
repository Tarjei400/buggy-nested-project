package dev.techyon.configly.drivers

import jakarta.enterprise.context.ApplicationScoped
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import java.io.IOException


@ApplicationScoped
@Path("/hello")
class TestsResource2 {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  fun hello2(): String {
    return "ASDASD";
  }
}


@WebServlet
class TestsResource2Servlet : HttpServlet() {
  @Throws(IOException::class)
  override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    resp.writer.write("Hello")
  }
}