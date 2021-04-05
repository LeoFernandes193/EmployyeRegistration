package br.com.employeeRegistration.service;

import br.com.employeeRegistration.entity.EmailEmployeeEntity;
import br.com.employeeRegistration.entity.EmployeeRegistrationEntity;

public interface EmailService {

    /**
     * Method for adding a customer's email.
     * @author Leonardo Fernandes
     * @param email
     * @param entity
     * @return
     */
    EmailEmployeeEntity inclusionEmail(String email, EmployeeRegistrationEntity entity);

    /**
     * Method for updating a customer's email.
     * @param idCliente
     * @param email
     * @return
     */
    String emailUpdate(Integer idCliente, String email);

    /**
     * Method for deleting an email
     * @author Leonardo Fernandes
     * @param email
     */
    void emailDelete(String email);

    /**
     * Method for convert string in entity
     * @param email
     * @param entity
     * @return
     */
    EmailEmployeeEntity convertToEntity(String email, EmployeeRegistrationEntity entity);
}
