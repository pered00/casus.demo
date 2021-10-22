package casus.casus.demo.repository;

import casus.casus.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String Name);

    Optional<User> findByUserName(String username);
}
