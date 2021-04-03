package br.com.employeeRegistration.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
public class SectorDTO implements Serializable {

    /**
     * Object transfer class for the SectorService.
     * @author Leonardo Fernandes
     */

    private static final long serialVersionUID = -7171271977258214370L;

    private Integer id;
    private String nameSector;
    private Date dateInsert;
    private Boolean includ;
}
