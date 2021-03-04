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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.OracleConnection.createConnection;
import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.MainCategoryMenu.food1;

public class MainCourseMenu extends AppCompatActivity implements MainCourseMenuAdapter.ClickedStarterItem{

    private TextView mainCourseName;
    private RecyclerView mainCourseView;
    private RecyclerView.LayoutManager mainCourseLayout;
    public static MainCourseMenuAdapter mainCourseAdapter;
    public static String mainCourseHeader = "Name";
    private Button okBtn;

    public static ArrayList<StarterItem> myMCItemsMain;
    public static ArrayList<SubCategoryItemTag> mMainC;

    public static ArrayList<SubCategoryItemTag> mainFoodTag;
    private Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course_menu);
        getSupportActionBar().setTitle("MAIN COURSES");

        okBtn = findViewById(R.id.ok_mainCourse_main);

        mMainC= new ArrayList<>();

        mMainC= food1;

        mainFoodTag = new ArrayList<>();
//        myMCItemsMain = new ArrayList<>();
//        myMCItemsMain.add(new StarterItem("TANDOORI / GRILLED SPECIALS","These dishes are marinated in yoghurt with different oriental spices then cooked in a clay oven. Tandoori dishes are served with salad & choice of curry sauce","0"));
//        myMCItemsMain.add(new StarterItem("CHEF’S SIGNATURE DISHES","","0"));
//        myMCItemsMain.add(new StarterItem("SPECIAL SEAFOOD DISHES","","0"));
//        myMCItemsMain.add(new StarterItem("MASSALA DISHES","(Medium) Tender pieces of meat first cooked in a Tandoori clay oven and then cooked in a very special sauce with fresh cream","0"));
//        myMCItemsMain.add(new StarterItem("BIRYANI DISHES","Stir fried with onions and mixed spices then cooked with rice and coriander. Served with Vegetable Sauce","0"));
//        myMCItemsMain.add(new StarterItem("VEGAN MAIN DISHES","You can choose your vegetable accompaniment on the pop-up that appears (Seasonal Vegetables, Chickpeas, Mushroom & Peas)","0"));
//        myMCItemsMain.add(new StarterItem("CLASSIC DISH","","0"));
//        myMCItemsMain.add(new StarterItem("Vegan Platter","Choose any 3 Starters or Side Dishes","0"));

        mainCourseView = findViewById(R.id.main_courseRecycle_main);
        mainCourseView.setHasFixedSize(true);
        mainCourseLayout = new LinearLayoutManager(this);
        mainCourseLayout.isSmoothScrolling();
        mainCourseView.setLayoutManager(mainCourseLayout);

        mainCourseAdapter = new MainCourseMenuAdapter(this, mMainC, this::onStarterItemClicked);
        mainCourseView.setAdapter(mainCourseAdapter);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food1.clear();
                finish();
            }
        });

    }

    @Override
    public void onStarterItemClicked(int starterItemPosition) {

        String item = mMainC.get(starterItemPosition).getfId();
        Log.i("Item : ", item);
        if (item.equals("35")) {
            mainCourseHeader = mMainC.get(starterItemPosition).getfName();
            connectivityForFood(item);

            Tandoori tandoori = new Tandoori();
            tandoori.show(getSupportFragmentManager(),"tannn");
        }else if (item.equals("36")) {
            mainCourseHeader = mMainC.get(starterItemPosition).getfName();
            connectivityForFood(item);

            CheFDishess cheFDishess = new CheFDishess();
            cheFDishess.show(getSupportFragmentManager(),"CHEF");
        } else if (item.equals("37")) {
            mainCourseHeader = mMainC.get(starterItemPosition).getfName();
            connectivityForFood(item);

            SeaFoodDishess seaFoodDishess = new SeaFoodDishess();
            seaFoodDishess.show(getSupportFragmentManager(),"SEAA");
        } else if (item.equals("38")) {
            mainCourseHeader = mMainC.get(starterItemPosition).getfName();
            connectivityForFood(item);

            MassalaDishes massalaDishes = new MassalaDishes();
            massalaDishes.show(getSupportFragmentManager(),"MASSSS");
        } else if (item.equals("39")){
            mainCourseHeader = mMainC.get(starterItemPosition).getfName();
            connectivityForFood(item);

            BiriyaniDishes biriyaniDishes = new BiriyaniDishes();
            biriyaniDishes.show(getSupportFragmentManager(),"BBBB");
        } else if (item.equals("40")) {
            mainCourseHeader = mMainC.get(starterItemPosition).getfName();
            connectivityForFood(item);

            VeganMainDishes veganMainDishes = new VeganMainDishes();
            veganMainDishes.show(getSupportFragmentManager(),"LSS");
        } else if (item.equals("43")) {

            mainCourseHeader = mMainC.get(starterItemPosition).getfName();
            connectivityForFood(item);

            ClassicDishes classicDishes = new ClassicDishes();
            classicDishes.show(getSupportFragmentManager(),"CLAASS");
        } else if (item.equals("371")) {

            mainCourseHeader = mMainC.get(starterItemPosition).getfName();
            connectivityForFood(item);

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
    public void onBackPressed() {
        food1.clear();
        finish();
    }

    public void connectivityForFood(String id) {

        //Sub_Category Data
        try {
            this.connection = createConnection();
            //    Toast.makeText(MainActivity.this, "Connected",Toast.LENGTH_SHORT).show();

            Statement stmt = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer1 = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            StringBuffer stringBuffer4 = new StringBuffer();
            StringBuffer stringBuffer5 = new StringBuffer();
            StringBuffer stringBuffer6 = new StringBuffer();

            ResultSet rs=stmt.executeQuery("SELECT IEM_ID,  IEM_NAME, IEM_TYPE,\n" +
                    "(SELECT FT_NAME FROM ELAAHI_FOOD_TAG WHERE FT_ID = IEM_FOOD_TAG) AS FOOD_TAG,\n" +
                    "(select distinct EFT_NAME from ELAAHI_FOOD_TEST where EFT_ID = IEM_FOOD_TEST) AS FOOD_TEST,\n" +
                    " IEM_FOOD_FLAVOUR_NOTE as FOOD_NOTE, \n" +
                    " IEM_FOOD_RATE\n" +
                    "FROM ELAHI_ITEM_ECOM_MST_COPY\n" +
                    "WHERE IEM_TYPE = 3\n" +
                    "AND IEM_IEM_ID = "+id+"\n" +
                    "ORDER BY IEM_ID ASC");

            while(rs.next()) {
                stringBuffer.append("ID: " +rs.getString(1)+ "\n");
                stringBuffer1.append("Name: " + rs.getString(2)+"\n");
                stringBuffer2.append("TYPE: "+ rs.getString(3)+"\n");
                stringBuffer3.append("FOOD TAG: "+ rs.getString(4)+"\n");
                stringBuffer4.append("FOOD_TEST: "+ rs.getString(5)+"\n");
                stringBuffer5.append( "FOOD NOTE: " +rs.getString(6)+"\n");
                stringBuffer6.append("Food rate: "+ rs.getString(7)+"\n");
                mainFoodTag.add(new SubCategoryItemTag(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(5)));

            }
            System.out.println(stringBuffer);
            System.out.println(stringBuffer1);
            System.out.println(stringBuffer2);
            System.out.println(stringBuffer3);
            System.out.println(stringBuffer4);
            System.out.println(stringBuffer5);
            System.out.println(stringBuffer6);

            connection.close();
        }
        catch (Exception e) {

            //   Toast.makeText(MainActivity.this, ""+e,Toast.LENGTH_LONG).show();
            Log.i("ERRRRR", e.getLocalizedMessage());
            e.printStackTrace();
        }

    }
}