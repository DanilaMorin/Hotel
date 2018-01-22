package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.RoomDAO;
import com.netcracker.DAO.entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 12345 on 18.01.2018.
 */
public class RoomDAOImpl implements RoomDAO {

    @Override
    public int getRoomFree() throws SQLException, ParseException {

        Connection connection =JDBCConfig.getConnection();
        connection.createStatement();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT count(rooms.id_room)\n" +
                "  FROM public.rooms LEFT join public.reserv as res on rooms.id_room = res.id_room and rooms.id_corps = res.id_corp \n" +
                "  where  NOT (res.arrival_date < ? and ? < res.date_of_departure) or (res.id is null);\n" +
                "  ;");
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        Date date = new Date();
        java.sql.Date date1= new java.sql.Date( format.parse(format.format(date)).getTime());

        //java.sql.Date date1 = new java.sql.Date(date.getDate());
        preparedStatement.setDate(1, date1);
        preparedStatement.setDate(2, date1);
        ResultSet result2 = preparedStatement.executeQuery();
        int cout = 0;
        System.out.println("Выводим PreparedStatement");
        while (result2.next()) {
            cout = result2.getInt(1);

        }

        if (connection != null) {
            connection.close();
            System.out.println("Cоединение закрыто");
        }
        return cout;
    }

    @Override
    public List<Room> getListRoom(String  date) throws SQLException, ParseException {
        List<Room> list = new ArrayList<>();
        int id_room = 0;
        int id_corps = 0;
        int number_of_people = 0;
        int floor = 0;
        Connection connection =JDBCConfig.getConnection();
        connection.createStatement();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("SELECT rooms.id_room, id_corps, number_of_people, floor\n" +
                "  FROM public.rooms LEFT join public.reserv as res on rooms.id_room = res.id_room and rooms.id_corps = res.id_corp \n" +
                "  where  NOT (res.arrival_date < ? and ? < res.date_of_departure) or (res.id is null);\n" +
                "  ;");

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        java.sql.Date date1= new java.sql.Date( format.parse(date).getTime());
        preparedStatement.setDate(1, date1);
        preparedStatement.setDate(2, date1);
        ResultSet result2 = preparedStatement.executeQuery();
        System.out.println("Выводим PreparedStatement");
        while (result2.next()) {
            id_room = result2.getInt("id_room");
            id_corps = result2.getInt("id_corps");
            number_of_people = result2.getInt("number_of_people");
            floor = result2.getInt("floor");

            Room room = new Room(id_room,id_corps,number_of_people,floor);
            list.add(room);
        }

        if (connection != null) {
            connection.close();
            System.out.println("Cоединение закрыто");
        }

        return list;
    }
}
