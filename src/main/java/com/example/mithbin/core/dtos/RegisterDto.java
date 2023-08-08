package com.example.mithbin.core.dtos;

import com.example.mithbin.core.enums.PermissionEnum;

import java.util.List;

public record RegisterDto(
        String login,
        String password,
        List<String> permissions
) {}
