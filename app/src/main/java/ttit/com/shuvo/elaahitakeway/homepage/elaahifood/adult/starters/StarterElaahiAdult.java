package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.AdultElaahi;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.SelectedElahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.starterdialogue.MeatDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.starterdialogue.SeaFoodDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.starterdialogue.VeganDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.starterdialogue.VegetableDialogue;

public class StarterElaahiAdult extends AppCompatActivity implements StarterItemAdapter.ClickedStarterItem {

    private TextView startername;
    private RecyclerView starterView;
    private RecyclerView.LayoutManager starterLayout;
    public static StarterItemAdapter starterAdapter;
    public static String starterTitle = "Food";
    private Button starterOK;

    public static ArrayList<StarterItem> myStarterItems;

    public static ArrayList<SelectedElahiItem> selectedMeatItem;
    public static ArrayList<SelectedElahiItem> selectedVegetableItem;
    public static ArrayList<SelectedElahiItem> selectedSeaFoodItem;
    public static ArrayList<SelectedElahiItem> selectedVeganItem;

    public static ArrayList<SelectedElahiItem> totalStarterItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_elaahi_adult);

        startername = findViewById(R.id.titleNames);
        starterOK = findViewById(R.id.starter_ok);
        Intent intent = getIntent();
        startername.setText(intent.getStringExtra("Starter"));

        selectedMeatItem = new ArrayList<>();
        selectedVeganItem = new ArrayList<>();
        selectedSeaFoodItem = new ArrayList<>();
        selectedVegetableItem = new ArrayList<>();

        totalStarterItem = new ArrayList<>();

        myStarterItems = new ArrayList<>();
        myStarterItems.add(new StarterItem("MEAT/POULTRY", "","0"));
        myStarterItems.add(new StarterItem("VEGETABLE V", "","0"));
        myStarterItems.add(new StarterItem("SEAFOOD", "","0"));
        myStarterItems.add(new StarterItem("VEGAN STARTERS", "","0"));




        starterView = findViewById(R.id.starterRecycle);
        starterView.setHasFixedSize(true);
        starterLayout = new LinearLayoutManager(this);
        starterView.setLayoutManager(starterLayout);

        starterAdapter = new StarterItemAdapter(this, myStarterItems, this::onStarterItemClicked);
        starterView.setAdapter(starterAdapter);

       // Log.i("Count:  ", String.valueOf(MeatDialogue.meatCount));
//        myStarterItems.get(0).setFoodCount(String.valueOf(MeatDialogue.meatCount));


        starterOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalStarterItem.clear();
                for (int i = 0; i < selectedMeatItem.size(); i++) {
                    totalStarterItem.add(new SelectedElahiItem(selectedMeatItem.get(i).getMyChosenItem(),selectedMeatItem.get(i).getMyChosenQuantity()));
                }
                for (int i = 0; i < selectedVegetableItem.size(); i++) {
                    totalStarterItem.add(new SelectedElahiItem(selectedVegetableItem.get(i).getMyChosenItem(),selectedVegetableItem.get(i).getMyChosenQuantity()));
                }
                for (int i = 0; i < selectedSeaFoodItem.size(); i++) {
                    totalStarterItem.add(new SelectedElahiItem(selectedSeaFoodItem.get(i).getMyChosenItem(),selectedSeaFoodItem.get(i).getMyChosenQuantity()));
                }
                for (int i = 0; i < selectedVeganItem.size(); i++) {
                    totalStarterItem.add(new SelectedElahiItem(selectedVeganItem.get(i).getMyChosenItem(),selectedVeganItem.get(i).getMyChosenQuantity()));
                }

                AdultElaahi.selectedItemStarteradultElhi.clear();
                int j = 0;
                for (int i = 0; i < totalStarterItem.size(); i++) {
                    AdultElaahi.selectedItemStarteradultElhi.add(new SelectedElahiItem(totalStarterItem.get(i).getMyChosenItem(),totalStarterItem.get(i).getMyChosenQuantity()));
                    j = j + Integer.parseInt(totalStarterItem.get(i).getMyChosenQuantity());
                }

                if (j == 0) {
                    AdultElaahi.startCountadultElhi.setText(String.valueOf(j));
                    AdultElaahi.startCountadultElhi.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    AdultElaahi.startCountadultElhi.setText(String.valueOf(j));
                    AdultElaahi.startCountadultElhi.setBackgroundResource(R.drawable.ic_circle_red);
                }

                finish();
            }
        });
    }



    @Override
    public void onStarterItemClicked(int starterItemPosition) {

        String item = myStarterItems.get(starterItemPosition).getTypeOfFood();
        if (item.equals("MEAT/POULTRY")) {
            starterTitle = "MEAT/POULTRY";
            MeatDialogue meatDialogue = new MeatDialogue();
            meatDialogue.show(getSupportFragmentManager(),"MEAT");
            Log.i("1", "MEAT/POULTRY");
        }else if (item.equals("VEGETABLE V")) {
            starterTitle = "VEGETABLE V";
            VegetableDialogue vegetableDialogue = new VegetableDialogue();
            vegetableDialogue.show(getSupportFragmentManager(),"Vegetable");
            Log.i("2", "Vegetable");
        }else if (item.equals("SEAFOOD")) {
            starterTitle = "SEAFOOD";
            SeaFoodDialogue seaFoodDialogue = new SeaFoodDialogue();
            seaFoodDialogue.show(getSupportFragmentManager(),"Sea Food");
            Log.i("3", "SEAFOOD");
        }else if (item.equals("VEGAN STARTERS")) {
            starterTitle = "VEGAN STARTERS";
            VeganDialogue veganDialogue = new VeganDialogue();
            veganDialogue.show(getSupportFragmentManager(),"Vegan");
            Log.i("4", "VEGAN STARTERS");
        }

    }
}