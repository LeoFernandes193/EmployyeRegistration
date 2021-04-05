package br.com.employeeRegistration.service.impl;

import br.com.employeeRegistration.entity.EmailEmployeeEntity;
import br.com.employeeRegistration.entity.EmployeeRegistrationEntity;
import br.com.employeeRegistration.repository.EmailEmployeeRepository;
import br.com.employeeRegistration.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailEmployeeRepository emailEmployeeRepository;


    /**
     * Method for adding a customer's email.
     *
     * @param email
     * @param entity
     * @return
     * @author Leonardo Fernandes
     */
    @Override
    public EmailEmployeeEntity inclusionEmail(String email, EmployeeRegistrationEntity entity) {
        Optional.ofNullable(email).orElseThrow(()-> new NullPointerException("Email cannot be null"));
        Optional.ofNullable(entity).orElseThrow(()-> new NullPointerException("EmployeeService cannot be null"));

        String emailEmployee = email.toLowerCase();

        EmailEmployeeEntity table = emailEmployeeRepository.save(convertToEntity(emailEmployee,entity));

        return table;
    }

    /**
     * Method for updating a customer's email.
     *
     * @param idCliente
     * @param email
     * @return
     */
    @Override
    public String emailUpdate(Integer idCliente, String email) {
        return null;
    }

    /**
     * Method for deleting an email
     *
     * @param email
     * @author Leonardo Fernandes
     */
    @Override
    public void emailDelete(String email) {

    }

    /**
     * Method for convert string in entity
     *
     * @param email
     * @param entity
     * @return
     */
    @Override
    public EmailEmployeeEntity convertToEntity(String email, EmployeeRegistrationEntity entity) {
        EmailEmployeeEntity table = new EmailEmployeeEntity();

        table.setEmailAndress(email);
        table.setEmployeeRegistrationEntity(entity);
        table.setDateInsert(new Date());

        return table;
    }
}
