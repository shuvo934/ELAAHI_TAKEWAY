package ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser;

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
import android.widget.Toast;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;

public class AppitiserMainMenu extends AppCompatActivity {

    public static ArrayList<NormalFoodItem> myApptItemMainMenu;

    private RecyclerView normalFoodView;
    private AppitiserMainMenuAdapter aptMainMenuAdapter;
    private RecyclerView.LayoutManager aptLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appitiser_main_menu);

        getSupportActionBar().setTitle("APPERTISERS");

        myApptItemMainMenu = new ArrayList<>();

        myApptItemMainMenu.add(new NormalFoodItem("Popadom","", "£0.65"));
        myApptItemMainMenu.add(new NormalFoodItem("Onion Salad VE","", "£0.65"));
        myApptItemMainMenu.add(new NormalFoodItem("Mango chutney VE","", "£0.65"));
        myApptItemMainMenu.add(new NormalFoodItem("Mint Sauce VE","", "£0.65"));
        myApptItemMainMenu.add(new NormalFoodItem("Sweet Chilli Sauce VE","", "£0.65"));
        myApptItemMainMenu.add(new NormalFoodItem("Chilli Pickle","", "£0.70"));
        myApptItemMainMenu.add(new NormalFoodItem("Lime Pickle VE","", "£0.70"));
        myApptItemMainMenu.add(new NormalFoodItem("Peri peri hot sauce VE","", "£0.70"));
        myApptItemMainMenu.add(new NormalFoodItem("Pickle Platter VE","", "£2.10"));

        normalFoodView = findViewById(R.id.normal_main_menu_view);
        normalFoodView.setHasFixedSize(true);
        aptLayout = new LinearLayoutManager(this);
        normalFoodView.setLayoutManager(aptLayout);

        aptMainMenuAdapter = new AppitiserMainMenuAdapter(this, myApptItemMainMenu);
        normalFoodView.setAdapter(aptMainMenuAdapter);
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