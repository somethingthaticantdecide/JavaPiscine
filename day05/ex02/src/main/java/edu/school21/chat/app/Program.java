package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void CreateTables(HikariDataSource ds) throws SQLException, IOException {
        String readed = new String(Files.readAllBytes(Paths.get("src/main/resources/schema.sql")));
        PreparedStatement pst ;
        Connection con = ds.getConnection();
        pst = con.prepareStatement(readed);
        pst.executeUpdate();
    }

    public static void FillTheBase(HikariDataSource ds) throws SQLException, IOException {
        String readed = new String(Files.readAllBytes(Paths.get("src/main/resources/data.sql")));
        PreparedStatement pst ;
        Connection con = ds.getConnection();
        pst = con.prepareStatement(readed);
        pst.executeUpdate();
    }

    public static HikariDataSource getds() throws SQLException, IOException {
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.setUsername("postgres");
        config.setPassword("psql");
        config.addDataSourceProperty("databaseName", "jmontagu");
        config.addDataSourceProperty("serverName", "127.0.0.1");
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }

    public static void main (String[] args) throws SQLException, IOException {
        HikariDataSource    ds = getds();

//        CreateTables(ds);
//        FillTheBase(ds);

        User creator = new User(7L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(8L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
        messagesRepository.save(message);
        System.out.println(message.getId()); // ex. id == 11
    }
}
