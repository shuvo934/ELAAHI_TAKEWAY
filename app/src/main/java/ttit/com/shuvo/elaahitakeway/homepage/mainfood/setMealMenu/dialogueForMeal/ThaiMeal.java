package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.dialogueForMeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.CheckBoxListNew;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.SetMeal;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.TandooriSMAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu.adapter.ThaiAdapter;

public class ThaiMeal extends AppCompatActivity {

    public ArrayList<CheckBoxListNew> tandooriSetMeal;
    private RecyclerView tandooriview;
    private ThaiAdapter tandoAdapter;
    private RecyclerView.LayoutManager tandoLayout;

    private Button ok;

    private String tan = "";

    public static int totalSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thai_meal);

        getSupportActionBar().hide();

        totalSelected = 2;
        ok = findViewById(R.id.thai_ok);

        tandooriSetMeal = new ArrayList<>();
        tandooriSetMeal.add(new CheckBoxListNew("Bangla Chicken  HOT", "Fresh chicken breast fillets cooked with bay leaves, cinnamon and garlic using fresh onions and selected spices",false));
        tandooriSetMeal.add(new CheckBoxListNew("Bangla Chicken  MILD", "Fresh chicken breast fillets cooked with bay leaves, cinnamon and garlic using fresh onions and selected spices",false));
        tandooriSetMeal.add(new CheckBoxListNew("Vegetable Kashmiri", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Vegetable Bangla", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Vegetable Kurma", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Bangla Chicken  Medium", "Fresh chicken breast fillets cooked with bay leaves, cinnamon and garlic using fresh onions and selected spices",false));
        tandooriSetMeal.add(new CheckBoxListNew("Vegetable Mossalla", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Vegetable Balti  Medium", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Chicken Nepal  SPICY", "Cooked with chunky onions and peppers in a spicy garlic and chilli Nepalese sauce.",false));
        tandooriSetMeal.add(new CheckBoxListNew("Chicken Balti", "",false));
        tandooriSetMeal.add(new CheckBoxListNew("Kashmiri Chicken  HOT", "Marinated chicken cooked in the clay oven and further cooked on a pan with chunky onions, pepper, plum tomatoes and Kashmiri spices. You can choose the strength of this dish (medium or hot) from the pop-up that appears",false));
        tandooriSetMeal.add(new CheckBoxListNew("Chicken Tikka Massala", "(served with pilau rice)",false));

        tandooriview = findViewById(R.id.thai_view);
        tandooriview.setHasFixedSize(true);
        tandoLayout = new LinearLayoutManager(this);
        tandooriview.setLayoutManager(tandoLayout);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(tandooriview.getContext(),DividerItemDecoration.VERTICAL);
        tandooriview.addItemDecoration(dividerItemDecoration);
        tandoAdapter = new ThaiAdapter(this, tandooriSetMeal);
        tandooriview.setAdapter(tandoAdapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = SetMeal.starterTitle;
                String ppp = SetMeal.setMealPrice;
                for (int i = 0; i < tandooriSetMeal.size(); i++) {
                    if (tandooriSetMeal.get(i).getCheckedItem() == true) {
                        tan += "\n" + tandooriSetMeal.get(i).getCheckBoxItem();
                        Log.i("Item vegan sidess", tan);
                        Log.i("Item vegan side", tandooriSetMeal.get(i).getCheckBoxItem());
                    }
                }
                if (tan.isEmpty()) {
                    tan = "\n-------";
                }
                CartActivity.mainFoodList.add(new CartItem(text + "\n" + tan, "1", ppp));
                Toast.makeText(getApplicationContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}