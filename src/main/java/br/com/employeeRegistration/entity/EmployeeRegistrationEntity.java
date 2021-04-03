package br.com.employeeRegistration.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_EMPLOYEE_REGISTRATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRegistrationEntity {

    @Id
    @Column(name = "ID_EMPLOYEE")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEmployee;

    @Column(name = "NAME_EMPLOYEE", length = 255)
    private String nameEmployee;

    @Column(name = "CPF", unique = true)
    private String registrationPhysicalPerson;

    @Column(name = "DATE_BIRTH")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBirth;

    @Column(name = "DATE_INSERT")
    private Date dateInsert;
}