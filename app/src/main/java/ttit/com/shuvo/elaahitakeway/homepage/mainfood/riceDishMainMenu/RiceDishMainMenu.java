package ttit.com.shuvo.elaahitakeway.homepage.mainfood.riceDishMainMenu;

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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser.ApptestAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.MainCategoryMenu.food1;

public class RiceDishMainMenu extends AppCompatActivity {

    public static ArrayList<NormalFoodItem> myRiceItem;

    private RecyclerView riceView;
    private AppitiserMainMenuAdapter riceAdapter;
    private RecyclerView.LayoutManager riceLayout;

    public static ArrayList<SubCategoryItemTag> rrdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice_dish_main_menu);

        getSupportActionBar().setTitle("RICE DISHES");

        rrdd = new ArrayList<>();

        rrdd = food1;

        myRiceItem = new ArrayList<>();

//        myRiceItem.add(new NormalFoodItem("Boiled Rice","", "£2.45"));
//        myRiceItem.add(new NormalFoodItem("Pilau Rice","", "£2.60"));
//        myRiceItem.add(new NormalFoodItem("Egg Rice","", "£2.90"));
//        myRiceItem.add(new NormalFoodItem("Mushroom Rice","", "£2.90"));
//        myRiceItem.add(new NormalFoodItem("Vegetable Rice","", "£2.90"));
//        myRiceItem.add(new NormalFoodItem("Chana Rice","", "£2.90"));
//        myRiceItem.add(new NormalFoodItem("Sweet Coconut Rice","", "£2.90"));
//        myRiceItem.add(new NormalFoodItem("Lemon Rice","", "£2.90"));
//        myRiceItem.add(new NormalFoodItem("Keema Rice","", "£2.90"));

        riceView = findViewById(R.id.rice_dish_main_menu_view);
        riceView.setHasFixedSize(true);
        riceLayout = new LinearLayoutManager(this);
        riceView.setLayoutManager(riceLayout);

        riceAdapter = new AppitiserMainMenuAdapter(this, rrdd);
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
}