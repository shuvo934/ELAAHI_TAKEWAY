package ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItemAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.starterdialogue.MeatDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.starterdialogue.SeaFoodDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.starterdialogue.VeganDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.starterdialogue.VegetableDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.dialogueForItem.MeatPoultry;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.dialogueForItem.SeaFood;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.dialogueForItem.VeganStarter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.dialogueForItem.VegetableV;

public class StarterMainMenu extends AppCompatActivity implements StarterMainMenuAdapter.ClickedStarterItem{


    private RecyclerView starterView;
    private RecyclerView.LayoutManager starterLayout;
    public StarterMainMenuAdapter starterAdapter;
    private Button starterOK;
    public static String starterTitle = "Food";

    public static ArrayList<StarterItem> myStarterItemsMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_main_menu);
        getSupportActionBar().setTitle("STARTERS");

        starterOK = findViewById(R.id.starter_ok_mainMenu);

        myStarterItemsMainMenu = new ArrayList<>();
        myStarterItemsMainMenu.add(new StarterItem("MEAT/POULTRY", "","0"));
        myStarterItemsMainMenu.add(new StarterItem("VEGETABLE V", "","0"));
        myStarterItemsMainMenu.add(new StarterItem("SEAFOOD", "","0"));
        myStarterItemsMainMenu.add(new StarterItem("VEGAN STARTERS", "","0"));

        starterView = findViewById(R.id.starterRecycle_mainMenu);
        starterView.setHasFixedSize(true);
        starterLayout = new LinearLayoutManager(this);
        starterView.setLayoutManager(starterLayout);

        starterAdapter = new StarterMainMenuAdapter(this, myStarterItemsMainMenu, this::onStarterItemClicked);
        starterView.setAdapter(starterAdapter);

        starterOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onStarterItemClicked(int starterItemPosition) {

        String item = myStarterItemsMainMenu.get(starterItemPosition).getTypeOfFood();
        if (item.equals("MEAT/POULTRY")) {
            starterTitle = "MEAT/POULTRY";
            MeatPoultry meatPoultry = new MeatPoultry();
            meatPoultry.show(getSupportFragmentManager(),"MeatPoultry");
            Log.i("1", "MEAT/POULTRY");
        }else if (item.equals("VEGETABLE V")) {
            starterTitle = "VEGETABLE V";
            VegetableV vegetableV = new VegetableV();
            vegetableV.show(getSupportFragmentManager(),"VVV");
            Log.i("2", "Vegetable");
        }else if (item.equals("SEAFOOD")) {
            starterTitle = "SEAFOOD";
            SeaFood seaFood = new SeaFood();
            seaFood.show(getSupportFragmentManager(),"Sea");
            Log.i("3", "SEAFOOD");
        }else if (item.equals("VEGAN STARTERS")) {
            starterTitle = "VEGAN STARTERS";
            VeganStarter veganStarter = new VeganStarter();
            veganStarter.show(getSupportFragmentManager(),"VVVV");
            Log.i("4", "VEGAN STARTERS");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "USER", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "CART", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.subitem1:
                Toast.makeText(getApplicationContext(), "Sub Item 1 selected", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.subitem2:
                Toast.makeText(getApplicationContext(), "Sub Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }


    }
}