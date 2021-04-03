package br.com.employeeRegistration.service;

import br.com.employeeRegistration.dto.SectorDTO;
import br.com.employeeRegistration.entity.SectorEntity;

public interface SectorService {

    /**
     *  Method for adding a new sector to the TB_SECTOR table.
     * @author Leonardo Fernandes
     * @param nameSector
     * @return
     */
    SectorDTO inclusionSector (String nameSector);

    /**
     * Methods to query the existence of a sector in the TB_SECTOR table.
     * @author Leonardo Fernandes
     * @param nameSector
     * @return
     */
    Boolean sectorConsultation(String nameSector);

    /**
     * Method for updating sector in the TB_SECTOR table.
     * @param id
     * @param nameSector
     * @return
     */
    SectorDTO updateSector(Integer id, String nameSector);

    /**
     * Method for updating sector in the TB_SECTOR table
     * @author Leonardo Fernandes
     * @param id
     * @param nameSector
     */
    void sectorDelete(Integer id, String nameSector);

    /**
     * Method to convert DTO to Entity.
     * @author Leonardo Fernandes
     * @param dto
     * @return
     */
    SectorEntity convertToEntity(SectorDTO dto);
}
