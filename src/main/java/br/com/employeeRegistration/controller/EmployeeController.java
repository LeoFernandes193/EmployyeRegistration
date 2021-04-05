package br.com.employeeRegistration.controller;

import br.com.employeeRegistration.dto.EmployeeDTO;
import br.com.employeeRegistration.dto.SectorDTO;
import br.com.employeeRegistration.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping(value = "employee-inclusion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<EmployeeDTO>> employeeInclusion(
            @RequestHeader(value = "name") String name,
            @RequestHeader(value = "cpf") String cpf,
            @RequestHeader(value = "email") String email,
            @RequestHeader(value = "phone") String phone){

        EmployeeDTO dto = EmployeeDTO.builder()
                .name(name)
                .cpf(cpf)
                .email(email)
                .phone(phone)
//                .sector(sectorDTO)
                .build();

        employeeService.employeeInclusion(dto);

        return new ResponseEntity<Response<EmployeeDTO>>(HttpStatus.OK);
    }
}
