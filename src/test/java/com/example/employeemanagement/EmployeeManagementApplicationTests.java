package com.example.employeemanagement;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    // mock the dataBase
    @Mock
    EmployeeRepository employeeRepository;

    // call the class you wanna test
    @InjectMocks
    EmployeeServiceImpl employeeService;


    @Test
    public void testUpdateEmployee(){


        // create a mock type of the database
        Employee employee = new Employee("name", "email", "job", "phone", "img", "code");
        // when the employee.save(employess) is called, then return employee
        when(employeeRepository.save(employee)).thenReturn(employee);
        assertEquals(employeeService.updateEmployee(employee), employee);

    }

    @Test
    public void testGetEmployeeById(){

        Employee employee = new Employee("name", "email", "job", "phone", "img", "code");
        Long employeeId = 1L;
        when(employeeRepository.findEmployeeById(employeeId)).thenReturn(Optional.of(employee));
        assertEquals(employeeService.getEmployeeById(employeeId), employee);
    }

    @Test
    public void testDeleteEmployee(){

        Long id = 1L;
        employeeService = mock(EmployeeServiceImpl.class);
        doNothing().when(employeeService).deleteEmployeeById(any());
        employeeService.deleteEmployeeById(id);
        verify(employeeService, times(1)).deleteEmployeeById(id);
    }
}
