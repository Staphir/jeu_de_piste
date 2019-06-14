package jdp.dulieu.com.jeu_de_piste.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "team_table")
public class TeamEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer team_id;

    @ColumnInfo(name = "nom")
    @NonNull
    private String nom;

    @NonNull
    private Integer num;

    public TeamEntity(@NonNull String nom, @NonNull Integer num){
        this.nom = nom;
        this.num = num;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    @NonNull
    public String getNom() {
        return nom;
    }

    public void setNom(@NonNull String nom) {
        this.nom = nom;
    }

    @NonNull
    public Integer getNum() {
        return num;
    }

    public void setNum(@NonNull Integer num) {
        this.num = num;
    }
}
