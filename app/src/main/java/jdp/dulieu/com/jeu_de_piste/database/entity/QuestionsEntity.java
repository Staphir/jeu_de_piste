package jdp.dulieu.com.jeu_de_piste.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions_table")
public class QuestionsEntity {

    @PrimaryKey(autoGenerate = true)
    public Integer question_id;

    @ColumnInfo(name = "intitule")
    @NonNull
    private String intitule;

    @ColumnInfo(name = "reponse")
    @NonNull
    private String reponse;

    @ColumnInfo(name = "indice")
    private String indice;

    @ColumnInfo(name = "typeTeam")
    @NonNull
    private Integer typeTeam;

    @ColumnInfo(name = "nameJeu")
    @NonNull
    private String nameJeu;

    public QuestionsEntity(@NonNull String intitule, @NonNull String reponse, @NonNull Integer typeTeam, @NonNull String nameJeu,  String indice) {
        this.intitule = intitule;
        this.reponse = reponse;
        this.typeTeam = typeTeam;
        this.nameJeu = nameJeu;
        this.indice = indice;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    @NonNull
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(@NonNull String intitule) {
        this.intitule = intitule;
    }

    @NonNull
    public String getReponse() {
        return reponse;
    }

    public void setReponse(@NonNull String reponse) {
        this.reponse = reponse;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    @NonNull
    public Integer getTypeTeam() {
        return typeTeam;
    }

    public void setTypeTeam(@NonNull Integer typeTeam) {
        this.typeTeam = typeTeam;
    }

    @NonNull
    public String getNameJeu() {
        return nameJeu;
    }

    public void setNameJeu(@NonNull String nameJeu) {
        this.nameJeu = nameJeu;
    }
}
