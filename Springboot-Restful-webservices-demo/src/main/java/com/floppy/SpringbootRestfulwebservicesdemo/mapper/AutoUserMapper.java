package com.floppy.SpringbootRestfulwebservicesdemo.mapper;

import com.floppy.SpringbootRestfulwebservicesdemo.dto.Userdto;
import com.floppy.SpringbootRestfulwebservicesdemo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    //Take User and convert to Userdto
    Userdto mapTouserdto(User user);

    //take Userdto and convert to user
    User mapTouser(Userdto userdto);

}
