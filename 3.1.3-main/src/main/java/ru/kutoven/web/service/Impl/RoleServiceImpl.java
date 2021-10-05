package ru.kutoven.web.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kutoven.web.entity.Role;
import ru.kutoven.web.repository.RoleRepository;
import ru.kutoven.web.service.RoleService;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void addNewRole(Role role) {
        log.info("Saving new role {} to database", role.getNameRole());
        Role roleByName = roleRepository.findByNameRole(role.getNameRole());
        if (roleByName != null) {
            throw new IllegalStateException("Role taken");
        }
        roleRepository.save(role);
    }

    @Override
    public Role findByNameRole(String nameRole) {
        return roleRepository.findByNameRole(nameRole);
    }
}
