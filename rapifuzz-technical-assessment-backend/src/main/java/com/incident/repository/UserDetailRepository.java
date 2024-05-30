package com.incident.repository;

import com.incident.model.UserDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserDetailRepository extends CrudRepository<UserDetail , Integer>{
	
    @Override
    UserDetail save(UserDetail userDetail);
    
    boolean existsByEmailId(String email);
    
    @Query(value = "SELECT * FROM user_details WHERE User_email = :email", nativeQuery = true)
    UserDetail findByEmail(String email);
    
    @Query(value = "SELECT user_name, user_address, city_name, country_name FROM user_details WHERE User_email = :email", nativeQuery = true)
    UserDetail findEmail(String email);

    
    @Modifying
	@Query(value = "UPDATE user_details SET password = :password, Confirm_Password = :confirmPassword WHERE User_email = :email", nativeQuery = true)
	void update(@Param("password") String password, @Param("confirmPassword") String confirmPassword , @Param("email") String email);
	
}
