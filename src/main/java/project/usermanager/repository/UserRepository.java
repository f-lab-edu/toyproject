package project.usermanager.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.usermanager.domain.User;
import project.usermanager.dto.UserDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select id, name, age, gender from user where name = :name", nativeQuery = true)
    List<String> findByName(@Param(value ="name")String name);

    @Query(value = "select * from user", nativeQuery = true)
    List<String> findByAll();

    @Query(value = "select id from user where id = :id", nativeQuery = true)
    Optional<String> findById(@Param(value ="id")String id);
}
