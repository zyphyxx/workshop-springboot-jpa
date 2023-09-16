package com.edgar.webservice.repositories;

import com.edgar.webservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {


}
