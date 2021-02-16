package ttit.com.shuvo.elaahitakeway.homepage.festivalfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.MainActivity;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.AdultFestiveCategory;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.ChildFestiveCategory;

public class FestivalActivity extends AppCompatActivity {

    private TextView categoryName;
    private TextView adult;
    private TextView child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);
        categoryName = findViewById(R.id.category);
        adult = findViewById(R.id.festive_adult);
        child = findViewById(R.id.festive_child);
        Intent intent = getIntent();
        String categoryValue = intent.getStringExtra("category");

        if (categoryValue == null) {
            categoryName.setText("Festival Food");
        } else {
            categoryName.setText(categoryValue);
        }


    }

    public void adultFood(View view) {

        Intent intent = new Intent(this, AdultFestiveCategory.class);
        intent.putExtra("CategoryName", categoryName.getText().toString());
        intent.putExtra("SubCategoryName", adult.getText().toString());
        startActivity(intent);
        finish();
    }

    public void childFood (View view) {

        Intent intent = new Intent(this, ChildFestiveCategory.class);
        intent.putExtra("CategoryName", categoryName.getText().toString());
        intent.putExtra("SubCategoryName", child.getText().toString());
        startActivity(intent);
        finish();
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