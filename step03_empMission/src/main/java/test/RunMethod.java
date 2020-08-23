package test;

import run.test.RunDepartmentCRUD;
import run.test.RunEmployeeCRUD;

public class RunMethod {
	public static RunEmployeeCRUD einstance = RunEmployeeCRUD.getInstance();
	public static RunDepartmentCRUD dinstance = RunDepartmentCRUD.getInstance();
	public static void main(String[] args) {
		//dinstance.createDepartment();
		//dinstance.updateDepartment();
		dinstance.findElement();
		//dinstance.deleteElement();
		//einstance.createEmployee(); 
		//einstance.updateEmployee();
		//einstance.findElement();
		//einstance.deleteElement();
	}
}
