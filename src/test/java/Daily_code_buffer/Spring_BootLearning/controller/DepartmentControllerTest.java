package Daily_code_buffer.Spring_BootLearning.controller;

import Daily_code_buffer.Spring_BootLearning.entity.Department;
import Daily_code_buffer.Spring_BootLearning.error.DepartmentNotFoundException;
import Daily_code_buffer.Spring_BootLearning.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() { //Output
        department = Department.builder()
                .departmentAddress("achham")
                .departmentCode("CSE-06")
                .departmentName("CSE")
                .departmentId(1L)
                .build();

    }

    @Test
    void saveDepartment() throws Exception {
        Department Input_department = Department.builder()
                .departmentAddress("Bangalore")
                .departmentCode("MBA-06")
                .departmentName("MBA")
                .build();

        Mockito.when(departmentService.saveDepartment(Input_department))
                .thenReturn(department);

       /* mvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentAddress\":\"Bangalore\",\n" +
                        "    \"departmentCode\":\"MBA-06\",\n" +
                        "    \"departmentName\":\"MBA\"\n" +
                        "    \n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());*/

        //post Operation test
        mvc.perform(post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"departmentAddress\":\"Bangalore\",\n" +
                                "    \"departmentCode\":\"MBA-06\",\n" +
                                "    \"departmentName\":\"MBA\"\n" +
                                "    \n" +
                                "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentByID(1L))
                .thenReturn(department);

        //get Operation Test
        mvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));

    }
}