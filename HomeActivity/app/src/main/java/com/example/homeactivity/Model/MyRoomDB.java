package com.example.homeactivity.Model;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.RoomDatabase;

import java.util.List;

public class MyRoomDB {
    @Entity
    public class Trips {
        @PrimaryKey
        public int id;
        @ColumnInfo(name = "trip_name")
        public String tripName;
        @ColumnInfo(name = "st_pt")
        public String stPoint;
        @ColumnInfo(name = "end_pt")
        public String endPoint;
        @ColumnInfo(name = "fk_notes_id")
        public int tripNotes;
        @ColumnInfo(name = "trip_status")
        public int tripStatus;
        @ColumnInfo(name = "trip_type")
        public int tripType;

    }

    @Dao
    public interface TripDao {
        @Query("SELECT * FROM Trips")
        List<Trips> getAll();
//
//        @Query("SELECT * FROM Trips WHERE id IN (:tripIds)")
//        List<Trips> loadAllByIds(int[] tripIds);
//
//        @Query("SELECT * FROM Trips WHERE trip_name LIKE :name LIMIT 1")
//        Trips findByName(String name);

        @Insert
        void insertAll(Trips... trips);

        @Delete
        void delete(Trips trips);
    }
    @Database(entities = {Trips.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract TripDao tripDao();
    }


}
