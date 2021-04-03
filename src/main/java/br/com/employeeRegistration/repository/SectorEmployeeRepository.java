package br.com.employeeRegistration.repository;

import br.com.employeeRegistration.entity.SectorEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorEmployeeRepository extends JpaRepository<SectorEmployeeEntity,Integer> {
}
