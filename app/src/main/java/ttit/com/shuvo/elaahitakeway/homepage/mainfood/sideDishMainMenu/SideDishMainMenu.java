package ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu;

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
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.dialogueBOXForItem.ClassicDish;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.dialogueBOXForItem.VeganSIDEDish;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.OracleConnection.createConnection;
import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.MainCategoryMenu.food1;

public class SideDishMainMenu extends AppCompatActivity implements SideDishMainMenuAdapter.ClickedStarterItem {

    private RecyclerView sideDishView;
    private RecyclerView.LayoutManager sideDishLayout;
    public SideDishMainMenuAdapter sideDishAdapter;
    private Button sideDishOk;
    public static String starterTitle = "Food";

    public static ArrayList<StarterItem> mySideDishItem;
    public static ArrayList<SubCategoryItemTag> sideMDish;

    public static ArrayList<SubCategoryItemTag> sideItemtag;
    private Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_dish_main_menu);

        getSupportActionBar().setTitle("SIDE DISHES");

        sideDishOk = findViewById(R.id.sideDish_ok_mainMenu);

        sideMDish = new ArrayList<>();
        sideMDish = food1;

        sideItemtag = new ArrayList<>();

        mySideDishItem = new ArrayList<>();
//        mySideDishItem.add(new StarterItem("CLASSIC SIDE DISHES", "","0"));
//        mySideDishItem.add(new StarterItem("VEGAN SIDE DISHES", "","0"));

        sideDishView = findViewById(R.id.sideDishRecycle_mainMenu);
        sideDishView.setHasFixedSize(true);
        sideDishLayout = new LinearLayoutManager(this);
        sideDishView.setLayoutManager(sideDishLayout);

        sideDishAdapter = new SideDishMainMenuAdapter(this, sideMDish, this::onStarterItemClicked);
        sideDishView.setAdapter(sideDishAdapter);

        sideDishOk.setOnClickListener(new View.OnClickListener() {
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
        String item = sideMDish.get(starterItemPosition).getfId();
        if (item.equals("41")) {
            connectivityForFood(item);
            starterTitle = sideMDish.get(starterItemPosition).getfName();
            ClassicDish classicDish = new ClassicDish();
            classicDish.show(getSupportFragmentManager(),"CLDISH");


        }else if (item.equals("42")) {
            connectivityForFood(item);
            starterTitle = sideMDish.get(starterItemPosition).getfName();
            VeganSIDEDish veganSIDEDish = new VeganSIDEDish();
            veganSIDEDish.show(getSupportFragmentManager(),"VESIDI");


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
            sideItemtag = new ArrayList<>();
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
                sideItemtag.add(new SubCategoryItemTag(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(5)));

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