package org.example.domain.policy.permission;

import org.example.domain.model.User;

public class PermissionPolicyFactory {
    public PermissionPolicy getPolicy(User user) {
        return switch (user.getRole()) {
            case ADMIN -> new AdminPermissionPolicy();
            case USER -> new UserPermissionPolicy();
        };
    }
}
