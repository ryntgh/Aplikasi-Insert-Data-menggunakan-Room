package id.ryan.room2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tb_pesan")
public class Pesan implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pesan")
    private
    Integer id;

    @ColumnInfo(name = "isi_pesan")
    private
    String pesan;

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
