package id.ryan.room2;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pesan.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //Untuk mengakses Database menggunakan method abstract
    public abstract PesanDAO pesanDAO();
}
