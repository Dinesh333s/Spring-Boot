package com.floppy.SpringbootRestfulwebservicesdemo.mapper;

import com.floppy.SpringbootRestfulwebservicesdemo.dto.Userdto;
import com.floppy.SpringbootRestfulwebservicesdemo.entity.User;

public class UserMapper {


    //Convert UserDto to User
    public static User UserdtotoUser(Userdto user)
    {
        User user1 = new User(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );

        return user1;
    }

    //Convert User into UserDTO
    public static Userdto UsertoUserdto(User user)
    {
        Userdto userdto = new Userdto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
        return userdto;
    }

}
