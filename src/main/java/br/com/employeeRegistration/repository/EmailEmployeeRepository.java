package br.com.employeeRegistration.repository;

import br.com.employeeRegistration.entity.EmailEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailEmployeeRepository extends JpaRepository<EmailEmployeeEntity,Integer> {
}
