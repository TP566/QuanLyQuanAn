/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.quanan.util;

import poly.quanan.entity.User;

public class XAuth {

    public static User user = User.builder()
            .username("Chad")
            .password("123")
            .enabled(true)
            .manager(true)
            .fullname("Nguyễn Trần Thiên Phú")
            .photo("trump.png")
            .build();
}
