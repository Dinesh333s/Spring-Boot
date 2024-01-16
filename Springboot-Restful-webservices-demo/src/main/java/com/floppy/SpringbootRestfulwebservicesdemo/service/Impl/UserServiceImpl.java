package com.floppy.SpringbootRestfulwebservicesdemo.service.Impl;

import com.floppy.SpringbootRestfulwebservicesdemo.dto.Userdto;
import com.floppy.SpringbootRestfulwebservicesdemo.entity.User;
import com.floppy.SpringbootRestfulwebservicesdemo.exception.EmailAlreadyExistsException;
import com.floppy.SpringbootRestfulwebservicesdemo.exception.ResourceNotFoundException;
import com.floppy.SpringbootRestfulwebservicesdemo.mapper.AutoUserMapper;
import com.floppy.SpringbootRestfulwebservicesdemo.mapper.UserMapper;
import com.floppy.SpringbootRestfulwebservicesdemo.repository.UserRepo;
import com.floppy.SpringbootRestfulwebservicesdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.RecognitionException;
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

//  1)      User user1 = new User(
//                user.getId(),
//                user.getFirstname(),
//                user.getLastname(),
//                user.getEmail()
//        );

//    2)    User user1 = UserMapper.UserdtotoUser(user);

//    3)   User user1 = modelMapper.map(user, User.class);

        Optional<User> email = userRepo.findByEmail(user.getEmail());
        if(email.isPresent())
        {
            throw new EmailAlreadyExistsException("Email Already Exists for user");
        }
        User user1 = AutoUserMapper.MAPPER.mapTouser(user); //4th method
       User saved_user = userRepo.save(user1);
       //Again Convert back to userDTO to return
       //Convert User to UserDTO

//    1)    Userdto user2 = new Userdto(
//                saved_user.getId(),
//                saved_user.getFirstname(),
//                saved_user.getLastname(),
//                saved_user.getEmail()
//        );
//    2)    Userdto userdto = UserMapper.UsertoUserdto(saved_user);

//    3)    Userdto userdto = modelMapper.map(saved_user, Userdto.class);
        Userdto userdto = AutoUserMapper.MAPPER.mapTouserdto(saved_user);  // 4th method
        return userdto;
    }

    @Override
    public Userdto getbyid(long id) {
         User user  = userRepo.findById(id).orElseThrow(
                 () -> new ResourceNotFoundException("User","id",id));
//        return UserMapper.UsertoUserdto(user);
//        return modelMapper.map(user, Userdto.class);
        return AutoUserMapper.MAPPER.mapTouserdto(user);
    }

    @Override
    public List<Userdto> GetAllUser() {
         List<User> users = userRepo.findAll();
//        return user.stream().map(UserMapper::UsertoUserdto).collect(Collectors.toList()) ; 2nd method
//        return users.stream().map((user) -> modelMapper.map(user, Userdto.class)).collect(Collectors.toList(); 3rd method
        return users.stream().map((user) ->AutoUserMapper.MAPPER.mapTouserdto(user)).collect(Collectors.toList()) ; //4th method
    }

    @Override
    public Userdto UpdateUser(Userdto user) {
         User existing_user = userRepo.findById(user.getId()).orElseThrow(
                 () -> new ResourceNotFoundException("User","id",user.getId()));
         existing_user.setFirstname(user.getFirstname());
         existing_user.setLastname(user.getLastname());
         existing_user.setEmail(user.getEmail());
         User saved = userRepo.save(existing_user);
//        return UserMapper.UsertoUserdto(saved); 2nd method
//        return modelMapper.map(saved, Userdto.class); 3rd method
        return AutoUserMapper.MAPPER.mapTouserdto(saved); //4th method
    }

    @Override
    public void Delete_User(Long id) {
        User existing_user = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User","id",id));
        userRepo.deleteById(id);

    }
}
