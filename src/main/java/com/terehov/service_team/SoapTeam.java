package com.terehov.service_team;

import com.terehov.service_team.model.UserEntity;
import com.terehov.service_team.repository.UserRepository;
import com.terehov.service_team.service.TeamServiceImpl;


//public class SoapTeam {
//        public static void main(String[] args) {
//
//
//            TeamServiceImpl teamService = new TeamServiceImpl();
////            System.out.println((teamService.getLectorGroup(teamService.getUserClass(1).getIdClassEntity().getId())).getIdUserEntity().getFirstName());
//
//            String response = String.valueOf(teamService.getUserById(3));
//            System.out.println(response);
//    for(Object i: teamService.selectAllUsers().toArray()){
//        System.out.println(i);
//    }
//    }

//    public static void main(String[] args) {
//        try{
//            String url = "jdbc:postgresql://localhost:5432/service_team";
//            String username = "postgres";
//            String password = "3440";
//            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)){
//
//                System.out.println(conn);
//                System.out.println("Connection to Store DB successful!");
//            }
//        }
//        catch(Exception ex){
//            System.out.println("Connection failed...");
//
//            System.out.println(ex);
//        }
//    }
//}
