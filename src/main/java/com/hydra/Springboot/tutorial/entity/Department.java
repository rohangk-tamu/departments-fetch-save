package com.hydra.Springboot.tutorial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @TableGenerator(
            name = "departmentTableGenerator",
            allocationSize = 1,
            initialValue = 0)
    @Id
    @GeneratedValue(
            strategy=GenerationType.TABLE,
            generator="departmentTableGenerator")
    private Long departmentId;

    @NotBlank(message = "Please add a department name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
