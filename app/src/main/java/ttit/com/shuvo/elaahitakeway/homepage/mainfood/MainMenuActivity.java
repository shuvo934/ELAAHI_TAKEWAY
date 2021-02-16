package ttit.com.shuvo.elaahitakeway.homepage.mainfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser.AppitiserMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.childrensMenuMain.ChildrensMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dessertsMainMenu.DessertsMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.drinksMenu.DrinksMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.riceDishMainMenu.RiceDishMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.SetMeal;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.SideDishMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.StarterMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sunDriesMainMenu.SunDriesMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.order.PlaceOrderActivity;

public class MainMenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }


    public void menuItemClicked(View v) {
        switch (v.getId()) {
            case R.id.main_menu_appitiser:
                Intent intent = new Intent(this, AppitiserMainMenu.class);
                startActivity(intent);
                break;
            case R.id.main_menu_starter:
                Intent intent1 = new Intent(this, StarterMainMenu.class);
                startActivity(intent1);
                break;
            case R.id.main_menu_mainCourse:
                Intent intent2 = new Intent(this, MainCourseMenu.class);
                startActivity(intent2);
                break;
            case R.id.main_menu_side_dishes:
                Intent intent3 = new Intent(this, SideDishMainMenu.class);
                startActivity(intent3);
                break;
            case R.id.main_menu_rice_dishes:
                Intent intent4 = new Intent(this, RiceDishMainMenu.class);
                startActivity(intent4);
                break;
            case R.id.main_menu_sun_dries:
                Intent intent5 = new Intent(this, SunDriesMainMenu.class);
                startActivity(intent5);
                break;
            case R.id.main_menu_children_menu:
                Intent intent6 = new Intent(this, ChildrensMenu.class);
                startActivity(intent6);
                break;
            case R.id.main_menu_dessert:
                Intent intent7 = new Intent(this, DessertsMainMenu.class);
                startActivity(intent7);
                break;
            case R.id.main_menu_drinks:
                Intent intent8 = new Intent(this, DrinksMenu.class);
                startActivity(intent8);
                break;
            case R.id.main_menu_set_meal:
                Intent intent9 = new Intent(this, SetMeal.class);
                startActivity(intent9);
                break;
            default:
                break;
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