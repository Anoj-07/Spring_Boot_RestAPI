package Daily_code_buffer.Spring_BootLearning.service;

import Daily_code_buffer.Spring_BootLearning.entity.Department;
import Daily_code_buffer.Spring_BootLearning.error.DepartmentNotFoundException;
import Daily_code_buffer.Spring_BootLearning.reprository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    /*from mockito*/
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() throws DepartmentNotFoundException {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Nepal")
                        .departmentCode("IT-o6")
                        .departmentId(1L)
                        .build();

        /*Calling mockito*/
        Mockito.when(departmentRepository.findByDepartmentName("IT"))
                .thenReturn(department);

      /*  Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);*/

    }


    @Test
    @DisplayName("Get Data based on valid Department Name")
    /*testing for this one =>  public Department fetchDepartmentByName(String departmentName);*/
    public void when_valid_department_name_then_department_should_found(){
        String department_name = "IT";
        Department found =
                departmentService.fetchDepartmentByName(department_name);
        assertEquals(department_name, found.getDepartmentName());
    }

}