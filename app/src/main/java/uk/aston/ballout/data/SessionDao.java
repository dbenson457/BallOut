package uk.aston.ballout.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SessionDao {
    @Query("SELECT * FROM session")
    List<Session> getAll();

    @Query("SELECT * FROM session WHERE sid IN (:sessionIds)")
    List<Session> loadAllByIds(int[] sessionIds);

    @Query("SELECT * FROM Session WHERE park_name LIKE :park_name")
    Session findByName(String park_name);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Session session);

    @Insert
    void insertAll(Session... sessions);

    @Delete
    void delete(Session session);

    @Query("DELETE FROM Session")
    void deleteAll();
}