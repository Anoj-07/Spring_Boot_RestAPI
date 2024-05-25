package Daily_code_buffer.Spring_BootLearning.service;

import Daily_code_buffer.Spring_BootLearning.entity.Department;
import Daily_code_buffer.Spring_BootLearning.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    /*POST -> creating new data*/
    public Department saveDepartment(Department department);

    /*GET -> fetching*/
    public List<Department> fetchDepartmentList();

    /*GET -> fetching data by id
    * add Exception handling
    * method signature is content after throw keyword */
    public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException;


    /*DELETING -> (DELETE)*/
    public void deleteDepartmentById(Long departmentId);

    /*Updating -> (PUT)*/
    Department UpdateDepartment(Long departmentId, Department department);

    /*fetching data by property name (GET)*/
    public Department fetchDepartmentByName(String departmentName);
}
