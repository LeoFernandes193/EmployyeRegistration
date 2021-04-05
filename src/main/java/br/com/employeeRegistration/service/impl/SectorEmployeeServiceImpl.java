package br.com.employeeRegistration.service.impl;

import br.com.employeeRegistration.entity.EmployeeRegistrationEntity;
import br.com.employeeRegistration.entity.SectorEmployeeEntity;
import br.com.employeeRegistration.entity.SectorEntity;
import br.com.employeeRegistration.repository.SectorEmployeeRepository;
import br.com.employeeRegistration.service.SectorEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectorEmployeeServiceImpl implements SectorEmployeeService {

    @Autowired
    private SectorEmployeeRepository sectorEmployeeRepository;

    /**
     * Method to insert sector and employee relationship in the TB_SECTOR_EMPLOYEE table.
     *
     * @param sector
     * @param employee
     * @return entity
     * @author Leonardo Fernandes
     */
    @Override
    public SectorEmployeeEntity insertSectorEmployee(SectorEntity sector, EmployeeRegistrationEntity employee) {
        Optional.ofNullable(sector).orElseThrow(()-> new NullPointerException("Sector cannot be null"));
        Optional.ofNullable(employee).orElseThrow(()-> new NullPointerException("Employee cannot be null"));

        SectorEmployeeEntity entity = sectorEmployeeRepository.save(convetToEntity(sector,employee));

        return entity;
    }

    /**
     * Methods to convert into an entity
     *
     * @param sector
     * @param employee
     * @return entity
     * @author Leonardo Fernandes
     */
    @Override
    public SectorEmployeeEntity convetToEntity(SectorEntity sector, EmployeeRegistrationEntity employee) {
        SectorEmployeeEntity entity = new SectorEmployeeEntity();

        entity.setIdSector(sector);
        entity.setIdEmployee(employee);

        return entity;
    }
}
