package com.example.utsika;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView Sayuran,Latin,Vitamin,Vitamin1,Vitamin2,Vitamin3;
    private List<Sayuran>sayurans;
    private ImageView Gambar;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sayuran=(TextView)findViewById(R.id.textView);
        Latin=(TextView)findViewById(R.id.txt_latin);
        Vitamin=(TextView)findViewById(R.id.txt_vitamin);
        Vitamin1=(TextView)findViewById(R.id.txt_vitamin1);
        Vitamin2=(TextView)findViewById(R.id.txt_vitamin2);
        Vitamin3=(TextView)findViewById(R.id.txt_vitamin3);
        Gambar=(ImageView)findViewById(R.id.img_Gambar);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Sayuran>>call=apiInterface.getSayuran2();
        call.enqueue(new Callback<List<com.example.utsika.Sayuran>>() {
            @Override
            public void onResponse(Call<List<com.example.utsika.Sayuran>> call, Response<List<com.example.utsika.Sayuran>> response) {
                sayurans=response.body();
                Sayuran.setText(sayurans.get(0).getSayuran());
                Latin.setText(sayurans.get(0).getLatin());

                List<String>vitamin=sayurans.get(0).getVitamin();
                Vitamin.setText(vitamin.get(0));
                Vitamin1.setText(vitamin.get(1));
                Vitamin2.setText(vitamin.get(2));
                Vitamin3.setText(vitamin.get(3));

                Picasso.with(MainActivity.this).load(sayurans.get(0).getGambar()).into(Gambar);
            }

            @Override
            public void onFailure(Call<List<com.example.utsika.Sayuran>> call, Throwable t) {

            }
        });
    }
}
