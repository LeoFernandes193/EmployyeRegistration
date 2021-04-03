package br.com.employeeRegistration.repository;

import br.com.employeeRegistration.entity.PhoneEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneEmployeeRepository extends JpaRepository<PhoneEmployeeEntity,Integer> {
}
