package br.com.employeeRegistration.controller;

import br.com.employeeRegistration.dto.SectorDTO;
import br.com.employeeRegistration.service.impl.SectorServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class SectorController {

    @Autowired
    private SectorServiceimpl sectorService;

    @PostMapping(value = "inclusion-sector", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<SectorDTO>> includeSector(
            @RequestHeader(value = "nameSector") String nameSector){

        sectorService.inclusionSector(nameSector);

        return new ResponseEntity<Response<SectorDTO>>(HttpStatus.OK);
    }

    @DeleteMapping(value = "delete-sector", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Void>> deleteSector(
            @RequestHeader(value = "nameSector") String nameSector,
            @RequestHeader(value = "id") Integer id){

        sectorService.sectorDelete(id,nameSector);

        return new ResponseEntity<Response<Void>>(HttpStatus.OK);
    }

    @PutMapping(value = "update-sector", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<SectorDTO>> updateSector(
            @RequestHeader(value = "nameSector") String nameSector,
            @RequestHeader(value = "id") Integer id){

        sectorService.updateSector(id,nameSector);

        return new ResponseEntity<Response<SectorDTO>>(HttpStatus.OK);
    }

}
