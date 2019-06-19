package jdp.dulieu.com.jeu_de_piste.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;

@Dao
public interface JeuDao {
    @Query("SELECT * FROM jeu_table")
    LiveData<List<JeuEntity>> getAllJeux();

    @Query("SELECT * FROM jeu_table WHERE jeu_id IN (:jIds)")
    LiveData<List<JeuEntity>> loadAllByIds(int[] jIds);

    @Insert
    void insertAll(JeuEntity... jeux);

    @Insert
    void insert(JeuEntity jeu);

    @Delete
    void delete(JeuEntity jeu);

    @Query("DELETE FROM jeu_table")
    void deleteAllJeu();

}
