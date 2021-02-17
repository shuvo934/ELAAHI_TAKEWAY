package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.CheckBoxList;


import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.SetMeal;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.RiceDIshSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.VeganSideSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.VeganStarterSMAdapter;

public class FullCourseDialogue extends AppCompatActivity {

    public ArrayList<CheckBoxList> veganSideItem;
    public ArrayList<CheckBoxList> veganStarterItem;
    public ArrayList<CheckBoxList> riceDishesItem;

    private RecyclerView veganSideView;
    private VeganSideSMAdapter veganSideAdapter;
    private RecyclerView.LayoutManager veganSidelayout;

    private RecyclerView veganStarterView;
    private VeganStarterSMAdapter veganStarterAdapter;
    private RecyclerView.LayoutManager veganStarterlayout;

    private RecyclerView riceDishView;
    private RiceDIshSMAdapter riceAdapter;
    private RecyclerView.LayoutManager riceLayout;

    private Button ok;

    private String veganSD = "";
    private String veganSS = "";
    private String rSD = "";

    public static int totalSelected;
    public static int riceDishSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_course_dialogue);

        getSupportActionBar().hide();

        ok = findViewById(R.id.submit_all_button);

        totalSelected = 3;
        riceDishSelected = 1;

        veganSideItem = new ArrayList<>();
        veganSideItem.add(new CheckBoxList("Saag Bhaji",false));
        veganSideItem.add(new CheckBoxList("Mixed Veg Bhaji",false));
        veganSideItem.add(new CheckBoxList("Chickpeas & Potato Bhaji",false));
        veganSideItem.add(new CheckBoxList("Bombay Potato",false));
        veganSideItem.add(new CheckBoxList("Saag Sauce",false));
        veganSideItem.add(new CheckBoxList("Saag Aloo ( spinich & potatoes)",false));
        veganSideItem.add(new CheckBoxList("Tarka Dhal ( lentils)",false));
        veganSideItem.add(new CheckBoxList("Spicy Stir Fried Chick Peas",false));
        veganSideItem.add(new CheckBoxList("Garlic Mushroom Bhaji",false));
        veganSideItem.add(new CheckBoxList("Tamarind Potatoes",false));
        veganSideItem.add(new CheckBoxList("Okra & Potato Bhaji",false));
        veganSideItem.add(new CheckBoxList("Okra Bhaji",false));
        veganSideItem.add(new CheckBoxList("Bhindy Baji",false));

        veganSideView = findViewById(R.id.vsd_mc_view);
        veganSideView.setHasFixedSize(true);
        veganSidelayout = new LinearLayoutManager(this);
        veganSideView.setLayoutManager(veganSidelayout);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(veganSideView.getContext(),DividerItemDecoration.VERTICAL);
        veganSideView.addItemDecoration(dividerItemDecoration);
        veganSideAdapter = new VeganSideSMAdapter(this, veganSideItem);
        veganSideView.setAdapter(veganSideAdapter);

        veganStarterItem = new ArrayList<>();
        veganStarterItem.add(new CheckBoxList("Stir Fried Garlic Mushrooms",false));
        veganStarterItem.add(new CheckBoxList("Stirfried Chick peas and Potaoes",false));
        veganStarterItem.add(new CheckBoxList("Vegetable Biraan",false));
        veganStarterItem.add(new CheckBoxList("Spicy Stir-fried Chickpeas",false));
        veganStarterItem.add(new CheckBoxList("Tamarind Potatoes",false));
        veganStarterItem.add(new CheckBoxList("Okra & Potato Bhaji",false));

        veganStarterView = findViewById(R.id.vs_mc_view);
        veganStarterView.setHasFixedSize(true);
        veganStarterlayout = new LinearLayoutManager(this);
        veganStarterView.setLayoutManager(veganStarterlayout);

        DividerItemDecoration dividerItemDecorationNew =
                new DividerItemDecoration(veganStarterView.getContext(),DividerItemDecoration.VERTICAL);
        veganStarterView.addItemDecoration(dividerItemDecorationNew);
        veganStarterAdapter = new VeganStarterSMAdapter(this, veganStarterItem);
        veganStarterView.setAdapter(veganStarterAdapter);

        riceDishesItem = new ArrayList<>();

        riceDishesItem.add(new CheckBoxList("Boiled Rice",false));
        riceDishesItem.add(new CheckBoxList("Pilau Rice",false));
        riceDishesItem.add(new CheckBoxList("Egg Rice",false));
        riceDishesItem.add(new CheckBoxList("Mushroom Rice + 1",false));
        riceDishesItem.add(new CheckBoxList("Vegetable Rice + 1",false));
        riceDishesItem.add(new CheckBoxList("Onion Rice + 1",false));
        riceDishesItem.add(new CheckBoxList("Sweet Coconut Rice + 1",false));
        riceDishesItem.add(new CheckBoxList("Lemon Rice + 1",false));
        riceDishesItem.add(new CheckBoxList("Keema Rice + 1",false));

        riceDishView = findViewById(R.id.sd_mc_view);
        riceDishView.setHasFixedSize(true);
        riceLayout = new LinearLayoutManager(this);
        riceDishView.setLayoutManager(riceLayout);

        DividerItemDecoration dividerItemDecorationNew1 =
                new DividerItemDecoration(riceDishView.getContext(),DividerItemDecoration.VERTICAL);
        riceDishView.addItemDecoration(dividerItemDecorationNew1);
        riceAdapter = new RiceDIshSMAdapter(this, riceDishesItem);
        riceDishView.setAdapter(riceAdapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int j = 0;
                veganSD = "";
                veganSS = "";
                rSD = "";
                String text = SetMeal.starterTitle;
                String ppp = SetMeal.setMealPrice;
                for (int i = 0; i < veganSideItem.size(); i++) {
                    if (veganSideItem.get(i).getCheckedItem() == true) {
                        j++;
                        veganSD += "\n" + "(" + veganSideItem.get(i).getCheckBoxItem() + ")";
                        Log.i("Item vegan sidess", veganSD);
                        Log.i("Item vegan side", veganSideItem.get(i).getCheckBoxItem());
                    }
                }

                for (int i = 0; i < veganStarterItem.size(); i++) {
                    if (veganStarterItem.get(i).getCheckedItem() == true) {
                        j++;
                        veganSS += "\n" + "(" + veganStarterItem.get(i).getCheckBoxItem() + ")";
                        Log.i("star vegan sidess", veganSS);
                        Log.i("star vegan side", veganStarterItem.get(i).getCheckBoxItem());
                    }
                }

                int k = 0;
                for (int i = 0; i < riceDishesItem.size(); i++) {
                    if (riceDishesItem.get(i).getCheckedItem() == true) {
                        k++;
                        rSD += "\n" + "(" + riceDishesItem.get(i).getCheckBoxItem() + ")";
                        Log.i("Item vegan sidess", rSD);
                        Log.i("Item vegan side", riceDishesItem.get(i).getCheckBoxItem());
                    }
                }
                if (veganSS.isEmpty() && j == 3 & k == 1) {
                    if (rSD.contains("1")) {
                        String i = ppp.substring(1);
                        Double p = Double.parseDouble(i);
                        p  = p + 1.0;
                        String prr = String.valueOf("£" + p);
                        CartActivity.mainFoodList.add(new CartItem(text + "\nVegan Side Dish:-" + veganSD + "\nSundries:-" + rSD, "1", prr));
                        Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        CartActivity.mainFoodList.add(new CartItem(text + "\nVegan Side Dish:-" + veganSD + "\nSundries:-" + rSD, "1", ppp));
                        Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                 else if (veganSD.isEmpty() && j == 3 && k == 1) {
                    if (rSD.contains("1")) {
                        String i = ppp.substring(1);
                        Double p = Double.parseDouble(i);
                        p  = p + 1.0;
                        String prr = String.valueOf("£" + p);
                        CartActivity.mainFoodList.add(new CartItem(text + "\nVegan Starter:-" + veganSS + "\nSundries:-" + rSD, "1", prr));
                        Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        CartActivity.mainFoodList.add(new CartItem(text + "\nVegan Starter:-" + veganSS + "\nSundries:-" + rSD, "1", ppp));
                        Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                else if (j == 3 && k == 1) {

                    if (rSD.contains("1")) {
                        String i = ppp.substring(1);
                        Double p = Double.parseDouble(i);
                        p  = p + 1.0;
                        String prr = String.valueOf("£" + p);
                        CartActivity.mainFoodList.add(new CartItem(text + "\nVegan Starter:-" + veganSS + "\nVegan Side Dish:-" + veganSD + "\nSundries:-" + rSD, "1", prr));
                        Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        CartActivity.mainFoodList.add(new CartItem(text + "\nVegan Starter:-" + veganSS + "\nVegan Side Dish:-" + veganSD + "\nSundries:-" + rSD, "1", ppp));
                        Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Please Select Your Meal Properly",Toast.LENGTH_SHORT).show();
                }
                Log.i("total",veganSS);





            }
        });

    }
}