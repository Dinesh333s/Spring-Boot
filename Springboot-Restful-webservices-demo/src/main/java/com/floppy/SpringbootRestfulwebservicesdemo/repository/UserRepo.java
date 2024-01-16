package com.floppy.SpringbootRestfulwebservicesdemo.repository;

import com.floppy.SpringbootRestfulwebservicesdemo.entity.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
