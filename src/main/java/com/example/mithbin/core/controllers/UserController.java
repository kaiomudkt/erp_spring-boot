package com.example.mithbin.core.controllers;

import com.example.mithbin.core.models.UserModel;
import com.example.mithbin.core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RequestController
//@RequestMapping(value="/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> findAll() {
        List<UserModel> result = userRepository.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value="/users/page")
    public ResponseEntity<Page<UserModel>> findAll(Pageable pageable) {
        Page<UserModel> result = userRepository.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value="/users/search-age")
    public ResponseEntity<Page<UserModel>> searchByAge(
            @RequestParam(defaultValue = "0")
            Double minAge,
            @RequestParam(defaultValue = "150")
            Double maxAge,
            Pageable page
    ) {
        Page<UserModel> result = userRepository.findByAgeBetween(minAge, maxAge, page);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value="/users/search-name")
    public ResponseEntity<Page<UserModel>> searchByName(
            @RequestParam(defaultValue = "")
            String name,
            Pageable page
    ) {
        Page<UserModel> result = userRepository.findByName(name, page);
        return ResponseEntity.ok(result);
    }
}
