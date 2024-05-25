package Daily_code_buffer.Spring_BootLearning.service;

import Daily_code_buffer.Spring_BootLearning.entity.Department;
import Daily_code_buffer.Spring_BootLearning.error.DepartmentNotFoundException;
import Daily_code_buffer.Spring_BootLearning.reprository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    /*Post mapping*/
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    /*Get mapping*/
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    /*Fetching data by ID
    * added Exception handling*/
    @Override
    public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);

        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }


    /*Deleting data form DB (DELETE)
    * this void type that why we are not returning any Thing */
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    /*Updating Data to DB (PUT)*/
    @Override
    public Department UpdateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();


        /*This is for null check and blank check*/

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    /*fetching data by property name (GET)*/

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
