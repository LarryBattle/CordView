package dev.larrybattle.cordview.repository;

import dev.larrybattle.cordview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
