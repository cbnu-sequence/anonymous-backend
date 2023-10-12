package com.sequence.anonymous.user.domain.repository;

import com.sequence.anonymous.user.domain.user.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmailAndProviderId(String email, String providerId);
  Optional<User> findByName(String name);


}
