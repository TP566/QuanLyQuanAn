package poly.quanan.dao.impl;

import poly.quanan.dao.DrinkDAO;
import poly.quanan.entity.Drink;
import poly.quanan.util.XJdbc;
import poly.quanan.util.XQuery;
import java.util.List;

public class DrinkDAOImpl implements DrinkDAO {

<<<<<<< HEAD
    private static final String INSERT_SQL =
        "INSERT INTO Drink(DrinkName, Origin, Price, Unit, StockQuantity, CategoryId, Discount) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL =
        "UPDATE Drink SET DrinkName=?, Origin=?, Price=?, Unit=?, StockQuantity=?, CategoryId=?, Discount=? " +
        "WHERE DrinkId=?";
    private static final String DELETE_SQL =
        "DELETE FROM Drink WHERE DrinkId=?";

    // Dùng alias để map tự động vào entity
    private static final String SELECT_ALL_SQL =
        "SELECT DrinkId       AS DrinkId,       " +
        "       DrinkName     AS DrinkName,     " +
        "       Origin        AS Origin,        " +
        "       Price         AS Price,         " +
        "       Unit          AS Unit,          " +
        "       StockQuantity AS StockQuantity, " +
        "       CategoryId    AS CategoryId,    " +
        "       Discount      AS Discount       " +
        "FROM Drink";
    private static final String SELECT_BY_ID_SQL =
        SELECT_ALL_SQL + " WHERE DrinkId=?";
    private static final String SELECT_BY_CATEGORY_SQL =
        SELECT_ALL_SQL + " WHERE CategoryId=?";
=======
    private static final String INSERT_SQL
            = "INSERT INTO Drink(DrinkName, Origin, Price, Unit, StockQuantity, CategoryId, Discount) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL
            = "UPDATE Drink SET DrinkName=?, Origin=?, Price=?, Unit=?, StockQuantity=?, CategoryId=?, Discount=? "
            + "WHERE DrinkId = CAST(? AS INT)";
    private static final String DELETE_SQL
            = "DELETE FROM Drink WHERE DrinkId = CAST(? AS INT)";

    // Dùng alias để map tự động vào entity
    private static final String SELECT_ALL_SQL
            = "SELECT CAST(DrinkId AS VARCHAR(20)) AS DrinkId, "
            + "       DrinkName AS DrinkName, "
            + "       Origin AS Origin, "
            + "       Price AS Price, "
            + "       Unit AS Unit, "
            + "       StockQuantity AS StockQuantity, "
            + "       CategoryId AS CategoryId, "
            + "       Discount AS Discount "
            + "FROM Drink";

    private static final String SELECT_BY_ID_SQL
            = "SELECT CAST(DrinkId AS VARCHAR(20)) AS DrinkId, "
            + "       DrinkName AS DrinkName, "
            + "       Origin AS Origin, "
            + "       Price AS Price, "
            + "       Unit AS Unit, "
            + "       StockQuantity AS StockQuantity, "
            + "       CategoryId AS CategoryId, "
            + "       Discount AS Discount "
            + "FROM Drink WHERE DrinkId = CAST(? AS INT)";

    private static final String SELECT_BY_CATEGORY_SQL
            = SELECT_ALL_SQL + " WHERE CategoryId=?";
>>>>>>> 059eae8 (Cập nhật code)

    @Override
    public Drink create(Drink e) {
        XJdbc.executeUpdate(INSERT_SQL,
<<<<<<< HEAD
            e.getDrinkName(),
            e.getOrigin(),
            e.getPrice(),
            e.getUnit(),
            e.getStockQuantity(),
            e.getCategoryId(),
            e.getDiscount()
        );
        // Lấy bản ghi vừa insert (DrinkId là IDENTITY)
        return XQuery.getSingleBean(Drink.class,
            "SELECT TOP 1 * FROM (" + SELECT_ALL_SQL + ") t ORDER BY DrinkId DESC");
=======
                e.getDrinkName(),
                e.getOrigin(),
                e.getPrice(),
                e.getUnit(),
                e.getStockQuantity(),
                e.getCategoryId(),
                e.getDiscount()
        );
        // Lấy bản ghi vừa insert (DrinkId là IDENTITY)
        return XQuery.getSingleBean(Drink.class,
                "SELECT TOP 1 * FROM (" + SELECT_ALL_SQL + ") t ORDER BY DrinkId DESC");
>>>>>>> 059eae8 (Cập nhật code)
    }

    @Override
    public void update(Drink e) {
        XJdbc.executeUpdate(UPDATE_SQL,
<<<<<<< HEAD
            e.getDrinkName(),
            e.getOrigin(),
            e.getPrice(),
            e.getUnit(),
            e.getStockQuantity(),
            e.getCategoryId(),
            e.getDiscount(),
            e.getDrinkId()
=======
                e.getDrinkName(),
                e.getOrigin(),
                e.getPrice(),
                e.getUnit(),
                e.getStockQuantity(),
                e.getCategoryId(),
                e.getDiscount(),
                e.getDrinkId()
>>>>>>> 059eae8 (Cập nhật code)
        );
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<Drink> findAll() {
        return XQuery.getBeanList(Drink.class, SELECT_ALL_SQL);
    }

    @Override
    public Drink findById(String id) {
        return XQuery.getSingleBean(Drink.class, SELECT_BY_ID_SQL, id);
    }

    @Override
    public List<Drink> findByCategoryId(String categoryId) {
        return XQuery.getBeanList(Drink.class, SELECT_BY_CATEGORY_SQL, categoryId);
    }
}
