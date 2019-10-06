package pl.coderslab.warsztaty6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.warsztaty6.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);
}
