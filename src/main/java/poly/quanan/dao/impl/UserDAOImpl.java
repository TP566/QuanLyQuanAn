package poly.quanan.dao.impl;

import java.util.List;
import poly.quanan.dao.UserDAO;
import poly.quanan.entity.User;
import poly.quanan.util.XJdbc;
import poly.quanan.util.XQuery;

public class UserDAOImpl implements UserDAO {

    private final String insertSql       = "INSERT INTO Users(Username, Password, Enabled, Fullname, Manager) VALUES(?,?,?,?,?)";
    private final String updateSql       = "UPDATE Users SET Password=?, Enabled=?, Fullname=?, Manager=? WHERE Username=?";
    private final String deleteByIdSql   = "DELETE FROM Users WHERE Username=?";
    private final String findAllSql      = "SELECT * FROM Users";
    private final String findByIdSql     = "SELECT * FROM Users WHERE Username=?";
    private final String findByUsernameSql = findByIdSql;

    @Override
    public User create(User entity) {
        XJdbc.executeUpdate(insertSql,
            entity.getUsername(),
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.isManager()
        );
        return entity;
    }

    @Override
    public void update(User entity) {
        XJdbc.executeUpdate(updateSql,
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.isManager(),
            entity.getUsername()
        );
    }

    @Override
    public void deleteById(String username) {
        XJdbc.executeUpdate(deleteByIdSql, username);
    }

    @Override
    public List<User> findAll() {
        return XQuery.getBeanList(User.class, findAllSql);
    }

    @Override
    public User findById(String username) {
        return XQuery.getSingleBean(User.class, findByIdSql, username);
    }

    @Override
    public User findByUsername(String username) {
        return XQuery.getSingleBean(User.class, findByUsernameSql, username);
    }
}
