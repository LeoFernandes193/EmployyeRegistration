package br.com.employeeRegistration.service;

import br.com.employeeRegistration.dto.EmployeeDTO;
import br.com.employeeRegistration.entity.EmployeeRegistrationEntity;

public interface EmployeeService {

    /**
     * Method for adding a new employee to the TB_EMPLOYEE_REGISTRATION table
     * @author Leonardo Fernandes
     * @param dto
     * @return
     */
    EmployeeDTO employeeInclusion(EmployeeDTO dto);

    /**
     * Method for listing existing employees in the TB_EMPLOYYE_REGISTRATION table by id and name.
     * @author Leonardo Fernandes
     * @param id
     * @param nomeEmployee
     * @return
     */
    Boolean employeeConsultation(Integer id, String nomeEmployee);


    /**
     * Method to convert DTO to Entity.
     * @author Leonardo Fernandes.
     * @param dto
     * @return
     */
    EmployeeRegistrationEntity convetToEntity(EmployeeDTO dto);


}
