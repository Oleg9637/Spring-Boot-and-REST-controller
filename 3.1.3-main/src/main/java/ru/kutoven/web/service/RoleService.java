package ru.kutoven.web.service;

import ru.kutoven.web.entity.Role;

public interface RoleService {
    void addNewRole(Role nameRole);
    Role findByNameRole(String nameRole);
}

