package spring.boot.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.boot.backend.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer>{

}
