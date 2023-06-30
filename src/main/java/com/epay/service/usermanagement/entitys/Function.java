package com.epay.service.usermanagement.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_function")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "function_name", nullable = false)
    private String functionName;

    @Column(name = "api", nullable = false)
    private String api;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "tbl_functions_permissions",
            joinColumns = @JoinColumn(name = "function_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    @JsonIgnore
    private Set<Permission> permissions = new HashSet<>();

    @Override
    public String toString() {
        return "Function{" +
                "id=" + id +
                ", functionName='" + functionName + '\'' +
                ", permission=" + permissions +
                '}';
    }

}
