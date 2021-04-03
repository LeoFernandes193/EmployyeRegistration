package br.com.employeeRegistration.repository;

import br.com.employeeRegistration.entity.EmployeeRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRegistrationRepository extends JpaRepository<EmployeeRegistrationEntity,Integer> {

}
