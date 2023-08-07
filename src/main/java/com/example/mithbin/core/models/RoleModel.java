package com.example.mithbin.core.models;

import com.example.mithbin.core.enums.PermissionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class RoleModel extends RepresentationModel<UserModel> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idProduct;


    private String label;

    private List<PermissionEnum> permissions;
}
