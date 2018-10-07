package com.hamidApp1.service.usersGis;

import com.hamidApp1.model.usersGis.UsersGis;

import java.util.List;

public interface UsersGisServices {
    List<UsersGis> findAll();

    void savePv(UsersGis pvs);

    UsersGis findById(int id_user);

    List<UsersGis> findByFirstName(String user_name);
}
