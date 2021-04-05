package br.com.employeeRegistration.service;

import br.com.employeeRegistration.entity.EmployeeRegistrationEntity;
import br.com.employeeRegistration.entity.SectorEmployeeEntity;
import br.com.employeeRegistration.entity.SectorEntity;

public interface SectorEmployeeService {

    /**
     * Method to insert sector and employee relationship in the TB_SECTOR_EMPLOYEE table.
     * @author Leonardo Fernandes
     * @param sector
     * @param employee
     * @return
     */
    SectorEmployeeEntity insertSectorEmployee(SectorEntity sector, EmployeeRegistrationEntity employee);

    /**
     * Methods to convert into an entity
     * @author Leonardo Fernandes
     * @param sector
     * @param employee
     * @return
     */
    SectorEmployeeEntity convetToEntity(SectorEntity sector, EmployeeRegistrationEntity employee);
}
