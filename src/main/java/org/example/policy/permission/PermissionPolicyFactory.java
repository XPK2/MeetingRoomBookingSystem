package org.example.policy.permission;

import org.example.model.User;

public class PermissionPolicyFactory {
    public PermissionPolicy getPolicy(User user) {
        return switch (user.getRole()) {
            case ADMIN -> new AdminPermissionPolicy();
            case USER -> new UserPermissionPolicy();
        };
    }
}
