package poly.quanan.dao;

import poly.quanan.entity.Drink;
import java.util.List;

public interface DrinkDAO extends CrudDAO<Drink, String> {
    List<Drink> findByCategoryId (String maLoai);
}
