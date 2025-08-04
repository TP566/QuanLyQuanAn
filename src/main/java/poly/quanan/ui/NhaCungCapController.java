/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.quanan.ui;


import poly.quanan.entity.NhaCungCap;
import poly.quanan.ui.manager.CrudController;

/**
 *
 * @author lengh
 */
public interface NhaCungCapController {
   void open();
    void create();
    void update();
    void delete();
    void clear();

    void checkAll();
    void uncheckAll();
    void deleteCheckedItems();

    void moveFirst();
    void movePrevious();
    void moveNext();
    void moveLast();
    void moveTo(int rowIndex);
    void edit();
}
