package poly.quanan.dao.impl;

import poly.quanan.dao.*;
import poly.quanan.entity.User;
import poly.quanan.util.XJdbc;
import poly.quanan.util.XQuery;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final String insertSql = "INSERT INTO User (Username, Password, Enabled, Fullname, Manager) VALUES (?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE User SET Password = ?, Enabled = ?, Fullname = ?, Manager = ? WHERE Username = ?";
    private final String deleteSql = "DELETE FROM User WHERE Username = ?";
    private final String findAllSql = "SELECT * FROM User";
    private final String findByIdSql = "SELECT * FROM User WHERE Username = ?";
    private final String findByUsernameSql = "SELECT * FROM User WHERE Username = ?";

    @Override
    public User create(User entity) {
        Object[] args = {
            entity.getUsername(),
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.isManager()
        };
        XJdbc.executeUpdate(insertSql, args);
        return entity;
    }

    @Override
    public void update(User entity) {
        Object[] args = {
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.isManager(),
            entity.getUsername()
        };
        XJdbc.executeUpdate(updateSql, args);
    }

    public void deleteById(String username) {
        XJdbc.executeUpdate(deleteSql, username);
    }

    @Override
    public List<User> findAll() {
        return XQuery.getBeanList(User.class, findAllSql);
    }

    public User findById(String username) {
        return XQuery.getSingleBean(User.class, findByIdSql, username);
    }

    @Override
    public User findByUsername(String username) {
        return XQuery.getSingleBean(User.class, findByUsernameSql, username);
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
