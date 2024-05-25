package Daily_code_buffer.Spring_BootLearning.reprository;

import Daily_code_buffer.Spring_BootLearning.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends  JpaRepository<Department, Long> {


    /*Fetching data by property Name*/
    public Department findByDepartmentName(String departmentname);

    /*Fetching data by Property Name Ignore Case */
    public Department findByDepartmentNameIgnoreCase(String departmentname);
}
