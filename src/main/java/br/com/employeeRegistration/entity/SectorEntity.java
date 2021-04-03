package br.com.employeeRegistration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "TB_SECTOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectorEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID_SECTOR")
    private Integer idSector;

    @Column(name = "NAME_SECTOR", unique = true)
    private String nameSector;

    @Column(name = "DATE_INSERT")
    private Date dateInsert;
}
