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

    public static PermissionEnum toEnum(String value) {
        for (PermissionEnum permissionEnum : PermissionEnum.values()) {
            if (permissionEnum.permission.equalsIgnoreCase(value)) {
                return permissionEnum;
            }
        }
        throw new IllegalArgumentException("Invalid permission: " + value);
    }
}
