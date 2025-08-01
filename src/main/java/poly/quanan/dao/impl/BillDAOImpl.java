package poly.quanan.dao.impl;

import poly.quanan.dao.BillDAO;
import poly.quanan.entity.Bill;
import poly.quanan.util.XJdbc;
import poly.quanan.util.XQuery;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class BillDAOImpl implements BillDAO {

    private final String createSql = "INSERT INTO Bill(Username, Checkin, Checkout, Status, CardId) VALUES(?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Bill SET Username=?, Checkin=?, Checkout=?, Status=?, CardId=? WHERE MaHD=?";
    private final String deleteByIdSql = "DELETE FROM Bill WHERE MaHD=?";

    private final String findAllSql = "SELECT * FROM Bill";
    private final String findByIdSql = "SELECT * FROM Bill WHERE MaHD = ?";
    private final String findLastSql = "SELECT * FROM Bill WHERE MaHD = (SELECT MAX(MaHD) FROM Bill)";
    private final String findByUsernameSql = findAllSql + " WHERE Username=?";
    private final String findServicingByUsernameSql = findAllSql + " WHERE Username=? AND Status=0";
    private final String findByTimeRangeSql = findAllSql + " WHERE Checkin BETWEEN ? AND ? ORDER BY Checkin DESC";
    private final String findByUserAndTimeRangeSql = findAllSql + " WHERE Username=? AND Checkin BETWEEN ? AND ? ORDER BY Checkin DESC";

    @Override
    public Bill create(Bill entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getCheckin(),
            entity.getCheckout(),
            entity.getStatus(),
            entity.getCardId()
        };
        XJdbc.executeUpdate(createSql, values);
        return XQuery.getSingleBean(Bill.class, findLastSql);
    }

    @Override
    public void update(Bill entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getCheckin(),
            entity.getCheckout(),
            entity.getStatus(),
            entity.getCardId(),
            entity.getMaHd()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Bill> findAll() {
        return XQuery.getBeanList(Bill.class, findAllSql);
    }

    @Override
    public Bill findById(Long id) {
        return XQuery.getSingleBean(Bill.class, findByIdSql, id);
    }

    @Override
    public List<Bill> findByUsername(String username) {
        return XQuery.getBeanList(Bill.class, findByUsernameSql, username);
    }

    public Bill findServicingByUsername(String username) {
        Bill bill = XQuery.getSingleBean(Bill.class, findServicingByUsernameSql, username);
        if (bill == null) {
            Bill newBill = new Bill();
            newBill.setUsername(username);
            newBill.setCheckin(new Timestamp(System.currentTimeMillis()));
            newBill.setStatus(0);
            newBill.setCardId(1);
            bill = this.create(newBill);
        }
        return bill;
    }

    @Override
    public List<Bill> findByTimeRange(Date from, Date to) {
        return XQuery.getBeanList(Bill.class, findByTimeRangeSql, from, to);
    }

    public List<Bill> findByUserAndTimeRange(String username, Date from, Date to) {
        return XQuery.getBeanList(Bill.class, findByUserAndTimeRangeSql, username, from, to);
    }

    public Bill findByUsername(Long username) {
        return null;
    }

    public Bill findServicingByCardId(int cardId) {
        String sql = "SELECT * FROM Bill WHERE Status = 0 AND CardId = ?";
        return XQuery.getSingleBean(Bill.class, sql, cardId);
    }

    @Override
    public List<Bill> findByCardId(Integer cardId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bill findServicingByCardId(Integer cardId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
