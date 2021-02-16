package ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu;

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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.MainCourseItemAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.BiriyaniDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.ChefSignatureDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.ClassicDishDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.MasalaDishesDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.SpecialSeaFoodDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.TandooriDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.VeganMainDishDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.VeganPlatterDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.dialogueForMenu.BiriyaniDishes;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.dialogueForMenu.CheFDishess;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.dialogueForMenu.ClassicDishes;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.dialogueForMenu.MassalaDishes;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.dialogueForMenu.SeaFoodDishess;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.dialogueForMenu.Tandoori;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.dialogueForMenu.VeganMainDishes;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.dialogueForMenu.VeganPlatter;

public class MainCourseMenu extends AppCompatActivity implements MainCourseMenuAdapter.ClickedStarterItem{

    private TextView mainCourseName;
    private RecyclerView mainCourseView;
    private RecyclerView.LayoutManager mainCourseLayout;
    public static MainCourseMenuAdapter mainCourseAdapter;
    public static String mainCourseHeader = "Name";
    private Button okBtn;

    public static ArrayList<StarterItem> myMCItemsMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course_menu);
        getSupportActionBar().setTitle("MAIN COURSES");

        okBtn = findViewById(R.id.ok_mainCourse_main);

        myMCItemsMain = new ArrayList<>();
        myMCItemsMain.add(new StarterItem("TANDOORI / GRILLED SPECIALS","These dishes are marinated in yoghurt with different oriental spices then cooked in a clay oven. Tandoori dishes are served with salad & choice of curry sauce","0"));
        myMCItemsMain.add(new StarterItem("CHEF’S SIGNATURE DISHES","","0"));
        myMCItemsMain.add(new StarterItem("SPECIAL SEAFOOD DISHES","","0"));
        myMCItemsMain.add(new StarterItem("MASSALA DISHES","(Medium) Tender pieces of meat first cooked in a Tandoori clay oven and then cooked in a very special sauce with fresh cream","0"));
        myMCItemsMain.add(new StarterItem("BIRYANI DISHES","Stir fried with onions and mixed spices then cooked with rice and coriander. Served with Vegetable Sauce","0"));
        myMCItemsMain.add(new StarterItem("VEGAN MAIN DISHES","You can choose your vegetable accompaniment on the pop-up that appears (Seasonal Vegetables, Chickpeas, Mushroom & Peas)","0"));
        myMCItemsMain.add(new StarterItem("CLASSIC DISH","","0"));
        myMCItemsMain.add(new StarterItem("Vegan Platter","Choose any 3 Starters or Side Dishes","0"));

        mainCourseView = findViewById(R.id.main_courseRecycle_main);
        mainCourseView.setHasFixedSize(true);
        mainCourseLayout = new LinearLayoutManager(this);
        mainCourseView.setLayoutManager(mainCourseLayout);

        mainCourseAdapter = new MainCourseMenuAdapter(this, myMCItemsMain, this::onStarterItemClicked);
        mainCourseView.setAdapter(mainCourseAdapter);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onStarterItemClicked(int starterItemPosition) {

        String item = myMCItemsMain.get(starterItemPosition).getTypeOfFood();
        Log.i("Item : ", item);
        if (item.equals("TANDOORI / GRILLED SPECIALS")) {
            mainCourseHeader = "TANDOORI / GRILLED SPECIALS";

            Tandoori tandoori = new Tandoori();
            tandoori.show(getSupportFragmentManager(),"tannn");
        }else if (item.equals("CHEF’S SIGNATURE DISHES")) {
            mainCourseHeader = "CHEF’S SIGNATURE DISHES";

            CheFDishess cheFDishess = new CheFDishess();
            cheFDishess.show(getSupportFragmentManager(),"CHEF");
        } else if (item.equals("SPECIAL SEAFOOD DISHES")) {
            mainCourseHeader = "SPECIAL SEAFOOD DISHES";

            SeaFoodDishess seaFoodDishess = new SeaFoodDishess();
            seaFoodDishess.show(getSupportFragmentManager(),"SEAA");
        } else if (item.equals("MASSALA DISHES")) {
            mainCourseHeader = "MASSALA DISHES";

            MassalaDishes massalaDishes = new MassalaDishes();
            massalaDishes.show(getSupportFragmentManager(),"MASSSS");
        } else if (item.equals("BIRYANI DISHES")){

            mainCourseHeader = "BIRYANI DISHES";
            BiriyaniDishes biriyaniDishes = new BiriyaniDishes();
            biriyaniDishes.show(getSupportFragmentManager(),"BBBB");
        } else if (item.equals("VEGAN MAIN DISHES")) {

            mainCourseHeader = "VEGAN MAIN DISHES";
            VeganMainDishes veganMainDishes = new VeganMainDishes();
            veganMainDishes.show(getSupportFragmentManager(),"LSS");
        } else if (item.equals("CLASSIC DISH")) {

            mainCourseHeader = "CLASSIC DISH";
            ClassicDishes classicDishes = new ClassicDishes();
            classicDishes.show(getSupportFragmentManager(),"CLAASS");
        } else if (item.equals("Vegan Platter")) {

            mainCourseHeader = "Vegan Platter";
            VeganPlatter veganPlatter = new VeganPlatter();
            veganPlatter.show(getSupportFragmentManager(),"VVVJJJ");
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