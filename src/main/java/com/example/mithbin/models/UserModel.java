package com.example.mithbin.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TB_USERS")
@EntityListeners(AuditingEntityListener.class)
public class UserModel extends RepresentationModel<UserModel> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idProduct;
    private String name;
    private String email;

    private String login;
    private String password;

    private Date birthAt;

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

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthAt() {
        return birthAt;
    }

    public void setBirthAt(Date birthAt) {
        this.birthAt = birthAt;
    }

    public UserModel getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
    }

    public UserModel getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserModel updatedBy) {
        this.updatedBy = updatedBy;
    }

    public UserModel getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(UserModel deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDeletedAtDate() {
        return deletedAtDate;
    }

    public void setDeletedAtDate(Date deletedAtDate) {
        this.deletedAtDate = deletedAtDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
