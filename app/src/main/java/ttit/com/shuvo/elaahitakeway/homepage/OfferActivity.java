package ttit.com.shuvo.elaahitakeway.homepage;

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

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.ElahiActivity;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.FestivalActivity;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.MainCategoryMenu;

import static ttit.com.shuvo.elaahitakeway.homepage.MainActivity.offerCategoryName;

public class OfferActivity extends AppCompatActivity implements CategoryAdapter.ClickedItem {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        recyclerView = findViewById(R.id.offer_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CategoryAdapter(offerCategoryName, this::onCategoryClicked);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onCategoryClicked(int CategoryPosition) {
        String te = offerCategoryName.get(CategoryPosition).getIem_id();
        if (te.equals("1")) {
            String name = offerCategoryName.get(CategoryPosition).getmText();
            Intent intent = new Intent(this, FestivalActivity.class);
            intent.putExtra("category", name);
            startActivity(intent);
            finish();

        } else if (te.equals("2")){
            //Log.i("TEXT", te);
            String name = offerCategoryName.get(CategoryPosition).getmText();
            Intent intent = new Intent(this, ElahiActivity.class);
            intent.putExtra("categoryElahi", name);
            startActivity(intent);
            finish();

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
}