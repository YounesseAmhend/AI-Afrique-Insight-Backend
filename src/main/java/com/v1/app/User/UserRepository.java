package com.v1.app.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { // here User is the entity this class is managing
                                                                       // and Integer is telling it that the type of the
                                                                       // primary Key(id) is an integer

    Optional<User> findByEmail(String email); // mo7arabate nullpointerexception hhhhhh and kayna chi 9wada we can use
                                              // like .orElse() or .orElseThrow() etc

}
