package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.QuantityDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal.CheFsMeal2;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal.FullCourseDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal.NewYearMeal;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal.ThaiMeal;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.SideDishMainMenuAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.dialogueBOXForItem.ClassicDish;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.dialogueBOXForItem.VeganSIDEDish;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.MainCategoryMenu.food1;

public class SetMeal extends AppCompatActivity implements SetMealAdapter.ClickedStarterItem {

    private RecyclerView setMealView;
    private RecyclerView.LayoutManager setMealLayout;
    public SetMealAdapter setMealAdapter;
    private Button setMealOK;
    public static String starterTitle = "Food";
    public static String setMealPrice = "0";

    public static ArrayList<NormalFoodItem> mySetMealItem;

    public static ArrayList<SubCategoryItemTag> setMmeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_meal);

        getSupportActionBar().setTitle("SET MEAL");
        setMmeal = new ArrayList<>();
        setMmeal = food1;

        setMealOK = findViewById(R.id.set_meal_ok);

//        mySetMealItem = new ArrayList<>();
//        mySetMealItem.add(new NormalFoodItem("Vegan for 1 V", "Appetisers: 2 Popadoms, Onion/Mango Chutney"+"\n"+"Main Courses: Choose any 3 Vegan Starter or Side dishes from the pop-up that appears" + "\n" +"Sundries: Choose any rice from the pop-up","£8.95"));
//        mySetMealItem.add(new NormalFoodItem("Curry Meal for 2", "Appetisers: 2 Popadoms, Onion/Mango Chutney" + "\n" +"Starters: Chicken Tikka, Onion Bhaji" + "\n" + "Main Courses: Chicken Tikka Massala, Chicken Bhuna" + "\n" + "Sundries: 1 Pilau Rice, 1 Nan","£18.50"));
//        mySetMealItem.add(new NormalFoodItem("Tandoori Meal for 2", "Appetisers: 2 Popadoms, Onion/Mango Chutney"+ "\n" + "Starters: Tandoori Chicken, Onion & Garlic Seekh Kebab" + "\n" + "Main Courses: Chicken Tikka Massala, Tandoori Chicken Tikka" + "\n" + "Sundries: Bhuna Sauce, 1 Pilau Rice, 1 Nan","£19.50"));
//        mySetMealItem.add(new NormalFoodItem("Chef's Meal for 2", "Add to your basket then choose any two main meals from the pop-up that appears (seafood £1.50 extra) Comes complete with:-" + "\n" + "Appetisers: 2 Popadoms, Onion/Mango Chutney" + "\n" + "Starters: Chicken Biraan, Mixed Starter" + "\n" + "Sundries: 1 Pilau Rice, 1 Nan","£22.95"));
//        mySetMealItem.add(new NormalFoodItem("Thali Platter", "Add to your basket then choose any two Thali main meals from the pop-up that appears (seafood £1.50 extra) Comes complete with:-" + "\n" + "Appetisers: 2 Popadoms, Chutneys" + "\n" + "Starter: Onion Bhaji" + "\n" + "Side: Bombay Potatoes" + "\n" + "Sundries: 1 Pilau Rice, 1 Plain Nan","£10.95"));
//        mySetMealItem.add(new NormalFoodItem("NEW YEARS Eve", "Set Meal For 1","£9.95"));

        setMealView = findViewById(R.id.set_meal_recycle);
        setMealView.setHasFixedSize(true);
        setMealLayout = new LinearLayoutManager(this);
        setMealView.setLayoutManager(setMealLayout);

        setMealAdapter = new SetMealAdapter(this, setMmeal, this::onStarterItemClicked);
        setMealView.setAdapter(setMealAdapter);

        setMealOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food1.clear();
                finish();
            }
        });
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
                food1.clear();
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

    @Override
    public void onStarterItemClicked(int starterItemPosition) {

        String item = setMmeal.get(starterItemPosition).getfId();
        if (item.equals("335")) {
            setMealPrice = "£"+setMmeal.get(starterItemPosition).getfRate();
            starterTitle = setMmeal.get(starterItemPosition).getfName();

            Intent intent = new Intent(this, FullCourseDialogue.class);
            startActivity(intent);


        }else if (item.equals("394")) {
            setMealPrice = "£"+setMmeal.get(starterItemPosition).getfRate();
            starterTitle = setMmeal.get(starterItemPosition).getfName();

            QuantityDialogue quantityDialogue = new QuantityDialogue();
            quantityDialogue.qunatityValue = 2;
            quantityDialogue.show(getSupportFragmentManager(),"SetQuantity");


        } else if(item.equals("395")) {
            setMealPrice = "£"+setMmeal.get(starterItemPosition).getfRate();
            starterTitle = setMmeal.get(starterItemPosition).getfName();
            QuantityDialogue quantityDialogue = new QuantityDialogue();
            quantityDialogue.qunatityValue = 2;
            quantityDialogue.show(getSupportFragmentManager(),"MealQuantity");
        }else if(item.equals("396")) {
            setMealPrice = "£"+setMmeal.get(starterItemPosition).getfRate();
            starterTitle = setMmeal.get(starterItemPosition).getfName();

            Intent intent1 = new Intent(this, CheFsMeal2.class);
            startActivity(intent1);
        }else if(item.equals("397")) {
            setMealPrice = "£"+setMmeal.get(starterItemPosition).getfRate();
            starterTitle = setMmeal.get(starterItemPosition).getfName();

            Intent intent = new Intent(this, ThaiMeal.class);
            startActivity(intent);
        }else if(item.equals("466")) {
            setMealPrice = "£"+setMmeal.get(starterItemPosition).getfRate();
            starterTitle = setMmeal.get(starterItemPosition).getfName();
            Intent intent = new Intent(this, NewYearMeal.class);
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        food1.clear();
        finish();
    }
}