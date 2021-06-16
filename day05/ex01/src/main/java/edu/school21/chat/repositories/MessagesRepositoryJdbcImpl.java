package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.awt.event.MouseWheelEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final HikariDataSource dataSource;

    public MessagesRepositoryJdbcImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    private List<Chatroom>  getCreatedRooms(long author, Connection connection) throws SQLException {
        List<Chatroom> createdRooms = new ArrayList();

        Statement statement2 = connection.createStatement();
        ResultSet room_query = statement2.executeQuery("SELECT * FROM users WHERE id = " + author + ";");
        if (room_query.next()) {
            createdRooms.add(new Chatroom(room_query.getLong("id"),
                    room_query.getString("id"),
                    null,
                    null));
        }
        return createdRooms;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        long            author = 0L;
        long            room = 0L;
        String          text = null;
        Timestamp       date = null;
        User            user = null;
        Chatroom        chatroom = null;
        Message         message_obj = null;

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();
        ResultSet message_query = statement.executeQuery("SELECT * FROM messages WHERE id = " + id + ";");
        if (message_query.next()) {
            author = message_query.getLong("author");
            room = message_query.getLong("room");
            text = message_query.getString("text");
            date = message_query.getTimestamp("date");

            Statement statement2 = connection.createStatement();
            ResultSet author_query = statement2.executeQuery("SELECT * FROM users WHERE id = " + author + ";");
            if (author_query.next()) {
                user = new User(author, author_query.getString("login"), author_query.getString("password"), null, null);
            }

            Statement statement3 = connection.createStatement();
            ResultSet room_query = statement3.executeQuery("SELECT * FROM rooms WHERE id = " + room + ";");
            if (room_query.next()) {
                chatroom =  new Chatroom(room, room_query.getString("name"), null, null);
            }

            message_obj = new Message(id, user, chatroom, text, date);
            connection.close();
            return Optional.of(message_obj);
        }
        return Optional.empty();
    }
}
