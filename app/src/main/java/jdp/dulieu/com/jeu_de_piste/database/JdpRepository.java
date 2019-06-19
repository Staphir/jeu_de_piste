package jdp.dulieu.com.jeu_de_piste.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import jdp.dulieu.com.jeu_de_piste.database.dao.JeuDao;
import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;

public class JdpRepository {

    private JeuDao jeuDao;
    private LiveData<List<JeuEntity>> allJeux;

    public JdpRepository(Application application) {
        AppRoomDatabase db = AppRoomDatabase.getAppDatabase(application);
        jeuDao = db.jeuDao();
        allJeux = jeuDao.getAllJeux();
    }

    public LiveData<List<JeuEntity>> getAllJeux() {
        return allJeux;
    }

//    public List<JeuEntity> getJeuxEntity() {
//        return
//    }

    public void insert(JeuEntity jeu){
        new insertAsyncTask(jeuDao).execute(jeu);
    }

    private static class insertAsyncTask extends AsyncTask<JeuEntity, Void, Void> {

        private JeuDao mAsyncTaskDao;

        insertAsyncTask(JeuDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final JeuEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
