package jdp.dulieu.com.jeu_de_piste.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import jdp.dulieu.com.jeu_de_piste.database.entity.TeamEntity;

@Dao
public interface TeamDao {
    @Insert
    void insert(TeamEntity teamEntity);

    @Delete
    void delete(TeamEntity teamEntity);

    @Query("DELETE FROM team_table")
    void deleteAllTeam();

    @Query("SELECT * FROM team_table")
    LiveData<List<TeamEntity>> getAllTeam();

}
