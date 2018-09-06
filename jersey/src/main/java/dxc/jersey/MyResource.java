package dxc.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dxc.jersey.Employee;
import dxc.jersey.Employeeservice;

import java.util.ArrayList;


import javax.ws.rs.Consumes;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() { Employeeservice.init();
        return "Got it!";
    }

    
    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String add(Employee input)
    {
    	Employeeservice.addEmp(input);
    	return "{\"status\":\"0\",\"message\":\"Successfuly added\"}";
    	
    }
    
    
    @GET
    @Path("getAllEmp")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Employee> getAllEmp()
    {
    	
    	return Employeeservice.getAllEmployee();
    	
    }
    
    
    @GET
    @Path("getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmpById(@PathParam("empid") String empid)
    {
    	
    	Employee e=Employeeservice.getEmployeeById(empid);
    	return e;
  }
    
    
    @GET
    @Path("getByDept/{dept}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Employee>  getEmpByDept(@PathParam("dept") String dept)
    {
    	
    	ArrayList<Employee> dep=new ArrayList<Employee>();
    	dep.addAll(Employeeservice.getEmpByDept(dept));
    	return dep;
  }
    
    @GET
    @Path("getByMaxSal")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmpByMaxSal()
    {
    
    	Employee e=Employeeservice.getEmpByMaxSal();
    	return e;
    }
    @PUT
    @Path("update/{rollno}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(@PathParam("rollno") String rollno,Employee input)
    {
    	Employee updated=Employeeservice.update(rollno,input);
    	if(updated==null)
    		return "{\"status\":\"1\",\"message\":\"No such student found\"}";
    	else
    		return "{\"status\":\"0\",\"message\":\"Updated successfully\"}";
    }
    
}

    
 
