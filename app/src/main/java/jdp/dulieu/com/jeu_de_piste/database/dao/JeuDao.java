package jdp.dulieu.com.jeu_de_piste.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;

@Dao
public interface JeuDao {
    @Query("SELECT * FROM JeuEntity")
    List<JeuEntity> getAll();

    @Query("SELECT * FROM JeuEntity WHERE jeu_id IN (:jIds)")
    List<JeuEntity> loadAllByIds(int[] jIds);

    @Insert
    void insertAll(JeuEntity... jeux);

    @Delete
    void delete(JeuEntity jeu);

}
