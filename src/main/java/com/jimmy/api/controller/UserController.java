package com.jimmy.api.controller;

import com.jimmy.api.model.User;
import com.jimmy.api.model.dto.RoleDTO;
import com.jimmy.api.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
    public class UserController {

        private final IUserService userService;

        @GetMapping
        public ResponseEntity<List<User>> findAll() {
            return ResponseEntity.ok(userService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> findById(@PathVariable UUID id) {
            return ResponseEntity.ok(userService.findById(id));
        }

        @PostMapping
        public ResponseEntity<User> save(@RequestBody User user) {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
        }

        @PutMapping("/{id}")
        public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User user) {
            return ResponseEntity.ok(userService.update(id, user));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable UUID id) {
            userService.delete(id);
            return ResponseEntity.noContent().build();
        }
     @GetMapping("/{id}/roles")
    public ResponseEntity<List<RoleDTO>> getRolesByUserId(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getRolesByUserId(id));
    }
}
