package com.terehov.soap;

import com.terehov.soap.model.StudentsEntity;
import com.terehov.soap.service.IDataProvider;
import com.terehov.soap.service.DataProvider;

import java.util.List;

public class SoapNS {

    public static void main(String[] args) {
        IDataProvider dataProvider = new DataProvider();

        /**
         *добавление пользователя
         */
//        StudentsEntity studentsEntity = new StudentsEntity("Евгений", "Терехов",
//                "https://t.me/Evgenii_Terehov");
//        dataProvider.insertUser(studentsEntity);

        /**
         *вывод всех пользователей
         */
//        List<StudentsEntity> list = dataProvider.selectAllUsers();
//        for(StudentsEntity elem : list) {
//            System.out.println(elem.toString());
//        }

        /**
         *вывод списка пользователей по списку id
         */
//        List<Integer> listOfId = new ArrayList<>();
//        listOfId.add(1);
//        listOfId.add(2);
//        listOfId.add(4);
//        List<StudentsEntity> list = dataProvider.getListUsersByListOfId(listOfId);
//        for(StudentsEntity list1 : list){
//            System.out.println(list1);
//        }

        /**
         *вывод пользователя по id
         */
        StudentsEntity str = dataProvider.getUserById(1);
        System.out.println(str.toString());
    }
}
