package poly.quanan.dao;

import poly.quanan.entity.Drink;
import poly.quanan.entity.Category;
import java.util.List;

public interface CategoryDAO extends CrudDAO<Category, String> {

    List<Drink> findByLoaiId(String maLoai);

}
