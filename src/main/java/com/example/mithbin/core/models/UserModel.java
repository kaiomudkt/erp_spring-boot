package com.example.mithbin.core.models;

import com.example.mithbin.core.enums.PermissionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "TB_USERS")
//@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel extends RepresentationModel<UserModel> implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idProduct;
    private String name;
    private String email;

    private String login;
    private String password;

    private Date birthAt;

    private List<PermissionEnum> permissions;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private UserModel createdBy;

    @LastModifiedBy
    @ManyToOne
    @JoinColumn(name = "updated_by_id")
    private UserModel updatedBy;

    @ManyToOne
    @JoinColumn(name = "deleted_by_id")
    private UserModel deletedBy;

    private Date deletedAtDate;

    private Date createdAt;

    private Date updatedAt;

//    private TenantModel tenant;

    public UserModel(String login, String password, List<PermissionEnum> permissionEnum) {
        this.login = login;
        this.password = password;
        this.permissions = permissionEnum;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (PermissionEnum permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission.toString()));
            if (permission == PermissionEnum.ADMIN) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        }
        return authorities;
    }

     @Override
    public String getPassword() {
        return null;
    }

     @Override
    public String getUsername() {
        return login;
    }

     @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

     @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

     @Override
    public boolean isEnabled() {
        return true;
    }
}
