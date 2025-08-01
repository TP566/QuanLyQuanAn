package poly.quanan.dao.impl;

import java.util.List;
import poly.quanan.dao.DrinkDAO;
import poly.quanan.entity.Drink;
import poly.quanan.util.XJdbc;
import poly.quanan.util.XStr;
import poly.quanan.util.XQuery;

public class DrinkDAOImpl implements DrinkDAO {

    // SQL tương ứng với cấu trúc bảng Drinks (cột Id,String; Name,String; Origin,String; 
    // Price,double; Unit,String; StockQuantity,int; CategoryId,String; Discount,double)
    private final String createSql =
        "INSERT INTO Drinks(Id, Name, Origin, Price, Unit, StockQuantity, CategoryId, Discount) "
      + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private final String updateSql =
        "UPDATE Drinks "
      + "SET Name=?, Origin=?, Price=?, Unit=?, StockQuantity=?, CategoryId=?, Discount=? "
      + "WHERE Id=?";
    private final String deleteByIdSql =
        "DELETE FROM Drinks WHERE Id=?";
    private final String findAllSql =
        "SELECT * FROM Drinks";
    private final String findByIdSql =
        findAllSql + " WHERE Id=?";
    private final String findByCategoryIdSql =
        findAllSql + " WHERE CategoryId=?";

    @Override
    public Drink create(Drink entity) {
    entity.setDrinkId(XStr.getKey());  // giờ đúng kiểu String
    XJdbc.executeUpdate(createSql,
        entity.getDrinkId(),
        entity.getDrinkName(),
        entity.getOrigin(),
        entity.getPrice(),
        entity.getUnit(),
        entity.getStockQuantity(),
        entity.getCategoryId(),
        entity.getDiscount()
    );
    return entity;
}

    @Override
    public void update(Drink entity) {
        Object[] values = {
            entity.getDrinkName(),
            entity.getOrigin(),
            entity.getPrice(),
            entity.getUnit(),
            entity.getStockQuantity(),
            entity.getCategoryId(),
            entity.getDiscount(),
            entity.getDrinkId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Drink> findAll() {
        return XQuery.getBeanList(Drink.class, findAllSql);
    }

    @Override
    public Drink findById(String id) {
        return XQuery.getSingleBean(Drink.class, findByIdSql, id);
    }

    @Override
    public List<Drink> findByCategoryId(String categoryId) {
        return XQuery.getBeanList(Drink.class, findByCategoryIdSql, categoryId);
    }
}
