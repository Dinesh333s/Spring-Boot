package com.floppy.SpringbootRestfulwebservicesdemo.controller;

import com.floppy.SpringbootRestfulwebservicesdemo.dto.Userdto;
import com.floppy.SpringbootRestfulwebservicesdemo.entity.User;
import com.floppy.SpringbootRestfulwebservicesdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    //Create new user
    @PostMapping("create")
    private ResponseEntity<Userdto> CreateUser(@RequestBody Userdto user)
    {
        Userdto user1 = userService.CreateUser(user);

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    //Get the User By Id
    @GetMapping("{id}")
    private ResponseEntity<Userdto> getbyid(@PathVariable Long id)
    {
        Userdto user = userService.getbyid(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //Get All the Users
    @GetMapping("All")
    private ResponseEntity<List<Userdto>> GetAllUser()
    {
        List<Userdto> user = userService.GetAllUser();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    //Update User
    @PutMapping("{id}/update")
    private ResponseEntity<Userdto> UpdateUser(@PathVariable Long id, @RequestBody Userdto user)
    {
        user.setId(id);
        return new ResponseEntity<>(userService.UpdateUser(user),HttpStatus.OK);
    }

    @DeleteMapping("{id}/delete")
    private ResponseEntity<String> DeleteUser(@PathVariable Long id)
    {
        userService.Delete_User(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
