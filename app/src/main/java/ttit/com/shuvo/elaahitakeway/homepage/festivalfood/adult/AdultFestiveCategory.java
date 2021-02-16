package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.FestivalActivity;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.AppitiserDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.DessertAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.MainCourseAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.PeopleNumberDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.StarterAdultDialogue;

public class AdultFestiveCategory extends AppCompatActivity {


    public static TextView num;
    private Button addPeople;
    private Button minusPeople;
    public static Button appitiser;
    private Button starter;
    private Button mainCourse;
    private Button desert;
    private Button submitSelection;
    public static TextView apptCount;
    public static TextView startCount;
    public static TextView mcCount;
    public static TextView desCount;
    public static String titleName;

    public static ArrayList<SelectedItem> selectedItemapt;
    public static ArrayList<SelectedItem> selectedItemStarter;
    public static ArrayList<SelectedItem> selectedItemMC;
    public static ArrayList<SelectedItem> selectedItemDesert;

    public static ArrayList<CartItem> newCart;


    private String dessert = "DESSERTS:-";
    private String appt = "APPERTISERS:-";
    private String startersss = "STARTERS:-";
    private String mainC = "MAIN COURSES:-";

    private String categoryName;
    private String pricesFor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult_festive_category);
        num = findViewById(R.id.numberP);
        addPeople = findViewById(R.id.plus_people);
        minusPeople = findViewById(R.id.minus_people);

        appitiser = findViewById(R.id.appitiser);
        starter = findViewById(R.id.starters);
        mainCourse = findViewById(R.id.main_course);
        desert = findViewById(R.id.desert);
        submitSelection = findViewById(R.id.submit_selection);

        apptCount = findViewById(R.id.total_quantity_appt);
        startCount = findViewById(R.id.total_quantity_start);
        mcCount = findViewById(R.id.total_quantity_MC);
        desCount = findViewById(R.id.total_quantity_desert);


        selectedItemapt = new ArrayList<>();
        selectedItemStarter = new ArrayList<>();
        selectedItemMC = new ArrayList<>();
        selectedItemDesert = new ArrayList<>();

        newCart = new ArrayList<>();
        pricesFor = "£20.95";

        Intent intent = getIntent();
        categoryName = intent.getStringExtra("CategoryName") + "----" + intent.getStringExtra("SubCategoryName");

        getSupportActionBar().setTitle(categoryName);

        PeopleNumberDialogue peopleNumberDialogue = new PeopleNumberDialogue();
        peopleNumberDialogue.show(getSupportFragmentManager(),"Number");



        addPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num.getText().toString();
                int n = Integer.parseInt(text);
                int add = n + 1;
                num.setText(String.valueOf(add));
            }
        });

        minusPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num.getText().toString() == apptCount.getText().toString() || num.getText().toString() == startCount.getText().toString() || num.getText().toString() == mcCount.getText().toString() || num.getText().toString() == desCount.getText().toString()){
                    return;
                } else {
                    String text = num.getText().toString();
                    int n = Integer.parseInt(text);
                    if (n == 1) {
                        return;
                    } else {
                        int m = n - 1;
                        num.setText(String.valueOf(m));
                    }
                }

            }
        });


        submitSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < selectedItemDesert.size(); i++) {
                    String text = "   " + selectedItemDesert.get(i).getMyChosenItem()+ "--" + selectedItemDesert.get(i).getMyChosenQuantity();
                    dessert = dessert + "\n" + text;
                }
                Log.i("Dessert: " , dessert);

                for (int i = 0; i < selectedItemapt.size(); i++) {
                    String text = "   " + selectedItemapt.get(i).getMyChosenItem()+ "--" + selectedItemapt.get(i).getMyChosenQuantity();
                    appt = appt + "\n" + text;
                }
                Log.i("appt: " , appt);

                for (int i = 0; i < selectedItemStarter.size(); i++) {
                    String text = "   " + selectedItemStarter.get(i).getMyChosenItem()+ "--" + selectedItemStarter.get(i).getMyChosenQuantity();
                    startersss = startersss + "\n" + text;
                }
                Log.i("start: " , startersss);

                for (int i = 0; i < selectedItemMC.size(); i++) {
                    String text = "   " + selectedItemMC.get(i).getMyChosenItem()+ "--" + selectedItemMC.get(i).getMyChosenQuantity();
                    mainC = mainC + "\n" + text;
                }
                Log.i("main: " , mainC);

                categoryName = categoryName + "\n\n  " + appt + "\n\n" + startersss + "\n\n" + mainC + "\n\n" + dessert;
                Log.i("ALL FOOD:", categoryName);

                //newCart.add(new CartItem(categoryName, num.getText().toString()));
                CartActivity.mainFoodList.add(new CartItem(categoryName, num.getText().toString(), pricesFor));
                Intent intent1 = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent1);
                finish();


            }

        });




//
//        appitiser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppitiserDialogue appitiserDialogue = new AppitiserDialogue();
//                appitiserDialogue.show(getSupportFragmentManager(),"Appitiser");
//            }
//        });




    }

    public void btnClicked (View view) {

        switch (view.getId()) {
            case R.id.appitiser:

                titleName = appitiser.getText().toString();
                AppitiserDialogue appitiserDialogue = new AppitiserDialogue();
                appitiserDialogue.show(getSupportFragmentManager(),"Appitiser");

                break;
            case R.id.starters:


                titleName = starter.getText().toString();
                StarterAdultDialogue starterAdultDialogue = new StarterAdultDialogue();
                starterAdultDialogue.show(getSupportFragmentManager(),"Starter");

                break;
            case R.id.main_course:

                titleName = mainCourse.getText().toString();
                MainCourseAdultDialogue mainCourseAdultDialogue = new MainCourseAdultDialogue();
                mainCourseAdultDialogue.show(getSupportFragmentManager(),"Main Course");


                break;
            case R.id.desert:

                titleName = desert.getText().toString();
                DessertAdultDialogue dessertAdultDialogue = new DessertAdultDialogue();
                dessertAdultDialogue.show(getSupportFragmentManager(),"Dessert");

                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), FestivalActivity.class);
        startActivity(intent);
        finish();
    }
}