package br.com.employeeRegistration.repository;

import br.com.employeeRegistration.entity.SectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorEntityRepository extends JpaRepository<SectorEntity,Integer> {

    /**
     * Repository for sector exclusion in the TB_SECTOR table.
     * @author Leonardo Fernandes
     * @param id
     * @param nameSector
     */
    void deleteByIdSectorAndNameSector(Integer id, String nameSector);
}
