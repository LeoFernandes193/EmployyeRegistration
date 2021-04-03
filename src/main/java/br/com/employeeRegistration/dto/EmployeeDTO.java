package br.com.employeeRegistration.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
public class EmployeeDTO implements Serializable {

    /**
     * Object transfer class for the EmployeeService.
     * @auhotor Leonardo Fernandes.
     */

    private static final long  serialVersionUID = -3543210483740659153L;

    private Integer id;
    private String name;
    private String cpf;
    private Date dateBirth;
    private String email;
    private String phone;
    private String sector;
    private Date dataInsert;
    private Boolean includ;
}
