package br.com.employeeRegistration.service;

import br.com.employeeRegistration.entity.EmployeeRegistrationEntity;
import br.com.employeeRegistration.entity.PhoneEmployeeEntity;

public interface PhoneService {

    /**
     * Method for adding a phone to the TB_PHONE_EMPLOYEE table
     * @param phone
     * @param entity
     * @return
     */
    PhoneEmployeeEntity inclusionPhone(String phone, EmployeeRegistrationEntity entity);

    /**
     * Methods to convert into an entity
     * @author Leonardo Fernandes
     * @param phone
     * @param entity
     * @return
     */
    PhoneEmployeeEntity converToEntity(String phone, EmployeeRegistrationEntity entity);
}
