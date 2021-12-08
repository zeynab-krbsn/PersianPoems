package com.example.persianpoems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Items> items;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        setPoemInfo();
        setAdapter();

        bottomNavigationView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setSelectedItemId(R.id.item_home);


    }

    private void setAdapter() {

        RecyclerAdapter adapter = new RecyclerAdapter(getApplicationContext() ,items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setPoemInfo() {

        String[] poet = new String[6];
        poet[0]="قیصر امین پور";
        poet[1]="صائب تبریزی";
        poet[2]="هوشنگ ابتهاج";
        poet[3]="سعدی";
        poet[4]="مولوی";
        poet[5]="سعید بیابانکی";

        String[] poem = new String[6];
        poem[0]="همۀ حرف دلم با تو همین است که دوست\nچه کـنـم؟ حرف دلـم را بـزنـم یـا نـزنـم؟";
        poem[1]="از صبح پـردوه سـوز، خدایـا نـگاه دار\nاین رازها که ما به دل شب سپرده ایم";
        poem[2]="نازنین آمد و دستی به دل مـا زد و رفت\nپرده ی خلوت این غمکده بالا زد و رفت";
        poem[3]="خلایق در تو حیرانند و جای حیرتست الحق\nکه مه را بر زمین بینند و مه بر آسمان باشد";
        poem[4]="ما را نه غم دوزخ و نه حرص بهشت است\nبـردار ز رخ پـرده که مـشـتـاق لقـائیـم";
        poem[5]="ای آنکه دوست دارمت اما ندارمت\nبر سینه می فشارمت اما ندارمـت";

        String[] genre = new String[6];
        genre[0]="عاشقانه";
        genre[1]="عارفانه";
        genre[2]="غمگین";
        genre[3]="عاشقانه";
        genre[4]="عارفانه";
        genre[5]="غمگین";

        items.add(new Items( poem[0],poet[0],genre[0]));
        items.add(new Items( poem[1],poet[1],genre[1]));
        items.add(new Items( poem[2],poet[2],genre[2]));
        items.add(new Items( poem[3],poet[3],genre[3]));
        items.add(new Items( poem[4],poet[4],genre[4]));
        items.add(new Items( poem[5],poet[5],genre[5]));
    }
}