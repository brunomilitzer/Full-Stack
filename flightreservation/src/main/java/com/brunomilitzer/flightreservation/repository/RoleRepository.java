package com.brunomilitzer.flightreservation.repository;

import com.brunomilitzer.flightreservation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
