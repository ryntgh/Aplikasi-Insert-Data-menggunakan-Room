package id.ryan.room2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextInputEditText GetPesan;
    Button Simpan;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetPesan = findViewById(R.id.pesan);

        Simpan = findViewById(R.id.simpan);
        Simpan.setOnClickListener(this);

        //Inisialisasi dan memanggil Room Database
        database = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "dbPesan")
                .build();
    }

    //Menjalankan method Insert Data
    @SuppressLint("StaticFieldLeak")
    private void insertData(final Pesan pesan){
        new AsyncTask<Void, Void, Long>() {
            @Override
            protected Long doInBackground(Void... voids) {
                //Menjalankan proses insert data
                return database.pesanDAO().inserPesan(pesan);
            }

            @Override
            protected void onPostExecute(Long status) {
                //Menandakan bahwa data berhasil disimpan
                Toast.makeText(MainActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Status Row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.simpan:
                //Mengecek input pesan
                if(GetPesan.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Masukkan Pesan", Toast.LENGTH_SHORT).show();
                }else {
                    //Membuat Instance/Objek Dari Class Entity Mahasisiwaa
                    Pesan data = new Pesan();

                    //Memasukan data yang diinputkan user pada database
                    data.setPesan(GetPesan.getText().toString());
                    insertData(data);
                    GetPesan.setText("");
                }
                break;
        }
    }
}
