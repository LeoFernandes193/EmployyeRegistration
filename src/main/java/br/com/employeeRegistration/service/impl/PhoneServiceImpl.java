package br.com.employeeRegistration.service.impl;

import br.com.employeeRegistration.entity.EmployeeRegistrationEntity;
import br.com.employeeRegistration.entity.PhoneEmployeeEntity;
import br.com.employeeRegistration.repository.PhoneEmployeeRepository;
import br.com.employeeRegistration.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneEmployeeRepository phoneEmployeeRepository;

    /**
     * Method for adding a phone to the TB_PHONE_EMPLOYEE table
     *
     * @param phone
     * @param entity
     * @return
     */
    @Override
    public PhoneEmployeeEntity inclusionPhone(String phone, EmployeeRegistrationEntity entity) {
        Optional.ofNullable(phone).orElseThrow(()-> new NullPointerException("Phone cannot be null"));
        Optional.ofNullable(entity).orElseThrow(()-> new NullPointerException("EntityEmployee cannot be null"));

        PhoneEmployeeEntity phoneEmployeeEntity = phoneEmployeeRepository.save(converToEntity(phone,entity));

        return phoneEmployeeEntity;
    }

    /**
     * Methods to convert into an entity
     *
     * @param phone
     * @param entity
     * @return
     * @author Leonardo Fernandes
     */
    @Override
    public PhoneEmployeeEntity converToEntity(String phone, EmployeeRegistrationEntity entity) {
        PhoneEmployeeEntity table = new PhoneEmployeeEntity();

        table.setPhoneEmployee(phone);
        table.setEmployeeRegistrationEntity(entity);
        table.setDateInsert(new Date());

        return table;
    }
}
