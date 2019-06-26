package com.axelor.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import org.apache.http.HttpException;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import com.axelor.service.Service;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Path("/")
@Singleton
public class Controller{
  
  public Service service;
  
  public Controller() {
  }
  
  @Inject
  public Controller(Service service){  
      this.service=service;
  }      
  
  @POST
  @Path("/insert")
  public void insert(@FormParam("sname") String sname,@FormParam("percentage") String percentage,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException {
             service.add(sname, percentage);
             res.getWriter().print("successfull");
  };
}