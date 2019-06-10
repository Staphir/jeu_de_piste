package jdp.dulieu.com.jeu_de_piste.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import jdp.dulieu.com.jeu_de_piste.database.dao.JeuDao;
import jdp.dulieu.com.jeu_de_piste.database.dao.QuestionsDao;
import jdp.dulieu.com.jeu_de_piste.database.dao.TeamDao;
import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;
import jdp.dulieu.com.jeu_de_piste.database.entity.QuestionsEntity;
import jdp.dulieu.com.jeu_de_piste.database.entity.TeamEntity;

@Database(entities = {JeuEntity.class, TeamEntity.class, QuestionsEntity.class}, version = 1/*, exportSchema = false*/)
public abstract class AppRoomDatabase extends RoomDatabase {

    public abstract JeuDao jeuDao();
    public abstract TeamDao teamDao();
    public abstract QuestionsDao questionsDao();

    private static volatile AppRoomDatabase INSTANCE;

    static AppRoomDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppRoomDatabase.class, "jdp_database")
//                     Wipes and rebuilds instead of migrating if no Migration object.
//                     Migration is not part of this codelab.
                            .fallbackToDestructiveMigration()
//                    .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}
