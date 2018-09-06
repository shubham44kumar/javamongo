package dxc.jersey;

import java.util.ArrayList;

import dxc.jersey.Employee;

public class Employeeservice {

	private static ArrayList<Employee> emp=new ArrayList<Employee>();
	
	public static void init() {
		// TODO Auto-generated constructor stub
		emp.add(new Employee("shubham","m44",99000,"manager"));
		emp.add(new Employee("ramesh","d14",45000,"developer"));
		emp.add(new Employee("lalan","t18",38500,"testing"));	
	}
	
	public static void addEmp(Employee e)
	{
		emp.add(e);
	}
	public static ArrayList<Employee> getAllEmployee()
	{
		return emp;
	}
	
	public static Employee getEmployeeById(String empid)
	{
		Employee found=null;
		int size=emp.size();
		for(int i=0;i<size;i++)
		{
			
			if(emp.get(i).getEmpid().equals(empid))
			{
				found=emp.get(i);
				break;
			}
		}
		return found;
	}
	public static ArrayList<Employee> getEmpByDept(String dept)
	{
		ArrayList<Employee> dep=new ArrayList<Employee>();

		int size=emp.size();
		for(int i=0;i<size;i++)
		{
			if(emp.get(i).getDept().equals(dept))
			{
				dep.add(emp.get(i));
				
			}
			
		}
		return dep;
	}
	
	public static Employee getEmpByMaxSal()
	{
		Employee found=null;
		int size=emp.size();
		double max=emp.get(0).getSalary();
		for(int i=0;i<size;i++)
		{
			
			if(emp.get(i).getSalary()>max)
			{
				max=emp.get(i).getSalary();
				//found=emp.get(i);
				break;
				
			}
			
		}
		for(int i=0;i<size;i++)
		{
			
			if(emp.get(i).getSalary()==max)
			{
				
				found=emp.get(i);
				break;
				
			}
			
		}
		return found;
}
	
	public static Employee replace(Employee old,Employee newStd)
	{
		int index=getIndexOf(old);
		if(index!=-1)
		{
			emp.set(index,newStd);
			return newStd;
		}
		else {
		 	return null;
		}		
	}
	
	private static int getIndexOf(Employee std)
	{
		int index=-1;
		int total=emp.size();
		for(int i=0;i<total;i++)
		{
			Employee current=(Employee)emp.get(i);
			if(current.getEmpid().equals(std.getEmpid()))
				{
				 index=i;
				 break;
				}
		}
		return index;
	}
	
	public static Employee update(String empid,Employee newStd)
	{
		Employee old=getEmployeeById(empid);
		newStd.setEmpid(empid);
		newStd=replace(old,newStd);
		return newStd;
	}
	}

