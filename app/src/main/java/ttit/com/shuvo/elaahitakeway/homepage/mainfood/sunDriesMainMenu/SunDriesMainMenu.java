
package ttit.com.shuvo.elaahitakeway.homepage.mainfood.sunDriesMainMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser.AppitiserMainMenuAdapter;

public class SunDriesMainMenu extends AppCompatActivity {

    public static ArrayList<NormalFoodItem> mySunItem;

    private RecyclerView sunView;
    private AppitiserMainMenuAdapter sunAdapter;
    private RecyclerView.LayoutManager sunlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun_dries_main_menu);

        getSupportActionBar().setTitle("SUNDRIES");

        mySunItem = new ArrayList<>();

        mySunItem.add(new NormalFoodItem("Plain Nan","", "£2.35"));
        mySunItem.add(new NormalFoodItem("Keema Nan","", "£2.55"));
        mySunItem.add(new NormalFoodItem("Garlic Nan","", "£2.55"));
        mySunItem.add(new NormalFoodItem("Coriander Nan","", "£2.55"));
        mySunItem.add(new NormalFoodItem("Cheese Naan","", "£2.55"));
        mySunItem.add(new NormalFoodItem("Peshwari Nan","", "£2.55"));
        mySunItem.add(new NormalFoodItem("Chunky Chips","", "£1.85"));
        mySunItem.add(new NormalFoodItem("Spicy Peri Peri Fries (New)","", "£2.85"));
        mySunItem.add(new NormalFoodItem("Chapatti","", "£1.50"));

        sunView = findViewById(R.id.sun_dries_main_menu);
        sunView.setHasFixedSize(true);
        sunlayout = new LinearLayoutManager(this);
        sunView.setLayoutManager(sunlayout);

        sunAdapter = new AppitiserMainMenuAdapter(this, mySunItem);
        sunView.setAdapter(sunAdapter);

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