package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.ElahiActivity;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.dialogueBox.AppitiserElaahiAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.dialogueBox.DessertElahiAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.dialogueBox.NumberOfChildDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.dialogueBox.NumberOfPeopleDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.dialogueBox.SunDriesElaahiAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.MainCourseElaahiAdult;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterElaahiAdult;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.FestivalActivity;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.SelectedItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.AppitiserDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.DessertAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.MainCourseAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.StarterAdultDialogue;

public class AdultElaahi extends AppCompatActivity {

    public static TextView numadultElhi;
    private Button addPeopleadultElhi;
    private Button minusPeopleadultElhi;
    public static Button appitiseradultElhi;
    private Button starteradultElhi;
    private Button mainCourseadultElhi;
    private Button sunDriesadultElhi;
    private Button desertadultElhi;
    private Button submitSelectionadultElhi;
    public static TextView apptCountadultElhi;
    public static TextView startCountadultElhi;
    public static TextView mcCountadultElhi;
    public static TextView desCountadultElhi;
    public static TextView sunCountadultElhi;
    public static String titleNameadultElhi;

    public static ArrayList<SelectedElahiItem> selectedItemaptadultElhi;
    public static ArrayList<SelectedElahiItem> selectedItemStarteradultElhi;
    public static ArrayList<SelectedElahiItem> selectedItemMCadultElhi;
    public static ArrayList<SelectedElahiItem> selectedItemDesertadultElhi;
    public static ArrayList<SelectedElahiItem> selectedItemSunDriesadultElhi;

    public static ArrayList<CartItem> newCartadultElhi;


    private String dessert = "DESSERTS:-";
    private String appt = "APPERTISERS:-";
    private String startersss = "STARTERS:-";
    private String mainC = "MAIN COURSES:-";
    private String sunD = "SUNDRIES:-";

    private String categoryName;
    private String pricesfor;
    private TextView peopleState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult_elaahi);

        numadultElhi = findViewById(R.id.numberP_adult_elaahi);
        addPeopleadultElhi = findViewById(R.id.plus_people_adult_elaahi);
        minusPeopleadultElhi = findViewById(R.id.minus_people_adult_elaahi);

        appitiseradultElhi = findViewById(R.id.appitiser_adult_elaahi);
        starteradultElhi = findViewById(R.id.starters_adult_elaahi);
        mainCourseadultElhi = findViewById(R.id.main_course_adult_elaahi);
        desertadultElhi = findViewById(R.id.desert_adult_elaahi);
        sunDriesadultElhi = findViewById(R.id.sundries_adult_elaahi);
        submitSelectionadultElhi = findViewById(R.id.submit_selection_adult_elaahi);

        apptCountadultElhi = findViewById(R.id.total_quantity_appt_adult_elaahi);
        startCountadultElhi = findViewById(R.id.total_quantity_start_adult_elaahi);
        mcCountadultElhi = findViewById(R.id.total_quantity_MC_adult_elaahi);
        desCountadultElhi = findViewById(R.id.total_quantity_desert_adult_elaahi);
        sunCountadultElhi =findViewById(R.id.total_quantity_sundries_adult_elaahi);

        peopleState = findViewById(R.id.textView5_adult_elaahi);


        selectedItemaptadultElhi = new ArrayList<>();
        selectedItemStarteradultElhi = new ArrayList<>();
        selectedItemMCadultElhi = new ArrayList<>();
        selectedItemDesertadultElhi = new ArrayList<>();
        selectedItemSunDriesadultElhi = new ArrayList<>();

        newCartadultElhi = new ArrayList<>();

        Intent intent = getIntent();
        categoryName = intent.getStringExtra("CategoryName") + "----" + intent.getStringExtra("SubCategoryName");

        getSupportActionBar().setTitle(categoryName);

        if (intent.getStringExtra("SubCategoryName").contains("CHILD")) {
            peopleState.setText("Number Of Child");
            NumberOfChildDialogue numberOfChildDialogue = new NumberOfChildDialogue();
            numberOfChildDialogue.show(getSupportFragmentManager(),"NUmber of Child");
            pricesfor = "£10.95";
        } else {
            NumberOfPeopleDialogue numberOfPeopleDialogue = new NumberOfPeopleDialogue();
            numberOfPeopleDialogue.show(getSupportFragmentManager(),"Number of people");
            pricesfor = "£20.95";
        }

        addPeopleadultElhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = numadultElhi.getText().toString();
                int n = Integer.parseInt(text);
                int add = n + 1;
                numadultElhi.setText(String.valueOf(add));
            }
        });

        minusPeopleadultElhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numadultElhi.getText().toString() == apptCountadultElhi.getText().toString() || numadultElhi.getText().toString() == startCountadultElhi.getText().toString() || numadultElhi.getText().toString() == mcCountadultElhi.getText().toString() || numadultElhi.getText().toString() == desCountadultElhi.getText().toString() || numadultElhi.getText().toString() == sunCountadultElhi.getText().toString()){
                    return;
                } else {
                    String text = numadultElhi.getText().toString();
                    int n = Integer.parseInt(text);
                    if (n == 1) {
                        return;
                    } else {
                        int m = n - 1;
                        numadultElhi.setText(String.valueOf(m));
                    }
                }

            }
        });

        submitSelectionadultElhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < selectedItemaptadultElhi.size(); i++) {
                    String text = "   " + selectedItemaptadultElhi.get(i).getMyChosenItem()+ "--" + selectedItemaptadultElhi.get(i).getMyChosenQuantity();
                    appt = appt + "\n" + text;
                }
                Log.i("Appt: " , appt);
                for (int i = 0; i < selectedItemStarteradultElhi.size(); i++) {
                    String text = "   " + selectedItemStarteradultElhi.get(i).getMyChosenItem()+ "--" + selectedItemStarteradultElhi.get(i).getMyChosenQuantity();
                    startersss = startersss + "\n" + text;
                }
                Log.i("Starter: " , startersss);
                for (int i = 0; i < selectedItemMCadultElhi.size(); i++) {
                    String text = "   " + selectedItemMCadultElhi.get(i).getMyChosenItem()+ "--" + selectedItemMCadultElhi.get(i).getMyChosenQuantity();
                    mainC = mainC + "\n" + text;
                }
                Log.i("MainCourse: " , mainC);
                for (int i = 0; i < selectedItemDesertadultElhi.size(); i++) {
                    String text = "   " + selectedItemDesertadultElhi.get(i).getMyChosenItem()+ "--" + selectedItemDesertadultElhi.get(i).getMyChosenQuantity();
                    dessert = dessert + "\n" + text;
                }
                Log.i("MainCourse: " , dessert);
                for (int i = 0; i < selectedItemSunDriesadultElhi.size(); i++) {
                    String text = "   " + selectedItemSunDriesadultElhi.get(i).getMyChosenItem()+ "--" + selectedItemSunDriesadultElhi.get(i).getMyChosenQuantity();
                    sunD = sunD + "\n" + text;
                }
                Log.i("MainCourse: " , sunD);

                categoryName = categoryName + "\n\n  " + appt + "\n\n" + startersss + "\n\n" + mainC + "\n\n" + sunD + "\n\n" + dessert;
                Log.i("ALL FOOD:", categoryName);

                CartActivity.mainFoodList.add(new CartItem(categoryName, numadultElhi.getText().toString(), pricesfor));
                Intent intent1 = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent1);
                finish();

            }
        });


    }

    public void btnClickedElahiAdult (View view) {

        switch (view.getId()) {
            case R.id.appitiser_adult_elaahi:

                titleNameadultElhi = appitiseradultElhi.getText().toString();
                AppitiserElaahiAdultDialogue appitiserElaahiAdultDialogue = new AppitiserElaahiAdultDialogue();
                appitiserElaahiAdultDialogue.show(getSupportFragmentManager(),"AppitiserElaahi");

                break;
            case R.id.starters_adult_elaahi:


                titleNameadultElhi = starteradultElhi.getText().toString();
//                StarterAdultDialogue starterAdultDialogue = new StarterAdultDialogue();
//                starterAdultDialogue.show(getSupportFragmentManager(),"Starter");
                Intent intent = new Intent(this, StarterElaahiAdult.class);
                intent.putExtra("Starter", titleNameadultElhi );
                startActivity(intent);

                break;
            case R.id.main_course_adult_elaahi:

                titleNameadultElhi = mainCourseadultElhi.getText().toString();
//                MainCourseAdultDialogue mainCourseAdultDialogue = new MainCourseAdultDialogue();
//                mainCourseAdultDialogue.show(getSupportFragmentManager(),"Main Course");
                Intent intent1 = new Intent(this, MainCourseElaahiAdult.class);
                intent1.putExtra("MainCourse", titleNameadultElhi);
                startActivity(intent1);


                break;
            case R.id.sundries_adult_elaahi:

                titleNameadultElhi = sunDriesadultElhi.getText().toString();
                SunDriesElaahiAdultDialogue sunDriesElaahiAdultDialogue = new SunDriesElaahiAdultDialogue();
                sunDriesElaahiAdultDialogue.show(getSupportFragmentManager(),"SunDries");

                break;
            case R.id.desert_adult_elaahi:

                titleNameadultElhi = desertadultElhi.getText().toString();
                DessertElahiAdultDialogue dessertElahiAdultDialogue = new DessertElahiAdultDialogue();
                dessertElahiAdultDialogue.show(getSupportFragmentManager(),"DessertElaahi");

                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), ElahiActivity.class);
        startActivity(intent);
        finish();
    }
}