package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.CheckBoxListNew;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.NameWithDesc;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.SetMeal;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.ChefSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.SeaSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.TandooriSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.VeganSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.newYearAdapter.ChefSDNYAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.newYearAdapter.CustomAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.newYearAdapter.SeaFoodNYAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.newYearAdapter.TandooriNYAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.newYearAdapter.VeganNYAdapter;

public class NewYearMeal extends AppCompatActivity {

    public ArrayList<CheckBoxListNew> tandooriSetMeal;
    public ArrayList<CheckBoxListNew> chefSignaatureSetMeal;
    public ArrayList<CheckBoxListNew> spSeaFoodSetMeal;
    public ArrayList<CheckBoxListNew> veganMainSetMeal;

    public ArrayList<NameWithDesc> starterSpinner;
    public ArrayList<NameWithDesc> dessertSpinner;

    private RecyclerView tandooriview;
    private TandooriNYAdapter tandoAdapter;
    private RecyclerView.LayoutManager tandoLayout;

    private RecyclerView chefDishView;
    private ChefSDNYAdapter chefDishAdapter;
    private RecyclerView.LayoutManager chefLayout;

    private RecyclerView seaView;
    private SeaFoodNYAdapter seaSMAdapter;
    private RecyclerView.LayoutManager seaLayout;

    private RecyclerView veganView;
    private VeganNYAdapter veganSMAdapter;
    private RecyclerView.LayoutManager veganLayout;

    private Button ok;

    public static int totalSelected;

    private String tan = "";
    private String chsd = "";
    private String ssf = "";
    private String vsm = "";

    private String startspin = "";
    private String dessSpin = "";

    public Spinner starter;
    public Spinner dess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_year_meal);

        getSupportActionBar().hide();

        totalSelected = 1;
        ok = findViewById(R.id.ok_ch_ny);
        starter = findViewById(R.id.starter_spin);
        dess = findViewById(R.id.dessert_spin);

        tandooriSetMeal = new ArrayList<>();
        tandooriSetMeal.add(new CheckBoxListNew("Tandoori Chicken", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Lamb Tikka", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Tandoori Mix Grill", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Tandoori Mixed Kebab", "Tandoori chicken, chicken tikka, lamb tikka, onion and garlic seek kebab",false));
        tandooriSetMeal.add(new CheckBoxListNew("Chicken tikka", "Grilled with onions, tomatoes & peppers.",false));
        tandooriSetMeal.add(new CheckBoxListNew("Lamb Tikka Shashlik", "Grilled with onions, tomatoes & peppers.",false));
        tandooriSetMeal.add(new CheckBoxListNew("Tandoori Mix Shashlik", "Grilled with onions, tomatoes & peppers.",false));
        tandooriSetMeal.add(new CheckBoxListNew("Chicken Biraan  Medium", "Chicken breast fillet cooked with fried onions and selected spices.",false));
        tandooriSetMeal.add(new CheckBoxListNew("Mumbai Grilled Chilli Chicken  HOT", "Fresh chicken fillets marinated and grilled. Served with stir fried onions and crushed chillies.",false));
        tandooriSetMeal.add(new CheckBoxListNew("Stir Fried Peri Peri Chicken or Lamb Tikka  HOT", "Chicken or lamb stir fried with onions and peppers",false));
        tandooriSetMeal.add(new CheckBoxListNew("Tandoori King Prawns", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Tandoori King Prawn Shashlick", "Grilled with onions, tomatoes & peppers.",false));

        tandooriview = findViewById(R.id.mc_ny_tg_view);
        tandooriview.setHasFixedSize(true);
        tandoLayout = new LinearLayoutManager(this);
        tandooriview.setLayoutManager(tandoLayout);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(tandooriview.getContext(),DividerItemDecoration.VERTICAL);
        tandooriview.addItemDecoration(dividerItemDecoration);
        tandoAdapter = new TandooriNYAdapter(this, tandooriSetMeal);
        tandooriview.setAdapter(tandoAdapter);

        chefSignaatureSetMeal = new ArrayList<>();
        chefSignaatureSetMeal.add(new CheckBoxListNew("Garlic Chicken Tikka Massala  Medium", "Chicken Tikka cooked in garlic with a richly flavoured Massala sauce.",false));
        chefSignaatureSetMeal.add(new CheckBoxListNew("Garlic Lamb Tikka Massala  Medium", "Lamb Tikka cooked in garlic with a richly flavoured Massala sauce.",false));
        chefSignaatureSetMeal.add(new CheckBoxListNew("Chicken Tikka Chilli Massala  HOT", "Cooked with fresh green chillies, ground spices and herbs.",false));
        chefSignaatureSetMeal.add(new CheckBoxListNew("Lamb Tikka Chilli Massala  HOT", "Cooked with fresh green chillies, ground spices and herbs.",false));
        chefSignaatureSetMeal.add(new CheckBoxListNew("Bangla Lamb  Medium", "Fresh lean lamb fillets cooked with bay leaves, cinnamon and garlic using fresh onions and selected spices",false));
        chefSignaatureSetMeal.add(new CheckBoxListNew("Stir Fried Peri Peri Chicken Tikka New  HOT", "Chicken fillets stir fried with onions, peppers & Peri peri sauce",false));
        chefSignaatureSetMeal.add(new CheckBoxListNew("Lamb Nepal  SPICY", "Cooked with chunky onions and peppers in a spicy garlic and chilli Nepalese sauce.",false));
        chefSignaatureSetMeal.add(new CheckBoxListNew("Kashmiri Chicken  MILD", "Marinated chicken cooked in the clay oven and further cooked on a pan with chunky onions, pepper, plum tomatoes and Kashmiri spices. You can choose the strength of this dish (medium or hot) from the pop-up that appears.",false));
        chefSignaatureSetMeal.add(new CheckBoxListNew("Kashmiri Lamb  Medium ", "Marinated chicken cooked in the clay oven and further cooked on a pan with chunky onions, pepper, plum tomatoes and Kashmiri spices. You can choose the strength of this dish (medium or hot) from the pop-up that appears.",false));

        chefDishView = findViewById(R.id.mc_ny_cfsd_view);
        chefDishView.setHasFixedSize(true);
        chefLayout = new LinearLayoutManager(this);
        chefDishView.setLayoutManager(chefLayout);

        DividerItemDecoration dividerItemDecoration1 =
                new DividerItemDecoration(chefDishView.getContext(),DividerItemDecoration.VERTICAL);
        chefDishView.addItemDecoration(dividerItemDecoration1);
        chefDishAdapter = new ChefSDNYAdapter(this, chefSignaatureSetMeal);
        chefDishView.setAdapter(chefDishAdapter);

        spSeaFoodSetMeal = new ArrayList<>();
        spSeaFoodSetMeal.add(new CheckBoxListNew("Garlic Chilli Fish New  HOT", "fresh fish fillet cooked with blended spices,onions, peppers, ginger, garlic and chillies. Served with a choice of curry sauce",false));
        spSeaFoodSetMeal.add(new CheckBoxListNew("Salmon Tikka Mossala New  MILD", "Grilled Salmon fillets cooked in a mild creamy mossalla sauce",false));
        spSeaFoodSetMeal.add(new CheckBoxListNew("King prawn Delight (No Shells) New  Medium", "Fresh fish fillets cooked with onions, tomatoes and blend of Bengali spices.",false));
        spSeaFoodSetMeal.add(new CheckBoxListNew("Bengal Fish Karahi (New)  HOT", "Fresh fish fillets cooked with onions, tomatoes and blend of Bengali spices.",false));
        spSeaFoodSetMeal.add(new CheckBoxListNew("Grilled Peri Peri Tiger King Prawns  Medium", "Grilled Tiger King Prawns stir fried in exotic mix of spices with spring onions, capsicum, fresh garlic, ginger and peri peri sauce. Served on a bed of seasonal vegetables and with a choice of curry sauce",false));
        spSeaFoodSetMeal.add(new CheckBoxListNew("Grilled Peri Peri Tiger King Prawns  HOT", "Grilled Tiger King Prawns stir fried in exotic mix of spices with spring onions, capsicum, fresh garlic, ginger and peri peri sauce. Served on a bed of seasonal vegetables and with a choice of curry sauce",false));
        spSeaFoodSetMeal.add(new CheckBoxListNew("Grilled Fish Fillets  MILD", "Fresh Fish Fillets marinated in a lightly spiced sauce and gently grilled.",false));
        spSeaFoodSetMeal.add(new CheckBoxListNew("Grilled Fish Fillets  Medium", "Fresh Fish Fillets marinated in a lightly spiced sauce and gently grilled",false));
        spSeaFoodSetMeal.add(new CheckBoxListNew("Pan Fried Sea Bass Biraan  MILD", "Sea Bass grilled with selected spices. Served with a choice of curry sauce.",false));

        seaView = findViewById(R.id.mc_ny_ssfd_view);
        seaView.setHasFixedSize(true);
        seaLayout = new LinearLayoutManager(this);
        seaView.setLayoutManager(seaLayout);

        DividerItemDecoration dividerItemDecoration2 =
                new DividerItemDecoration(seaView.getContext(),DividerItemDecoration.VERTICAL);
        seaView.addItemDecoration(dividerItemDecoration2);
        seaSMAdapter = new SeaFoodNYAdapter(this, spSeaFoodSetMeal);
        seaView.setAdapter(seaSMAdapter);

        veganMainSetMeal = new ArrayList<>();
        veganMainSetMeal.add(new CheckBoxListNew("Vegetable Balti  Medium", "",false));
        veganMainSetMeal.add(new CheckBoxListNew("Chickpeas Balti  Medium", "",false));
        veganMainSetMeal.add(new CheckBoxListNew("Vegetable Pathia", "",false));
        veganMainSetMeal.add(new CheckBoxListNew("Vegetable Karahi", "",false));
        veganMainSetMeal.add(new CheckBoxListNew("Vegan Korma", "(HOT includes cocunut milk)",false));
        veganMainSetMeal.add(new CheckBoxListNew("Vegan Mossalla", "(Mild includes cocunut milk)",false));
        veganMainSetMeal.add(new CheckBoxListNew("Vegan Dansak  Medium", "",false));
        veganMainSetMeal.add(new CheckBoxListNew("Vegan Bhuna", "",false));
        veganMainSetMeal.add(new CheckBoxListNew("Vegan Rogan Josh", "",false));
        veganMainSetMeal.add(new CheckBoxListNew("Vegan Garlic Bhuna Medium", "",false));
        veganView = findViewById(R.id.mc_ny_vmd_view);
        veganView.setHasFixedSize(true);
        veganLayout = new LinearLayoutManager(this);
        veganView.setLayoutManager(veganLayout);

        DividerItemDecoration dividerItemDecoration3 =
                new DividerItemDecoration(veganView.getContext(),DividerItemDecoration.VERTICAL);
        veganView.addItemDecoration(dividerItemDecoration3);
        veganSMAdapter = new VeganNYAdapter(this, veganMainSetMeal);
        veganView.setAdapter(veganSMAdapter);

//        List<String> categories = new ArrayList<String>();
        starterSpinner = new ArrayList<>();
        dessertSpinner = new ArrayList<>();

        starterSpinner.add(new NameWithDesc("Onion Bhaji (4)",""));
        starterSpinner.add(new NameWithDesc("Seek Kebab","(served with chips)"));
        starterSpinner.add(new NameWithDesc("Chickpeas & Potato Bhaji",""));
        starterSpinner.add(new NameWithDesc("Mixed Starter","(Onion Bhaji, Samosa, Seek Kebab)"));
        starterSpinner.add(new NameWithDesc("Chicken tikka","(served with chips)"));
//        categories.add("HOT");
//        categories.add("Medium");
//        categories.add("MILD");

        dessertSpinner.add(new NameWithDesc("Gulab Jaman (V) (N)","(Delicate dough balls consisting of milk & flour dipped in sugar syrup, flavoured with cardamon seeds & rose water. Served with fresh cream)"));
        dessertSpinner.add(new NameWithDesc("Vanilla Cheesecake & Coulis",""));
        dessertSpinner.add(new NameWithDesc("Chocolate Fudge Cake",""));

        //ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        CustomAdapter customAdapter = new CustomAdapter(this, starterSpinner);

        starter.setAdapter(customAdapter);

        CustomAdapter customAdapter1 = new CustomAdapter(this, dessertSpinner);

        dess.setAdapter(customAdapter1);


        starter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                startspin = starterSpinner.get(position).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dess.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dessSpin = dessertSpinner.get(position).getName();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = SetMeal.starterTitle;
                String ppp = SetMeal.setMealPrice;
                for (int i = 0; i < tandooriSetMeal.size(); i++) {
                    if (tandooriSetMeal.get(i).getCheckedItem() == true) {
                        tan += "\n" + "(" + tandooriSetMeal.get(i).getCheckBoxItem() + ")";
                        Log.i("Item vegan sidess", tan);
                        Log.i("Item vegan side", tandooriSetMeal.get(i).getCheckBoxItem());
                    }
                }

                for (int i = 0; i < chefSignaatureSetMeal.size(); i++) {
                    if (chefSignaatureSetMeal.get(i).getCheckedItem() == true) {
                        chsd += "\n" + "(" + chefSignaatureSetMeal.get(i).getCheckBoxItem() + ")";
                        Log.i("star vegan sidess", chsd);
                        Log.i("star vegan side", chefSignaatureSetMeal.get(i).getCheckBoxItem());
                    }
                }

                for (int i = 0; i < spSeaFoodSetMeal.size(); i++) {
                    if (spSeaFoodSetMeal.get(i).getCheckedItem() == true) {
                        ssf += "\n" + "(" + spSeaFoodSetMeal.get(i).getCheckBoxItem() + ")";
                        Log.i("Item vegan sidess", ssf);
                        Log.i("Item vegan side", spSeaFoodSetMeal.get(i).getCheckBoxItem());
                    }
                }

                for (int i = 0; i < veganMainSetMeal.size(); i++) {
                    if (veganMainSetMeal.get(i).getCheckedItem() == true) {
                        vsm += "\n" + "(" + veganMainSetMeal.get(i).getCheckBoxItem() + ")";
                        Log.i("Item vegan sidess", vsm);
                        Log.i("Item vegan side", veganMainSetMeal.get(i).getCheckBoxItem());
                    }
                }

                if (tan.isEmpty() && chsd.isEmpty() && vsm.isEmpty() && !ssf.isEmpty()) {

                    String i = ppp.substring(1);
                    Double p = Double.parseDouble(i);
                    p  = p + 1.50;
                    String prr = String.valueOf("£" + p);
                    CartActivity.mainFoodList.add(new CartItem(text + "---"+ "\nStarters--" + "\n(" + startspin + ")\nDesserts--" + "\n(" + dessSpin + ")\nSpecial Seafood Dishes:-" + ssf, "1", prr));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (chsd.isEmpty() && tan.isEmpty() && ssf.isEmpty() && !vsm.isEmpty()) {

                    CartActivity.mainFoodList.add(new CartItem(text + "---"+ "\nStarters--" + "\n(" + startspin + ")\nDesserts--" + "\n(" + dessSpin + ")\nVegan Main Dishes:-" + vsm, "1", ppp));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (vsm.isEmpty() && chsd.isEmpty() &&  ssf.isEmpty() && !tan.isEmpty()) {

                    CartActivity.mainFoodList.add(new CartItem(text + "---"+ "\nStarters--" + "\n(" + startspin + ")\nDesserts--" + "\n(" + dessSpin + ")\nTandoori / Grilled Specials:-" + tan, "1", ppp));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (ssf.isEmpty() && vsm.isEmpty() && tan.isEmpty() && !chsd.isEmpty()) {
                    CartActivity.mainFoodList.add(new CartItem(text + "---"+ "\nStarters--" + "\n(" + startspin + ")\nDesserts--" + "\n(" + dessSpin + ")\nChef’s Signature Dishes:-" + chsd, "1", ppp));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                } else {

                    Toast.makeText(getApplicationContext(),"Please Select Main Course",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

