package jdp.dulieu.com.jeu_de_piste.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     *
     * If you want to populate the database only when the database is created for the 1st time,
     * override RoomDatabase.Callback()#onCreate
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final JeuDao jeuDao;

        PopulateDbAsync(AppRoomDatabase db) {
            jeuDao = db.jeuDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            jeuDao.deleteAll();

            JeuEntity jeu = new JeuEntity("Bordeaux2019");
            jeuDao.insert(jeu);

            return null;
        }
    }

}
