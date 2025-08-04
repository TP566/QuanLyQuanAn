package poly.quanan.dao;

import poly.quanan.entity.Drink;
import poly.quanan.entity.LoaiMonAn;
import java.util.List;

public interface LoaiMonAnDAO extends CrudDAO<LoaiMonAn, String> {

    List<Drink> findByLoaiId(String maLoai);

}