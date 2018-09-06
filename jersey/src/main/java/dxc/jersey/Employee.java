package dxc.jersey;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



public class Employee implements Serializable {
	   
	String name;
	String empid;
    double salary;
	String dept; 

	public Employee ()
	{
		
	}
	
	public Employee(String name,String empid, double salary,String dept)
	{
		this.name=name;
		this.empid=empid;
		this.salary=salary;
		this.dept=dept;
	}

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getEmpid() {
		return empid;
	}
	@XmlElement
	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public double getSalary() {
		return salary;
	}
	@XmlElement
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}
	@XmlElement
	public void setDept(String dept) {
		this.dept = dept;
	}
	


}
