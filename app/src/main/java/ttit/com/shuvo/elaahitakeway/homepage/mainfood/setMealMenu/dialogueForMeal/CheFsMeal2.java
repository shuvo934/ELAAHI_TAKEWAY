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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.ElaahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.CheckBoxList;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.CheckBoxListNew;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.SetMeal;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.ChefSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.RiceDIshSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.SeaSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.TandooriSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.VeganSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.VeganSideSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.VeganStarterSMAdapter;

public class CheFsMeal2 extends AppCompatActivity {

    public ArrayList<CheckBoxListNew> tandooriSetMeal;
    public ArrayList<CheckBoxListNew> chefSignaatureSetMeal;
    public ArrayList<CheckBoxListNew> spSeaFoodSetMeal;
    public ArrayList<CheckBoxListNew> veganMainSetMeal;

    private RecyclerView tandooriview;
    private TandooriSMAdapter tandoAdapter;
    private RecyclerView.LayoutManager tandoLayout;

    private RecyclerView chefDishView;
    private ChefSMAdapter chefDishAdapter;
    private RecyclerView.LayoutManager chefLayout;

    private RecyclerView seaView;
    private SeaSMAdapter seaSMAdapter;
    private RecyclerView.LayoutManager seaLayout;

    private RecyclerView veganView;
    private VeganSMAdapter veganSMAdapter;
    private RecyclerView.LayoutManager veganLayout;

    private Button ok;

    public static int totalSelected;

    private String tan = "";
    private String chsd = "";
    private String ssf = "";
    private String vsm = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_che_fs_meal2);

        getSupportActionBar().hide();

        totalSelected = 2;
        ok = findViewById(R.id.ok_ch_meal2);

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

        tandooriview = findViewById(R.id.mc_sm_tg_view);
        tandooriview.setHasFixedSize(true);
        tandoLayout = new LinearLayoutManager(this);
        tandooriview.setLayoutManager(tandoLayout);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(tandooriview.getContext(),DividerItemDecoration.VERTICAL);
        tandooriview.addItemDecoration(dividerItemDecoration);
        tandoAdapter = new TandooriSMAdapter(this, tandooriSetMeal);
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

        chefDishView = findViewById(R.id.mc_sm_cfsd_view);
        chefDishView.setHasFixedSize(true);
        chefLayout = new LinearLayoutManager(this);
        chefDishView.setLayoutManager(chefLayout);

        DividerItemDecoration dividerItemDecoration1 =
                new DividerItemDecoration(chefDishView.getContext(),DividerItemDecoration.VERTICAL);
        chefDishView.addItemDecoration(dividerItemDecoration1);
        chefDishAdapter = new ChefSMAdapter(this, chefSignaatureSetMeal);
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

        seaView = findViewById(R.id.mc_sm_ssfd_view);
        seaView.setHasFixedSize(true);
        seaLayout = new LinearLayoutManager(this);
        seaView.setLayoutManager(seaLayout);

        DividerItemDecoration dividerItemDecoration2 =
                new DividerItemDecoration(seaView.getContext(),DividerItemDecoration.VERTICAL);
        seaView.addItemDecoration(dividerItemDecoration2);
        seaSMAdapter = new SeaSMAdapter(this, spSeaFoodSetMeal);
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
        veganView = findViewById(R.id.mc_sm_vmd_view);
        veganView.setHasFixedSize(true);
        veganLayout = new LinearLayoutManager(this);
        veganView.setLayoutManager(veganLayout);

        DividerItemDecoration dividerItemDecoration3 =
                new DividerItemDecoration(veganView.getContext(),DividerItemDecoration.VERTICAL);
        veganView.addItemDecoration(dividerItemDecoration3);
        veganSMAdapter = new VeganSMAdapter(this, veganMainSetMeal);
        veganView.setAdapter(veganSMAdapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = SetMeal.starterTitle;
                String ppp = SetMeal.setMealPrice;
                int j = 0;
                tan = "";
                chsd = "";
                ssf = "";
                vsm = "";
                for (int i = 0; i < tandooriSetMeal.size(); i++) {
                    if (tandooriSetMeal.get(i).getCheckedItem() == true) {
                        j++;
                        tan += "\n" + "(" +tandooriSetMeal.get(i).getCheckBoxItem() + ")";
                        Log.i("Item vegan sidess", tan);
                        Log.i("Item vegan side", tandooriSetMeal.get(i).getCheckBoxItem());
                    }
                }

                for (int i = 0; i < chefSignaatureSetMeal.size(); i++) {
                    if (chefSignaatureSetMeal.get(i).getCheckedItem() == true) {
                        j++;
                        chsd += "\n" + "(" + chefSignaatureSetMeal.get(i).getCheckBoxItem() + ")";
                        Log.i("star vegan sidess", chsd);
                        Log.i("star vegan side", chefSignaatureSetMeal.get(i).getCheckBoxItem());
                    }
                }

                for (int i = 0; i < spSeaFoodSetMeal.size(); i++) {
                    if (spSeaFoodSetMeal.get(i).getCheckedItem() == true) {
                        j++;
                        ssf += "\n" + "(" + spSeaFoodSetMeal.get(i).getCheckBoxItem() + ")";
                        Log.i("Item vegan sidess", ssf);
                        Log.i("Item vegan side", spSeaFoodSetMeal.get(i).getCheckBoxItem());
                    }
                }

                for (int i = 0; i < veganMainSetMeal.size(); i++) {
                    if (veganMainSetMeal.get(i).getCheckedItem() == true) {
                        j++;
                        vsm += "\n" + "(" + veganMainSetMeal.get(i).getCheckBoxItem() + ")";
                        Log.i("Item vegan sidess", vsm);
                        Log.i("Item vegan side", veganMainSetMeal.get(i).getCheckBoxItem());
                    }
                }

                if (!tan.isEmpty() && j == 2 && ssf.isEmpty() && vsm.isEmpty() && chsd.isEmpty()) {

                    CartActivity.mainFoodList.add(new CartItem(text + "\nTandoori / Grilled Specials:-" + tan , "1", ppp));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (!chsd.isEmpty() && j == 2 && ssf.isEmpty() && vsm.isEmpty() && tan.isEmpty()) {
                    CartActivity.mainFoodList.add(new CartItem(text + "\nChef’s Signature Dishes:-" + chsd, "1", ppp));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (!vsm.isEmpty() && j == 2 && ssf.isEmpty() && tan.isEmpty() && chsd.isEmpty()) {

                    CartActivity.mainFoodList.add(new CartItem(text + "\nVegan Main Dishes:-" + vsm, "1", ppp));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (!ssf.isEmpty() && j == 2 && tan.isEmpty() && vsm.isEmpty() && chsd.isEmpty()) {

                    String i = ppp.substring(1);
                    Double p = Double.parseDouble(i);
                    p  = p + 1.50;
                    String prr = String.valueOf("£" + p);
                    CartActivity.mainFoodList.add(new CartItem(text + "\nSpecial Seafood Dishes:-" + ssf, "1", prr));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (!tan.isEmpty() && !chsd.isEmpty()){

                    CartActivity.mainFoodList.add(new CartItem(text + "\nTandoori / Grilled Specials:-" + tan + "\nChef’s Signature Dishes:-" + chsd, "1", ppp));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (!tan.isEmpty() && !vsm.isEmpty()) {
                    CartActivity.mainFoodList.add(new CartItem(text + "\nTandoori / Grilled Specials:-" + tan + "\nVegan Main Dishes:-" + vsm, "1", ppp));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (!tan.isEmpty() && !ssf.isEmpty()) {
                    String i = ppp.substring(1);
                    Double p = Double.parseDouble(i);
                    p  = p + 1.50;
                    String prr = String.valueOf("£" + p);
                    CartActivity.mainFoodList.add(new CartItem(text + "\nTandoori / Grilled Specials:-" + tan + "\nSpecial Seafood Dishes:-" + ssf, "1", prr));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (!chsd.isEmpty() && !vsm.isEmpty()) {
                    CartActivity.mainFoodList.add(new CartItem(text + "\nChef’s Signature Dishes:-" + chsd + "\nVegan Main Dishes:-" + vsm, "1", ppp));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (!chsd.isEmpty() && !ssf.isEmpty()) {
                    String i = ppp.substring(1);
                    Double p = Double.parseDouble(i);
                    p  = p + 1.50;
                    String prr = String.valueOf("£" + p);
                    CartActivity.mainFoodList.add(new CartItem(text + "\nChef’s Signature Dishes:-" + chsd + "\nSpecial Seafood Dishes:-" + ssf, "1", prr));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (!ssf.isEmpty() && !vsm.isEmpty()) {
                    String i = ppp.substring(1);
                    Double p = Double.parseDouble(i);
                    p  = p + 1.50;
                    String prr = String.valueOf("£" + p);
                    CartActivity.mainFoodList.add(new CartItem(text + "\nSpecial Seafood Dishes:-" + ssf + "\nVegan Main Dishes:-" + vsm, "1", prr));
                    Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),"Please Select Your Meal Properly",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}