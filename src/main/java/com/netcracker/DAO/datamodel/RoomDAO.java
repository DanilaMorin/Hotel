package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Room;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by user on 15.01.2018.
 */
public interface RoomDAO {
    int getRoomFree() throws SQLException, ParseException;
    List<Room> getListRoom(String date) throws SQLException, ParseException;
}
