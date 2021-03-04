package ttit.com.shuvo.elaahitakeway.homepage.mainfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.CategoryAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.ElahiActivity;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.FestivalActivity;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser.AppitiserMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.childrensMenuMain.ChildrensMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dessertsMainMenu.DessertsMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.drinksMenu.DrinksMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.riceDishMainMenu.RiceDishMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.SetMeal;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.SideDishMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.StarterMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sunDriesMainMenu.SunDriesMainMenu;

import static ttit.com.shuvo.elaahitakeway.homepage.MainActivity.mainCategoryName;
import static ttit.com.shuvo.elaahitakeway.homepage.OracleConnection.createConnection;

public class MainCategoryMenu extends AppCompatActivity implements MainCategoryMenuAdapter.MenuClickedItem{

    private RecyclerView recyclerView;
    private MainCategoryMenuAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static ArrayList<SubCategoryItemTag> food1;

    private Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_category_menu);

        food1 = new ArrayList<>();


        recyclerView = findViewById(R.id.mainCategory_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MainCategoryMenuAdapter(mainCategoryName, this::onCategoryClicked);
        recyclerView.setAdapter(adapter);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    @Override
    public void onCategoryClicked(int CategoryPosition) {

        String te = mainCategoryName.get(CategoryPosition).getIem_id();
//       System.out.println("Hello"+te+"world");
        if (te.equals("3")) {
            Log.i("JJJ", "SS");
            connectivityForFood(te);
            //String name = mainCategoryName.get(CategoryPosition).getmText();
            Intent intent = new Intent(this, AppitiserMainMenu.class);
            startActivity(intent);

        } else if (te.equals("4")){
            connectivity(te);
            //Log.i("TEXT", te);
            Intent intent1 = new Intent(this, StarterMainMenu.class);
            startActivity(intent1);
        } else if (te.equals("5")) {
            connectivity(te);
            Intent intent2 = new Intent(this, MainCourseMenu.class);
            startActivity(intent2);
        } else if (te.equals("6")) {
            connectivity(te);
            Intent intent3 = new Intent(this, SideDishMainMenu.class);
            startActivity(intent3);
        } else if (te.equals("7")) {
            connectivityForFood(te);
            Intent intent4 = new Intent(this, RiceDishMainMenu.class);
            startActivity(intent4);
        } else if (te.equals("8")) {
            connectivityForFood(te);
            Intent intent5 = new Intent(this, SunDriesMainMenu.class);
            startActivity(intent5);
        } else if (te.equals("9")) {
            connectivityForFood(te);
            Intent intent6 = new Intent(this, ChildrensMenu.class);
            startActivity(intent6);
        } else if (te.equals("10")) {
            connectivityForFood(te);
            Intent intent7 = new Intent(this, DessertsMainMenu.class);
            startActivity(intent7);
        } else if (te.equals("11")) {
            connectivityForFood(te);
            Intent intent8 = new Intent(this, DrinksMenu.class);
            startActivity(intent8);
        } else if (te.equals("12")) {
            connectivityForFood(te);
            Intent intent9 = new Intent(this, SetMeal.class);
            startActivity(intent9);
        }
    }

    // @params - Menu Options created
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
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                Log.i("Shopping","Selected");
                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);
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


    public void connectivity(String id) {

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
                    "WHERE IEM_TYPE = 2\n" +
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
                food1.add(new SubCategoryItemTag(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(6),rs.getString(7), rs.getString(5)));

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
                food1.add(new SubCategoryItemTag(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(5)));

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