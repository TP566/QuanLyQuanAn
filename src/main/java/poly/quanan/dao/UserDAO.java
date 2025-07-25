package poly.quanan.dao;

import poly.quanan.entity.User;
import java.util.List;

public interface UserDAO extends CrudDAO<User, Integer> {
    User findByUsername(String username);
}
