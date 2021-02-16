package ttit.com.shuvo.elaahitakeway.homepage.mainfood.drinksMenu;

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

public class DrinksMenu extends AppCompatActivity {

    public static ArrayList<NormalFoodItem> myRiceItem;

    private RecyclerView riceView;
    private AppitiserMainMenuAdapter riceAdapter;
    private RecyclerView.LayoutManager riceLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_menu);

        getSupportActionBar().setTitle("DRINKS");

        myRiceItem = new ArrayList<>();

        myRiceItem.add(new NormalFoodItem("Rubicon Mango","", "£1.10"));
        myRiceItem.add(new NormalFoodItem("Rubicon Guava","", "£1.10"));
        myRiceItem.add(new NormalFoodItem("Rubicon Lychee","", "£1.10"));
        myRiceItem.add(new NormalFoodItem("Fruit Juices Orange","", "£1.20"));
        myRiceItem.add(new NormalFoodItem("Fruit Juices Mango","", "£1.20"));
        myRiceItem.add(new NormalFoodItem("Fruit Juices Apple","", "£1.20"));
        myRiceItem.add(new NormalFoodItem("Diet Coke","", "£1.10"));
        myRiceItem.add(new NormalFoodItem("Coke","", "£1.10"));


        riceView = findViewById(R.id.drinks_main_menu);
        riceView.setHasFixedSize(true);
        riceLayout = new LinearLayoutManager(this);
        riceView.setLayoutManager(riceLayout);

        riceAdapter = new AppitiserMainMenuAdapter(this, myRiceItem);
        riceView.setAdapter(riceAdapter);
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