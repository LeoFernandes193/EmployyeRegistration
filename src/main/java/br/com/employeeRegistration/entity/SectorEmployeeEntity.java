package br.com.employeeRegistration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_SECTOR_EMPLOYEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectorEmployeeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID_SECTOR_EMPLOYEE")
    private Integer id;

    @JoinColumn(name = "ID_EMPLOYEE", referencedColumnName = "ID_EMPLOYEE")
    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeRegistrationEntity idEmployee;

    @JoinColumn(name = "ID_SECTOR",referencedColumnName = "ID_SECTOR")
    @OneToOne(cascade = CascadeType.ALL)
    private SectorEntity idSector;
}