package com.terehov.soap;

import com.terehov.soap.service.IDataProvider;
import com.terehov.soap.service.DataProvider;

public class SoapNS {

    public static void main(String[] args) {
        IDataProvider dataProvider = new DataProvider();

        /**
         *добавление пользователя
         */
//        ServiceTeamEntity serviceTeam = new ServiceTeamEntity("Филипп",
//                "Раевский", "Red group",
//                "student", "+79119045097");
//        dataProvider.insertUser(serviceTeam);


        /**
         *вывод пользователя по id
         */
        String str = dataProvider.getUserById(4);
        System.out.println(str);
        /**
         *полное прохождение программы
         */
        System.out.println("ПРОГРАММА ВЫПОЛНЕНА БЕЗ ОШИБОК");
    }
}
