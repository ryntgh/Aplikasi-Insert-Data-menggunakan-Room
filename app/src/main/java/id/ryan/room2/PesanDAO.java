package id.ryan.room2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface PesanDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long inserPesan(Pesan pesan);
}
