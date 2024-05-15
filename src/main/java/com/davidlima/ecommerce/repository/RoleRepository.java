package com.davidlima.ecommerce.repository;

import com.davidlima.ecommerce.entity.Role;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Description of RoleRepository.
 *
 * @author David Lima
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

//  @Query(value = "SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
//  Role findRoleByName(String name);
//
//  @Query(value = "SELECT r FROM Role r WHERE r.name = ?1", nativeQuery = true)
//  Role getRoleByName(String name);

  Optional<Role> findByName(String name);
}
