package br.com.employeeRegistration.repository;

import br.com.employeeRegistration.entity.EmailEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailEmployeeRepository extends JpaRepository<EmailEmployeeEntity,Integer> {
}
