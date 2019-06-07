package jdp.dulieu.com.jeu_de_piste.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;

@Database(entities = {JeuEntity.class,/*autreEntity.class*/}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract JeuEntity jeuEntity();
}
