package be.isib.dao;

import be.isib.entity.User;

public interface UserDao extends EntityDao<User> {

    User findByUsername(String username) throws Exception;

}
