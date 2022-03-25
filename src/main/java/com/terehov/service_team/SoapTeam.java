package com.terehov.service_team;

import com.terehov.service_team.model.UserEntity;
import com.terehov.service_team.service.TeamService;
import com.terehov.service_team.service.TeamServiceImpl;

import javax.xml.ws.Endpoint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class SoapTeam {

        private static final Logger LOGGER = Logger.getGlobal();

        private static final String URL = "http://localhost:8080/";

        public static void main(String[] args) {

//            LOGGER.info("Creating WEB server and publishing SOAP endpoint");
//            Endpoint.publish(URL, new TeamServiceImpl());
            TeamServiceImpl teamService = new TeamServiceImpl();
//            System.out.println((teamService.getLectorGroup(teamService.getUserClass(1).getIdClassEntity().getId())).getIdUserEntity().getFirstName());


//    for(UserEntity i: teamService.selectAllUsers()){
//        System.out.println(i);
//    }


    }

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
}
