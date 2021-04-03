package br.com.employeeRegistration.repository;

import br.com.employeeRegistration.entity.SectorEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorEmployeeRepository extends JpaRepository<SectorEmployeeEntity,Integer> {
}
