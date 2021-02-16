package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child;

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
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.FestivalActivity;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.SelectedItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.AppitiserDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.DessertAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.MainCourseAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.PeopleNumberDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox.StarterAdultDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.dialogueBox.AppitiserChildDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.dialogueBox.ChildNumberDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.dialogueBox.DessertChildDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.dialogueBox.MainCourseChildDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.dialogueBox.StarterChildDialogue;

public class ChildFestiveCategory extends AppCompatActivity {

    public static TextView numChild;
    private Button addPeopleChild;
    private Button minusPeopleChild;
    public static Button appitiserChild;
    private Button starterChild;
    private Button mainCourseChild;
    private Button desertChild;
    private Button submitSelectionChild;
    public static TextView apptCountChild;
    public static TextView startCountChild;
    public static TextView mcCountChild;
    public static TextView desCountChild;
    public static String titleNameChild;

    public static ArrayList<SelectedItem> selectedItemaptChild;
    public static ArrayList<SelectedItem> selectedItemStarterChild;
    public static ArrayList<SelectedItem> selectedItemMCChild;
    public static ArrayList<SelectedItem> selectedItemDesertChild;

    public static ArrayList<CartItem> newCartChild;

    private String dessert = "DESSERTS:-";
    private String appt = "APPERTISERS:-";
    private String startersss = "STARTERS:-";
    private String mainC = "MAIN COURSES:-";

    private String categoryName;
    private String pricesFor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_festive_category);

        numChild = findViewById(R.id.numberP_child);
        addPeopleChild = findViewById(R.id.plus_people_child);
        minusPeopleChild = findViewById(R.id.minus_people_child);

        appitiserChild = findViewById(R.id.appitiser_child);
        starterChild = findViewById(R.id.starters_child);
        mainCourseChild = findViewById(R.id.main_course_child);
        desertChild = findViewById(R.id.desert_child);
        submitSelectionChild = findViewById(R.id.submit_selection_child);

        apptCountChild = findViewById(R.id.total_quantity_appt_child);
        startCountChild = findViewById(R.id.total_quantity_start_child);
        mcCountChild = findViewById(R.id.total_quantity_MC_child);
        desCountChild = findViewById(R.id.total_quantity_desert_child);


        selectedItemaptChild = new ArrayList<>();
        selectedItemStarterChild = new ArrayList<>();
        selectedItemMCChild = new ArrayList<>();
        selectedItemDesertChild = new ArrayList<>();

        newCartChild = new ArrayList<>();
        pricesFor = "£10.95";

        Intent intent = getIntent();
        categoryName = intent.getStringExtra("CategoryName") + "----" + intent.getStringExtra("SubCategoryName");

        getSupportActionBar().setTitle(categoryName);

        ChildNumberDialogue childNumberDialogue = new ChildNumberDialogue();
        childNumberDialogue.show(getSupportFragmentManager(),"NumberOfChild");

        addPeopleChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = numChild.getText().toString();
                int n = Integer.parseInt(text);
                int add = n + 1;
                numChild.setText(String.valueOf(add));
            }
        });

        minusPeopleChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numChild.getText().toString() == apptCountChild.getText().toString() || numChild.getText().toString() == startCountChild.getText().toString() || numChild.getText().toString() == mcCountChild.getText().toString() || numChild.getText().toString() == desCountChild.getText().toString()){
                    return;
                } else {
                    String text = numChild.getText().toString();
                    int n = Integer.parseInt(text);
                    if (n == 1) {
                        return;
                    } else {
                        int m = n - 1;
                        numChild.setText(String.valueOf(m));
                    }
                }

            }
        });

        submitSelectionChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < selectedItemDesertChild.size(); i++) {
                    String text = "   " + selectedItemDesertChild.get(i).getMyChosenItem()+ "--" + selectedItemDesertChild.get(i).getMyChosenQuantity();
                    dessert = dessert + "\n" + text;
                }
                Log.i("Dessert: " , dessert);

                for (int i = 0; i < selectedItemaptChild.size(); i++) {
                    String text = "   " + selectedItemaptChild.get(i).getMyChosenItem()+ "--" + selectedItemaptChild.get(i).getMyChosenQuantity();
                    appt = appt + "\n" + text;
                }
                Log.i("appt: " , appt);

                for (int i = 0; i < selectedItemStarterChild.size(); i++) {
                    String text = "   " + selectedItemStarterChild.get(i).getMyChosenItem()+ "--" + selectedItemStarterChild.get(i).getMyChosenQuantity();
                    startersss = startersss + "\n" + text;
                }
                Log.i("start: " , startersss);

                for (int i = 0; i < selectedItemMCChild.size(); i++) {
                    String text = "   " + selectedItemMCChild.get(i).getMyChosenItem()+ "--" + selectedItemMCChild.get(i).getMyChosenQuantity();
                    mainC = mainC + "\n" + text;
                }
                Log.i("main: " , mainC);

                categoryName = categoryName + "\n\n  " + appt + "\n\n" + startersss + "\n\n" + mainC + "\n\n" + dessert;
                Log.i("ALL FOOD:", categoryName);

                //newCart.add(new CartItem(categoryName, num.getText().toString()));
                CartActivity.mainFoodList.add(new CartItem(categoryName, numChild.getText().toString(), pricesFor));
                Intent intent1 = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent1);
                finish();


            }

        });

    }

    public void childbtnClicked (View view) {

        switch (view.getId()) {
            case R.id.appitiser_child:

                titleNameChild = appitiserChild.getText().toString();
                AppitiserChildDialogue appitiserChildDialogue = new AppitiserChildDialogue();
                appitiserChildDialogue.show(getSupportFragmentManager(),"AppitiserChild");

                break;
            case R.id.starters_child:


                titleNameChild = starterChild.getText().toString();
                StarterChildDialogue starterChildDialogue = new StarterChildDialogue();
                starterChildDialogue.show(getSupportFragmentManager(),"StarterChild");

                break;
            case R.id.main_course_child:

                titleNameChild = mainCourseChild.getText().toString();
                MainCourseChildDialogue mainCourseChildDialogue = new MainCourseChildDialogue();
                mainCourseChildDialogue.show(getSupportFragmentManager(),"Main Course Child");


                break;
            case R.id.desert_child:

                titleNameChild = desertChild.getText().toString();
                DessertChildDialogue dessertChildDialogue = new DessertChildDialogue();
                dessertChildDialogue.show(getSupportFragmentManager(),"Dessert Child");

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