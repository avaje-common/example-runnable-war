package example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoSlowServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private static final Logger log = LoggerFactory.getLogger(GoSlowServlet.class);
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    log.debug("go slow start...");
    
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      log.warn("error during go slow execute", e);
    }
    
    PrintWriter writer = resp.getWriter();
    writer.print("Go slow done - "+new Date());
    writer.flush();
    
    log.debug("go slow done");
  }

  
}
