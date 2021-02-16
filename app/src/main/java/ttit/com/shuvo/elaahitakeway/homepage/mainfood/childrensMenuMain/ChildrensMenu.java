package ttit.com.shuvo.elaahitakeway.homepage.mainfood.childrensMenuMain;

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

public class ChildrensMenu extends AppCompatActivity {

    public static ArrayList<NormalFoodItem> myRiceItem;

    private RecyclerView riceView;
    private AppitiserMainMenuAdapter riceAdapter;
    private RecyclerView.LayoutManager riceLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childrens_menu);

        getSupportActionBar().setTitle("CHILDRENS MENU");

        myRiceItem = new ArrayList<>();

        myRiceItem.add(new NormalFoodItem("Chicken Nuggets","(served with chips)", "£4.85"));
        myRiceItem.add(new NormalFoodItem("Fish Fingers","(served with chips)", "£4.85"));
        myRiceItem.add(new NormalFoodItem("Chicken Burger","(served with chips)", "£4.85"));
        myRiceItem.add(new NormalFoodItem("Child's Tandoori Chicken","(served with chips)", "£4.85"));
        myRiceItem.add(new NormalFoodItem("Chicken tikka","(served with chips)", "£4.85"));
        myRiceItem.add(new NormalFoodItem("Seek Kebab","(served with chips)", "£4.85"));
        myRiceItem.add(new NormalFoodItem("Chicken Tikka Massala","(served with pilau rice)", "£4.85"));
        myRiceItem.add(new NormalFoodItem("Chicken Korma","(served with pilau rice)", "£4.85"));
        myRiceItem.add(new NormalFoodItem("Chicken Bhuna","(served with pilau rice)", "£4.85"));

        riceView = findViewById(R.id.childrens_menu);
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