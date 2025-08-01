/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.quanan.ui.manager;

import poly.quanan.entity.Bill;

/**
 *
 * @author lengh
 */
public interface DrinkController {

    void setBill(Bill bill); // nhận bill từ BillJDialog

    void open(); // hiển thị loại và đồ uống

    void fillDrinkCategory(); // tải và hiển thị loại đồ uống

    void fillDrink(); // tải và hiển thị đồ uống

    void addDrinkToBill(); // thêm đồ uống vào
    
    void fillCategories();
    
    void chooseFile();
}

