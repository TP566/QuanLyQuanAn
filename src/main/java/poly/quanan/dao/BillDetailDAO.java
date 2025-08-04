package poly.quanan.dao;

import poly.quanan.entity.BillDetail;
import java.util.List;

public interface BillDetailDAO extends CrudDAO<BillDetail, Long> {

    List<BillDetail> findByBillId(Long billId);

    List<BillDetail> findByProductId(int productId);
}
