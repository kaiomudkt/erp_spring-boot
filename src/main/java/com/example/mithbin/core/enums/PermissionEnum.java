package com.example.mithbin.core.enums;

public enum PermissionEnum {
    ADMIN("admin"),
    USER("user");

    private String permission;

    PermissionEnum(String permission) {
        this.permission = permission;
    }

     public String getPermission() {
        return permission;
     }
}
