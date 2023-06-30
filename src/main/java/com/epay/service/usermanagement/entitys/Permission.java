package com.epay.service.usermanagement.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permission_name", nullable = false)
    private String permissionName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Role role;

//    @ManyToOne
//    @JoinColumn(name = "function_type")
    private String functionType;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissions")
    private List<Function> functions = new ArrayList<>();

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", role=" + role +
                ", functions=" + functions +
                '}';
    }

}
