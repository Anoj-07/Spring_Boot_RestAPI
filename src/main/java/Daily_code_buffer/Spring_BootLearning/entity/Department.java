package Daily_code_buffer.Spring_BootLearning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // to for @ToString, @getter, @setter, @requiredArgsConstructor, @EqualAndHashCode
@NoArgsConstructor //default Constructor
@AllArgsConstructor // for all argument constructor
@Builder
public class Department {

    /*Use private access modifier to declare data Type */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;

    /*@NotBlank annotation is for validation (Hibernate Validation)
    * there are more you can use as your need*/
    @NotBlank(message = "Please Add Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    /*Lombok => library Implementation*/











    /*Getter and Setter method */
   /* public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }



    *//* Constructor for all data type*//*
    public Department(long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    *//* Default Constructor *//*
    public Department() {
    }


    *//*To string method for all data type*//*

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }*/



}
