package com.floppy.SpringbootRestfulwebservicesdemo.repository;

import com.floppy.SpringbootRestfulwebservicesdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
