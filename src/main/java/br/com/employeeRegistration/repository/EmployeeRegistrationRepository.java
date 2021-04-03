package br.com.employeeRegistration.repository;

import br.com.employeeRegistration.entity.EmployeeRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRegistrationRepository extends JpaRepository<EmployeeRegistrationEntity,Integer> {

}
