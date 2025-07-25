package poly.quanan.dao;

import poly.quanan.entity.Bill;
import java.util.Date;
import java.util.List;

public interface BillDAO extends CrudDAO<Bill, Long> {
    List<Bill> findByUsername(String username);
    List<Bill> findByCardId(Integer cardId);
    List<Bill> findByTimeRange(Date begin, Date end);
    Bill findServicingByCardId(Integer cardId);
}
