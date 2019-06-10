package jdp.dulieu.com.jeu_de_piste.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class QuestionsEntity {

    @PrimaryKey(autoGenerate = true)
    public int question_id;

}
