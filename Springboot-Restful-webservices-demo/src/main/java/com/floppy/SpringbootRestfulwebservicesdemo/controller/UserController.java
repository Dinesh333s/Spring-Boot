package com.floppy.SpringbootRestfulwebservicesdemo.controller;

import com.floppy.SpringbootRestfulwebservicesdemo.dto.Userdto;
import com.floppy.SpringbootRestfulwebservicesdemo.exception.ErrorDetails;
import com.floppy.SpringbootRestfulwebservicesdemo.exception.ResourceNotFoundException;
import com.floppy.SpringbootRestfulwebservicesdemo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "CRUD REST API for user Resource",
        description = "CRUD REST API - create user, Get user, update user, delete user")
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    //Create new user
    @Operation(summary = "Create user REST API",
            description = "Create user Rest Api")
    @ApiResponse(responseCode = "201",
            description = "HTTP Status 201 CREATED")
    @PostMapping("create")
    private ResponseEntity<Userdto> CreateUser(@RequestBody @Valid Userdto user) {
        Userdto user1 = userService.CreateUser(user);

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    //Get the User By Id
    @Operation(summary = "Get user by id REST API",
            description = "Get single user by id  Rest Api")
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    @GetMapping("{id}")
    private ResponseEntity<Userdto> getbyid(@PathVariable Long id) {
        Userdto user = userService.getbyid(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Get All the Users
    @Operation(summary = "Get All User REST API",
            description = "Get All User Rest Api")
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    @GetMapping("All")
    private ResponseEntity<List<Userdto>> GetAllUser() {
        List<Userdto> user = userService.GetAllUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    //Update User
    @Operation(summary = "Update user REST API",
            description = "Get update user Rest Api")
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    @PutMapping("{id}/update")
    private ResponseEntity<Userdto> UpdateUser(@PathVariable Long id, @RequestBody @Valid Userdto user) {
        user.setId(id);
        return new ResponseEntity<>(userService.UpdateUser(user), HttpStatus.OK);
    }

    @Operation(summary = "Delete user REST API",
            description = "Delete user by id  Rest Api")
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    @DeleteMapping("{id}/delete")
    private ResponseEntity<String> DeleteUser(@PathVariable Long id) {
        userService.Delete_User(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    //Specific Exception
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
//                                                                        WebRequest webRequest)
//    {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                resourceNotFoundException.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
