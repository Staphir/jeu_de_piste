package jdp.dulieu.com.jeu_de_piste.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import jdp.dulieu.com.jeu_de_piste.database.JdpRepository;
import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;

public class TeamViewModel extends AndroidViewModel {

    private JdpRepository jdpRepository;
    private LiveData<List<JeuEntity>> alljeux;

    public TeamViewModel(Application application){
        super(application);
        jdpRepository = new JdpRepository(application);
        alljeux = jdpRepository.getAllJeux();
    }

    public LiveData<List<JeuEntity>> getAlljeux(){
        return alljeux;
    }


}
