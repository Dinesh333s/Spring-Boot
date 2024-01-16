package com.floppy.SpringbootRestfulwebservicesdemo.service.Impl;

import com.floppy.SpringbootRestfulwebservicesdemo.dto.Userdto;
import com.floppy.SpringbootRestfulwebservicesdemo.entity.User;
import com.floppy.SpringbootRestfulwebservicesdemo.mapper.UserMapper;
import com.floppy.SpringbootRestfulwebservicesdemo.repository.UserRepo;
import com.floppy.SpringbootRestfulwebservicesdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    private ModelMapper modelMapper; // we are using allargs construtor so need to create constructor

     public Userdto CreateUser(Userdto user)
    {
        //Convert UserDto into User

//        User user1 = new User(
//                user.getId(),
//                user.getFirstname(),
//                user.getLastname(),
//                user.getEmail()
//        );

//        User user1 = UserMapper.UserdtotoUser(user);

        User user1 = modelMapper.map(user, User.class);
       User saved_user = userRepo.save(user1);
       //Again Convert back to userDTO to return
       //Convert User to UserDTO

//        Userdto user2 = new Userdto(
//                saved_user.getId(),
//                saved_user.getFirstname(),
//                saved_user.getLastname(),
//                saved_user.getEmail()
//        );
//        Userdto userdto = UserMapper.UsertoUserdto(saved_user);

        Userdto userdto = modelMapper.map(saved_user, Userdto.class);
        return userdto;
    }

    @Override
    public Userdto getbyid(long id) {
         Optional<User> Optional_user  = userRepo.findById(id);
         User user = Optional_user.get();
//        return UserMapper.UsertoUserdto(user);
        return modelMapper.map(user, Userdto.class);
    }

    @Override
    public List<Userdto> GetAllUser() {
         List<User> users = userRepo.findAll();
//        return user.stream().map(UserMapper::UsertoUserdto).collect(Collectors.toList()) ;
        return users.stream().map((user) -> modelMapper.map(user, Userdto.class)).collect(Collectors.toList()) ;
    }

    @Override
    public Userdto UpdateUser(Userdto user) {
         User existing_user = userRepo.findById(user.getId()).get();
         existing_user.setFirstname(user.getFirstname());
         existing_user.setLastname(user.getLastname());
         existing_user.setEmail(user.getEmail());
         User saved = userRepo.save(existing_user);
//        return UserMapper.UsertoUserdto(saved);
        return modelMapper.map(saved, Userdto.class);
    }

    @Override
    public void Delete_User(Long id) {
        userRepo.deleteById(id);
    }
}
