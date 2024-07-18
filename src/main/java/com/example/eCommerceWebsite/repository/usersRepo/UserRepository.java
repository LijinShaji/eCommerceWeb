package com.example.eCommerceWebsite.repository.usersRepo;

import com.example.eCommerceWebsite.models.userModel.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndPassword(String username, String password);
    User findByUserName(String userName);
    @Modifying
    @Query("UPDATE User SET password = :password WHERE user_id = :id")
    int updateUser(@Param("id") Long id, @Param("password") String password);
}
