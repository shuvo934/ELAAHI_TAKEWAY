package ttit.com.shuvo.elaahitakeway.homepage.mainfood.dessertsMainMenu;

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

public class DessertsMainMenu extends AppCompatActivity {

    public static ArrayList<NormalFoodItem> myRiceItem;

    private RecyclerView riceView;
    private AppitiserMainMenuAdapter riceAdapter;
    private RecyclerView.LayoutManager riceLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts_main_menu);

        getSupportActionBar().setTitle("DESSERTS");

        myRiceItem = new ArrayList<>();

        myRiceItem.add(new NormalFoodItem("Gulab Jaman (V) (N)","(Delicate dough balls consisting of milk & flour dipped in sugar syrup, flavoured with cardamon seeds & rose water. Served with fresh cream)", "£2.60"));
        myRiceItem.add(new NormalFoodItem("Chocolate Fudge Cake","", "£2.60"));
        myRiceItem.add(new NormalFoodItem("Vanilla Cheesecake & Coulis","", "£2.60"));
        riceView = findViewById(R.id.desserts_main_menu);
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