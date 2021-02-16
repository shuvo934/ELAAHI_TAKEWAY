package ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.dialogueBOXForItem.ClassicDish;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.dialogueBOXForItem.VeganSIDEDish;

public class SideDishMainMenu extends AppCompatActivity implements SideDishMainMenuAdapter.ClickedStarterItem {

    private RecyclerView sideDishView;
    private RecyclerView.LayoutManager sideDishLayout;
    public SideDishMainMenuAdapter sideDishAdapter;
    private Button sideDishOk;
    public static String starterTitle = "Food";

    public static ArrayList<StarterItem> mySideDishItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_dish_main_menu);

        getSupportActionBar().setTitle("SIDE DISHES");

        sideDishOk = findViewById(R.id.sideDish_ok_mainMenu);

        mySideDishItem = new ArrayList<>();
        mySideDishItem.add(new StarterItem("CLASSIC SIDE DISHES", "","0"));
        mySideDishItem.add(new StarterItem("VEGAN SIDE DISHES", "","0"));

        sideDishView = findViewById(R.id.sideDishRecycle_mainMenu);
        sideDishView.setHasFixedSize(true);
        sideDishLayout = new LinearLayoutManager(this);
        sideDishView.setLayoutManager(sideDishLayout);

        sideDishAdapter = new SideDishMainMenuAdapter(this, mySideDishItem, this::onStarterItemClicked);
        sideDishView.setAdapter(sideDishAdapter);

        sideDishOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        String item = mySideDishItem.get(starterItemPosition).getTypeOfFood();
        if (item.equals("CLASSIC SIDE DISHES")) {
            starterTitle = "CLASSIC SIDE DISHES";
            ClassicDish classicDish = new ClassicDish();
            classicDish.show(getSupportFragmentManager(),"CLDISH");


        }else if (item.equals("VEGAN SIDE DISHES")) {
            starterTitle = "VEGAN SIDE DISHES";
            VeganSIDEDish veganSIDEDish = new VeganSIDEDish();
            veganSIDEDish.show(getSupportFragmentManager(),"VESIDI");


        }
    }
}