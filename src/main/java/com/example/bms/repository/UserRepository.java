package com.example.bms.repository;

import com.example.bms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    //@Override
    Optional<User> findById(Long aLong);

    //findById(Long aLong);

   public List<User> findByName(String name);

   public User save(User user);
}
