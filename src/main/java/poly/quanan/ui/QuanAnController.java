package poly.quanan.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import poly.quanan.ui.manager.BillManagerJDialog;
import poly.quanan.ui.manager.LoaiMonAnManagerJDialog;
import poly.quanan.ui.manager.DrinkManagerJDialog;
import poly.quanan.ui.manager.UserManagerJDialog;
import poly.quanan.util.XDialog;

public interface QuanAnController {

    /**
     * Hiển thị cửa sổ chào Hiển thị cửa sổ đăng nhập Hiển thị thông tin user
     * đăng nhập Disable/Enable các thành phần tùy thuộc vào vai trò đăng nhập
     */
    void init();

    default void exit() {
        if (XDialog.confirm("Bạn muốn kết thúc?")) {
            System.exit(0);
        }
    }

    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    default void showWelcomeJDialog(JFrame frame) {
        this.showJDialog(new WelcomeJDialog(frame, true));
    }

    default void showLoginJDialog(JFrame frame) {
        this.showJDialog(new LoginJDialog(frame, true));
    }

    default void showChangePasswordJDialog(JFrame frame) {
        this.showJDialog(new ChangePasswordJDialog(frame, true));
    }

    default void showHistoryJDialog(JFrame frame) {
        this.showJDialog(new LichSuJDialog(frame, true));
    }

    default void showDrinkManagerJDialog(JFrame frame) {
        this.showJDialog(new DrinkManagerJDialog(frame, true));
    }

    default void showCategoryManagerJDialog(JFrame frame) {
        this.showJDialog(new LoaiMonAnManagerJDialog(frame, true));
    }

    default void showBillManagerJDialog(JFrame frame) {
        this.showJDialog(new BillManagerJDialog(frame, true));
    }

    default void showNhaCungCapJDialog(JFrame frame) {
        this.showJDialog(new NhaCungCapJDialog(frame, true));
    }

    default void showUserManagerJDialog(JFrame frame) {
        this.showJDialog(new UserManagerJDialog(frame, true));
    }
}
