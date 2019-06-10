package jdp.dulieu.com.jeu_de_piste.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import jdp.dulieu.com.jeu_de_piste.database.JdpRepository;
import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;

public class JeuViewModel extends AndroidViewModel {

    private JdpRepository jdpRepository;
    private LiveData<List<JeuEntity>> alljeux;

    public JeuViewModel (Application application) {
        super(application);
        jdpRepository = new JdpRepository(application);
        alljeux = jdpRepository.getAllJeux();
    }

    public LiveData<List<JeuEntity>> getAllJeux() {
        return alljeux;
    }

    void insert(JeuEntity jeu) {
        jdpRepository.insert(jeu);
    }
}
