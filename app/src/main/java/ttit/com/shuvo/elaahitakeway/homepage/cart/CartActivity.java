package ttit.com.shuvo.elaahitakeway.homepage.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.MainActivity;
import ttit.com.shuvo.elaahitakeway.homepage.order.PlaceOrderActivity;

public class CartActivity extends AppCompatActivity {

    private Button confirm, moreOrder;
    public static ArrayList<CartItem> myCartList = new ArrayList<>();
    public static ArrayList<CartItem> mainFoodList = new ArrayList<>();
    private RecyclerView cartRecyclerView;
    public static CartAdapter myCartAdapter;
    private RecyclerView.LayoutManager cartLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        getSupportActionBar().setTitle("CART");

        confirm = findViewById(R.id.confirm_order);
        moreOrder = findViewById(R.id.order_more);

//        myCartList.add(new CartItem("Burger", "1"));
//        myCartList.add(new CartItem("Pizza", "3"));

        cartRecyclerView = findViewById(R.id.cart_view);
        cartRecyclerView.setHasFixedSize(true);
        cartLayoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(cartLayoutManager);




        //myCartAdapter = new CartAdapter(CartActivity.this, QuantityDialog.cartItems);
        myCartAdapter = new CartAdapter(CartActivity.this, mainFoodList);
        cartRecyclerView.setAdapter(myCartAdapter);
        //myCartList = QuantityDialog.cartItems;


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myCartList = mainFoodList;
                Intent intent = new Intent(getApplicationContext(), PlaceOrderActivity.class);
                startActivity(intent);
            }
        });

        moreOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
//        Intent in = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(in);
        finish();
    }
}