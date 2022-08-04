package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserRestController {

    /*
    @GetMapping("/users")
    public @ResponseBody String getAllUser() {
        return "user1, user2, user3, user4, user5, user6, user7";
    }
     */

    @Autowired
    UserServiceInter userService;
/*
    @GetMapping("/users")
    public String getAllUser() {
        return "user1, user2, user3, user4, user5, user6, user7, user8";
    }

 */

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getAllUser(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "nationalityId", required = false) Integer nationalityId
    ) {
        List<User> userList = userService.getAll(name, surname, nationalityId);
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userList) {
            userDTOList.add(new UserDTO(user));
        }

        if (1 == 1) {
            throw new RuntimeException();
        }

        //        return ResponseEntity.status(HttpStatus.OK).body(userDTOList);
        return ResponseEntity.ok(ResponseDTO.of(userDTOList));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") int id) {
        User user = userService.getById(id);

        //        return ResponseEntity.status(HttpStatus.OK).body(userDTOList);
        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user)));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id) {
        User user = userService.getById(id);

        userService.remove(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user), "Successfully deleted"));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setProfileDesc(userDTO.getProfileDescription());

        userService.addUser(user);

        userDTO.setId(user.getId());

        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Successfully added"));
    }
}
