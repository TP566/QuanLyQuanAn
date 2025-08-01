package poly.quanan.dao;

import poly.quanan.entity.User;

public interface UserDAO extends CrudDAO<User, String> {
    User findByUsername(String username);
}
