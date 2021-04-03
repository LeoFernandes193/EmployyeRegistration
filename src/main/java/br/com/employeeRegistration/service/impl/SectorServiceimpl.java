package br.com.employeeRegistration.service.impl;

import br.com.employeeRegistration.dto.SectorDTO;
import br.com.employeeRegistration.entity.SectorEntity;
import br.com.employeeRegistration.exception.BussinesException;
import br.com.employeeRegistration.repository.SectorEntityRepository;
import br.com.employeeRegistration.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SectorServiceimpl implements SectorService {

    @Autowired
    private SectorEntityRepository sectorEntityRepository;

    /**
     * Method for adding a new sector to the TB_SECTOR table.
     *
     * @param nameSector
     * @return
     * @author Leonardo Fernandes
     */
    @Override
    public SectorDTO inclusionSector(String nameSector) {
        Optional.ofNullable(nameSector).orElseThrow(()-> new NullPointerException("NameSector cannot be null"));

        String name = nameSector.toLowerCase();

        if (!sectorConsultation(name)){
           SectorEntity entity = sectorEntityRepository.save(convertToEntity(SectorDTO.builder()
                    .nameSector(name)
                    .dateInsert(new Date())
                    .build()));

            return SectorDTO.builder()
                    .id(entity.getIdSector())
                    .nameSector(entity.getNameSector())
                    .dateInsert(entity.getDateInsert())
                    .includ(Boolean.TRUE)
                    .build();
        }
        throw new BussinesException("Existing sector");
    }

    /**
     * Methods to query the existence of a sector in the TB_SECTOR table.
     *
     * @param nameSector
     * @return
     * @author Leonardo Fernandes
     */
    @Override
    public Boolean sectorConsultation(String nameSector) {
        Optional.ofNullable(nameSector).orElseThrow(()-> new NullPointerException("NameSector cannot be null"));

        String name = nameSector.toUpperCase();

        List<SectorEntity> list = sectorEntityRepository.findAll();

        for (SectorEntity entity : list){
            if (name.equals(entity.getNameSector())){
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }

        return Boolean.FALSE;
    }

    /**
     * Method for updating sector in the TB_SECTOR table.
     *
     * @param id
     * @param nameSector
     * @return
     */
    @Override
    public SectorDTO updateSector(Integer id, String nameSector) {
        Optional.ofNullable(nameSector).orElseThrow(()-> new NullPointerException("NameSector cannot be null"));
        Optional.ofNullable(id).orElseThrow(()-> new NullPointerException("ID cannot be null"));

        String name = nameSector.toUpperCase();

        SectorDTO dto = SectorDTO.builder()
                .id(id)
                .nameSector(name)
                .dateInsert(new Date())
                .build();

        List<SectorEntity> list = sectorEntityRepository.findAll();

        for (SectorEntity entity : list){
            if (sectorConsultation(nameSector)){
                sectorEntityRepository.save(convertToEntity(dto));
            } else {
                throw new BussinesException("Sector not updated");
            }
        }

        return dto;
    }

    /**
     * Method for updating sector in the TB_SECTOR table
     *
     * @param id
     * @param nameSector
     * @author Leonardo Fernandes
     */
    @Override
    public void sectorDelete(Integer id, String nameSector) {
        Optional.ofNullable(nameSector).orElseThrow(()-> new NullPointerException("NameSector cannot be null"));
        Optional.ofNullable(id).orElseThrow(()-> new NullPointerException("ID cannot be null"));

        String name = nameSector.toUpperCase();

        List<SectorEntity> list = sectorEntityRepository.findAll();

        for (SectorEntity entity : list){
            if (sectorConsultation(name)){
                sectorEntityRepository.deleteByIdSectorAndNameSector(id,nameSector);
            } else {
                throw new BussinesException("Sector does not exist");
            }
        }

    }

    /**
     * Method to convert DTO to Entity.
     *
     * @param dto
     * @return
     * @author Leonardo Fernandes
     */
    @Override
    public SectorEntity convertToEntity(SectorDTO dto) {
        SectorEntity entity = new SectorEntity();

        entity.setNameSector(dto.getNameSector());
        entity.setDateInsert(new Date());

        return entity;
    }
}
