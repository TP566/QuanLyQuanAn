/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.quanan.dao;

import poly.quanan.dao.*;
import poly.quanan.entity.Card;
import poly.quanan.entity.Bill;

/**
 *
 * @author lengh
 */
public interface CardDAO extends CrudDAO<Card, Integer> {

    public void deleteById(String id);

    public Card findById(String id);
    
    public Card findByUsername(String username);

}
