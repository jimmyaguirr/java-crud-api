package com.jimmy.api.controller;

import com.jimmy.api.model.dto.RoleDTO;
import com.jimmy.api.model.UserRole;
import com.jimmy.api.service.interfaces.IUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRoleController {

    private final IUserRoleService userRoleService;

    // GET /api/users/{id}/roles
    @GetMapping("/{id}/roles")
    public ResponseEntity<List<RoleDTO>> getRolesByUserId(@PathVariable UUID id) {
        return ResponseEntity.ok(userRoleService.getRolesByUserId(id));
    }

    // POST /api/users/{id}/roles/{roleId}
    @PostMapping("/assignRole")
    public ResponseEntity<UserRole> assignRole(
            @RequestParam UUID userId,
            @RequestParam UUID roleId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userRoleService.assignRole(userId, roleId));
    }

    // DELETE /api/users/roles/{id}
    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Void> removeRole(@PathVariable UUID id) {
        userRoleService.removeRole(id);
        return ResponseEntity.noContent().build();
    }
}