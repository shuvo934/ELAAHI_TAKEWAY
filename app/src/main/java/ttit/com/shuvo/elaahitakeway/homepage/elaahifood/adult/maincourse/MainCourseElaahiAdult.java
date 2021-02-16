package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse;

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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.BiriyaniDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.ChefSignatureDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.ClassicDishDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.MasalaDishesDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.RadioButtonDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.SpecialSeaFoodDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.TandooriDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.VeganMainDishDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.VeganPlatterDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItemAdapter;

public class MainCourseElaahiAdult extends AppCompatActivity implements MainCourseItemAdapter.ClickedMainCourseItem {

    private TextView mainCourseName;
    private RecyclerView mainCourseView;
    private RecyclerView.LayoutManager mainCourseLayout;
    public static MainCourseItemAdapter mainCourseAdapter;
    public static String mainCourseHeader = "Name";
    public static int adpaterPosition = 0;
    private Button okBtn;

    public static ArrayList<StarterItem> myMCItems;

    public static ArrayList<SelectedElahiItem> selectedTandoori;
    public static ArrayList<SelectedElahiItem> selectedSignatureDish;
    public static ArrayList<SelectedElahiItem> selectedSpecialSeaFood;
    public static ArrayList<SelectedElahiItem> selectedMassala;
    public static ArrayList<SelectedElahiItem> selectedBiriyani;
    public static ArrayList<SelectedElahiItem> selectedVeganMain;
    public static ArrayList<SelectedElahiItem> selectedClassic;
    public static ArrayList<SelectedElahiItem> selectedVeganPlatter;

    public static ArrayList<SelectedElahiItem> totalMainCourseItem;

    public static ArrayList<ItemNameWithSauce> tandooriItem;

    public static ArrayList<ItemNameWithSauce> seaFoodSauceItem;

    public static ArrayList<ItemNameWithSauce> veganMainItemWithChoice;

    public static ArrayList<ItemNameWithSauce> classicDishWithItem;

    public static ArrayList<ItemNameWithSauce> veganPlatterWithItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course_elaahi_adult);

        mainCourseName = findViewById(R.id.titleNamesMainCourse);
        okBtn = findViewById(R.id.ok_mainCourse);
        Intent intent = getIntent();
        mainCourseName.setText(intent.getStringExtra("MainCourse"));

        selectedTandoori = new ArrayList<>();
        selectedSignatureDish = new ArrayList<>();
        selectedSpecialSeaFood = new ArrayList<>();
        selectedMassala = new ArrayList<>();
        selectedBiriyani = new ArrayList<>();
        selectedVeganMain = new ArrayList<>();
        selectedClassic = new ArrayList<>();
        selectedVeganPlatter = new ArrayList<>();

        totalMainCourseItem = new ArrayList<>();

        tandooriItem = new ArrayList<>();

        seaFoodSauceItem = new ArrayList<>();

        veganMainItemWithChoice = new ArrayList<>();

        classicDishWithItem = new ArrayList<>();

        veganPlatterWithItem = new ArrayList<>();

        myMCItems = new ArrayList<>();
        myMCItems.add(new StarterItem("TANDOORI / GRILLED SPECIALS","These dishes are marinated in yoghurt with different oriental spices then cooked in a clay oven. Tandoori dishes are served with salad & choice of curry sauce","0"));
        myMCItems.add(new StarterItem("CHEF’S SIGNATURE DISHES","","0"));
        myMCItems.add(new StarterItem("SPECIAL SEAFOOD DISHES","","0"));
        myMCItems.add(new StarterItem("MASSALA DISHES","(Medium) Tender pieces of meat first cooked in a Tandoori clay oven and then cooked in a very special sauce with fresh cream","0"));
        myMCItems.add(new StarterItem("BIRYANI DISHES","Stir fried with onions and mixed spices then cooked with rice and coriander. Served with Vegetable Sauce","0"));
        myMCItems.add(new StarterItem("VEGAN MAIN DISHES","You can choose your vegetable accompaniment on the pop-up that appears (Seasonal Vegetables, Chickpeas, Mushroom & Peas)","0"));
        myMCItems.add(new StarterItem("CLASSIC DISH","","0"));
        myMCItems.add(new StarterItem("Vegan Platter","Choose any 3 Starters or Side Dishes","0"));


        mainCourseView = findViewById(R.id.main_courseRecycle);
        mainCourseView.setHasFixedSize(true);
        mainCourseLayout = new LinearLayoutManager(this);
        mainCourseView.setLayoutManager(mainCourseLayout);

        mainCourseAdapter = new MainCourseItemAdapter(this, myMCItems, this::onMainCourseItemClicked);
        mainCourseView.setAdapter(mainCourseAdapter);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalMainCourseItem.clear();
                for (int i = 0; i < tandooriItem.size(); i++) {
                    totalMainCourseItem.add(new SelectedElahiItem(tandooriItem.get(i).getItemSauce(), tandooriItem.get(i).getQuantity()));
                }
                for (int i = 0; i < selectedSignatureDish.size(); i++) {
                    totalMainCourseItem.add(new SelectedElahiItem(selectedSignatureDish.get(i).getMyChosenItem(),selectedSignatureDish.get(i).getMyChosenQuantity()));
                }
                for (int i = 0; i < selectedMassala.size(); i++) {
                    totalMainCourseItem.add(new SelectedElahiItem(selectedMassala.get(i).getMyChosenItem(),selectedMassala.get(i).getMyChosenQuantity()));
                }
                for (int i = 0; i < selectedBiriyani.size(); i++) {
                    totalMainCourseItem.add(new SelectedElahiItem(selectedBiriyani.get(i).getMyChosenItem(), selectedBiriyani.get(i).getMyChosenQuantity()));
                }
                for (int i = 0 ; i < veganMainItemWithChoice.size(); i++) {
                    totalMainCourseItem.add(new SelectedElahiItem(veganMainItemWithChoice.get(i).getItemSauce(),veganMainItemWithChoice.get(i).getQuantity()));
                }
                for (int i = 0; i < classicDishWithItem.size(); i++) {
                    totalMainCourseItem.add(new SelectedElahiItem(classicDishWithItem.get(i).getItemSauce(),classicDishWithItem.get(i).getQuantity()));
                }
                for (int i = 0; i < veganPlatterWithItem.size(); i++) {
                    totalMainCourseItem.add(new SelectedElahiItem(veganPlatterWithItem.get(i).getItemSauce(),veganPlatterWithItem.get(i).getQuantity()));
                }

                for (int i = 0; i< selectedSpecialSeaFood.size(); i++) {
                    for (ItemNameWithSauce item : seaFoodSauceItem) {
                        if (item.getItemSauce().contains(selectedSpecialSeaFood.get(i).getMyChosenItem())) {
                            Log.i("Need to Delete", item.getItemSauce());
                            Log.i("Delete from main Food:", selectedSpecialSeaFood.get(i).getMyChosenItem());
                            selectedSpecialSeaFood.remove(i);
                        }
                    }
                }
                for (int i = 0; i < selectedSpecialSeaFood.size(); i++) {
                    totalMainCourseItem.add(new SelectedElahiItem(selectedSpecialSeaFood.get(i).getMyChosenItem(),selectedSpecialSeaFood.get(i).getMyChosenQuantity()));
                }
                for (int i = 0; i < seaFoodSauceItem.size(); i++) {
                    totalMainCourseItem.add(new SelectedElahiItem(seaFoodSauceItem.get(i).getItemSauce(),seaFoodSauceItem.get(i).getQuantity()));
                }

                int j = 0;
                AdultElaahi.selectedItemMCadultElhi.clear();
                for (int i = 0; i < totalMainCourseItem.size(); i++) {
                    AdultElaahi.selectedItemMCadultElhi.add(new SelectedElahiItem(totalMainCourseItem.get(i).getMyChosenItem(), totalMainCourseItem.get(i).getMyChosenQuantity()));
                    j = j + Integer.parseInt(totalMainCourseItem.get(i).getMyChosenQuantity());
                }

                if (j == 0) {
                    AdultElaahi.mcCountadultElhi.setText(String.valueOf(j));
                    AdultElaahi.mcCountadultElhi.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    AdultElaahi.mcCountadultElhi.setText(String.valueOf(j));
                    AdultElaahi.mcCountadultElhi.setBackgroundResource(R.drawable.ic_circle_red);
                }
                finish();
            }
        });

    }

    @Override
    public void onMainCourseItemClicked(int mainCourseItemPosition) {
        String item = myMCItems.get(mainCourseItemPosition).getTypeOfFood();
        Log.i("Item : ", item);
        if (item.equals("TANDOORI / GRILLED SPECIALS")) {
            mainCourseHeader = "TANDOORI / GRILLED SPECIALS";
            adpaterPosition = mainCourseItemPosition;
            TandooriDialogue tandooriDialogue = new TandooriDialogue();
            tandooriDialogue.show(getSupportFragmentManager(),"Tandoori");
        }else if (item.equals("CHEF’S SIGNATURE DISHES")) {
            mainCourseHeader = "CHEF’S SIGNATURE DISHES";
            adpaterPosition = mainCourseItemPosition;
            ChefSignatureDialogue chefSignatureDialogue = new ChefSignatureDialogue();
            chefSignatureDialogue.show(getSupportFragmentManager(),"Chef Siganture");
        } else if (item.equals("SPECIAL SEAFOOD DISHES")) {
            mainCourseHeader = "SPECIAL SEAFOOD DISHES";
            adpaterPosition = mainCourseItemPosition;
            SpecialSeaFoodDialogue specialSeaFoodDialogue = new SpecialSeaFoodDialogue();
            specialSeaFoodDialogue.show(getSupportFragmentManager(),"Special SeaFOOD");
        } else if (item.equals("MASSALA DISHES")) {
            mainCourseHeader = "MASSALA DISHES";
            adpaterPosition = mainCourseItemPosition;
            MasalaDishesDialogue masalaDishesDialogue = new MasalaDishesDialogue();
            masalaDishesDialogue.show(getSupportFragmentManager(),"Masala");
        } else if (item.equals("BIRYANI DISHES")){
            adpaterPosition = mainCourseItemPosition;
            mainCourseHeader = "BIRYANI DISHES";
            BiriyaniDialogue biriyaniDialogue = new BiriyaniDialogue();
            biriyaniDialogue.show(getSupportFragmentManager(),"Biriyani");
        } else if (item.equals("VEGAN MAIN DISHES")) {
            adpaterPosition = mainCourseItemPosition;
            mainCourseHeader = "VEGAN MAIN DISHES";
            VeganMainDishDialogue veganMainDishDialogue = new VeganMainDishDialogue();
            veganMainDishDialogue.show(getSupportFragmentManager(),"VeganMain");
        } else if (item.equals("CLASSIC DISH")) {
            adpaterPosition = mainCourseItemPosition;
            mainCourseHeader = "CLASSIC DISH";
            ClassicDishDialogue classicDishDialogue = new ClassicDishDialogue();
            classicDishDialogue.show(getSupportFragmentManager(),"ClassicDish");
        } else if (item.equals("Vegan Platter")) {
            adpaterPosition = mainCourseItemPosition;
            mainCourseHeader = "Vegan Platter";
            VeganPlatterDialogue veganPlatterDialogue = new VeganPlatterDialogue();
            veganPlatterDialogue.show(getSupportFragmentManager(),"Vegan Platter");
        }
    }

}