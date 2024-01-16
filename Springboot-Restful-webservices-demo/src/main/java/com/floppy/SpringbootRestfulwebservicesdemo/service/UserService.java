package com.floppy.SpringbootRestfulwebservicesdemo.service;

import com.floppy.SpringbootRestfulwebservicesdemo.dto.Userdto;
import com.floppy.SpringbootRestfulwebservicesdemo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Userdto CreateUser(Userdto user);
    Userdto getbyid(long id);

    List<Userdto> GetAllUser();

    Userdto UpdateUser(Userdto user);

    void Delete_User(Long id);
}
