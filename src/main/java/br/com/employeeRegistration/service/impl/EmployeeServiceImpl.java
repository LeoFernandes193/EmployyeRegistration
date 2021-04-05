package br.com.employeeRegistration.service.impl;

import br.com.employeeRegistration.dto.EmployeeDTO;
import br.com.employeeRegistration.entity.*;
import br.com.employeeRegistration.exception.BussinesException;
import br.com.employeeRegistration.repository.EmployeeRegistrationRepository;
import br.com.employeeRegistration.repository.SectorEntityRepository;
import br.com.employeeRegistration.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRegistrationRepository employeeRegistrationRepository;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private PhoneServiceImpl phoneService;

    @Autowired
    private SectorEmployeeServiceImpl employeeService;

    @Autowired
    private SectorServiceimpl sectorService;

    @Autowired
    private SectorEmployeeServiceImpl sectorEmployeeService;

    @Autowired
    private SectorEntityRepository sectorEntityRepository;


    /**
     * Method for adding a new employee to the TB_EMPLOYEE_REGISTRATION table
     *
     * @param dto
     * @return
     * @author Leonardo Fernandes
     */
    @Override
    public EmployeeDTO employeeInclusion(EmployeeDTO dto) {
        Optional.ofNullable(dto).orElseThrow(()-> new NullPointerException("DTO cannot be null"));
        Optional.ofNullable(dto.getName()).orElseThrow(()-> new NullPointerException("Name cannot be null"));
        Optional.ofNullable(dto.getCpf()).orElseThrow(()-> new NullPointerException("CPF cannot be null"));
//        Optional.ofNullable(dto.getDateBirth()).orElseThrow(()-> new NullPointerException("DateBirth cannot be null"));
        Optional.ofNullable(dto.getEmail()).orElseThrow(()-> new NullPointerException("Email cannot be null"));
        Optional.ofNullable(dto.getPhone()).orElseThrow(()-> new NullPointerException("Phone cannot be null"));
        Optional.ofNullable(dto.getSector()).orElseThrow(()-> new NullPointerException("Sector cannot be null"));

        if (sectorService.sectorConsultation(dto.getSector())){

            List<SectorEntity> entitySector = sectorEntityRepository.findAll();

            for (SectorEntity table : entitySector){
                if (table.getNameSector().equals(dto.getSector().toUpperCase())){

                    EmployeeRegistrationEntity entity = employeeRegistrationRepository.save(convetToEntity(dto));
                    EmailEmployeeEntity email = emailService.inclusionEmail(dto.getEmail(),entity);
                    PhoneEmployeeEntity phone = phoneService.inclusionPhone(dto.getPhone(), entity);
                    SectorEmployeeEntity sectorEmoloyee = sectorEmployeeService.insertSectorEmployee(table,entity);

                    EmployeeDTO entityDTO = EmployeeDTO.builder()
                            .id(entity.getIdEmployee())
                            .name(entity.getNameEmployee())
                            .cpf(entity.getRegistrationPhysicalPerson())
                            .email(email.getEmailAndress())
                            .phone(phone.getPhoneEmployee())
                            .sector(dto.getSector())
                            .build();


                    return entityDTO ;

                }
            }
        }

        throw new BussinesException("Employee not included");

    }

    /**
     * Method for listing existing employees in the TB_EMPLOYYE_REGISTRATION table by id and name.
     *
     * @param id
     * @param nomeEmployee
     * @return
     * @author Leonardo Fernandes
     */
    @Override
    public Boolean employeeConsultation(Integer id, String nomeEmployee) {
        return null;
    }

    /**
     * Method to convert DTO to Entity.
     *
     * @param dto
     * @return
     * @author Leonardo Fernandes.
     */
    @Override
    public EmployeeRegistrationEntity convetToEntity(EmployeeDTO dto) {
        EmployeeRegistrationEntity entity = new EmployeeRegistrationEntity();

        entity.setNameEmployee(dto.getName());
        entity.setRegistrationPhysicalPerson(dto.getCpf());
        entity.setDateInsert(new Date());
        return entity;
    }
}
