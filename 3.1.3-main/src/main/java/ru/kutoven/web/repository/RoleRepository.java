package ru.kutoven.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kutoven.web.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNameRole(String nameRole);
}