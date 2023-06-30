//package com.epay.service.usermanagement.entitys;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "tbl_function_type")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class FunctionType {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name", nullable = false, unique = true)
//    private String name;
//
//    @Column(name = "description", nullable = false, unique = true)
//    private String description;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "functionType")
//    private List<Permission> permissions;
//}
