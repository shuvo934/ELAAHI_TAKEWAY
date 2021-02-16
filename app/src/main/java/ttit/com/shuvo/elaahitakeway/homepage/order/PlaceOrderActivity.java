package ttit.com.shuvo.elaahitakeway.homepage.order;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.cart.CartActivity;
import ttit.com.shuvo.elaahitakeway.homepage.order.fragment.DeliveryFragment;
import ttit.com.shuvo.elaahitakeway.homepage.order.fragment.PickUpFragment;
import ttit.com.shuvo.elaahitakeway.homepage.order.ui.main.SectionsPagerAdapter;

public class PlaceOrderActivity extends AppCompatActivity {

    ArrayList<OrderItem> myOrder;
    private TextView amount;
    private RecyclerView orderRecyclerView;
    private OrderAdapter myOrderAdapter;
    private RecyclerView.LayoutManager orderlayoutManager;
    private Button placeOrder;
    public static String allData = "BALBAL";
    public static String foodorder = "Order Placed";
    private String foodde = null;
    private String itemno = "ITEM NO:- ";
    private String food = "FOOD:- ";
    private String qtt = "QUANTITY:-";
    private String totalprice = "TOTAL PRICE:- ";

    private TextView titleName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        titleName = findViewById(R.id.title);


        String tab1 = tabs.getTabAt(0).getText().toString();
        String tab2 = tabs.getTabAt(1).getText().toString();

        if (tabs.getSelectedTabPosition() == 0) {
            titleName.setText("PLACE ORDER--" + tab1);
        } else {
            titleName.setText("PLACE ORDER--" + tab2);
        }

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                titleName.setText("PLACE ORDER--" + tab.getText().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        SpannableString ss = new SpannableString(foodorder);
        SpannableString ssi = new SpannableString(itemno);
        SpannableString ssf = new SpannableString(food);
        SpannableString ssq = new SpannableString(qtt);
        SpannableString sst = new SpannableString(totalprice);
        SpannableString sst1 = new SpannableString(tab1);
        SpannableString sst2 = new SpannableString(tab2);
        ss.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0, foodorder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssi.setSpan(new ForegroundColorSpan(Color.RED), 0, itemno.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssf.setSpan(new ForegroundColorSpan(Color.RED), 0, food.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssq.setSpan(new ForegroundColorSpan(Color.RED), 0, qtt.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sst.setSpan(new ForegroundColorSpan(Color.RED), 0, totalprice.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sst1.setSpan(new ForegroundColorSpan(Color.RED), 0, tab1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sst2.setSpan(new ForegroundColorSpan(Color.RED), 0, tab2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);





        myOrder = new ArrayList<>();
        amount = findViewById(R.id.total_amount);
        placeOrder = findViewById(R.id.place_order_btn);

        CartActivity activity = new CartActivity();

        for (int i = 0; i < activity.myCartList.size(); i++) {

            String foodPlace = activity.myCartList.get(i).getMyCartFood();
            String quantities = activity.myCartList.get(i).getMyFoodQuantity();
            String items = String.valueOf(i + 1);
            String prices = activity.myCartList.get(i).getMyPrices();
            myOrder.add(new OrderItem(foodPlace, items, prices, quantities));
        }
        Double priceTwo = 0.0;
        foodde = "";

        for (int i = 0; i< myOrder.size(); i++) {

            String pricesss = myOrder.get(i).getMyPriceTag();
            pricesss = pricesss.substring(1);
            Log.i("price", pricesss);
            Double priceOne = Double.parseDouble(pricesss);
            Double quantity = Double.parseDouble(myOrder.get(i).getMyQuantity());

            Double total = priceOne * quantity;
            Log.i("firstPrice", String.valueOf(priceOne));
            priceTwo = priceTwo + total;
            Log.i("2nd Price", String.valueOf(priceTwo));

            String text = ssi + myOrder.get(i).myItemNo + "\n\n" + ssf + myOrder.get(i).getMyOrderFood() + "\n\n" + ssq + myOrder.get(i).getMyQuantity() + "\n";
            foodde = foodde + "\n\n\n" + text;

        }

        String finalPrice = String.format("%.2f",priceTwo);
        amount.setText("£ "+finalPrice);


//        myOrder.add(new OrderItem("Burger","1","100","3"));





        orderRecyclerView = findViewById(R.id.place_order_view);
        orderRecyclerView.setHasFixedSize(true);
        orderlayoutManager = new LinearLayoutManager(this);
        orderRecyclerView.setLayoutManager(orderlayoutManager);

        myOrderAdapter = new OrderAdapter(PlaceOrderActivity.this, myOrder);
        orderRecyclerView.setAdapter(myOrderAdapter);
        //FloatingActionButton fab = findViewById(R.id.fab);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tabs.getSelectedTabPosition() == 0) {

                    allData = ss + "\n\n" + foodde + "\n\n\n\n" + sst + finalPrice + "\n\n\n\n" + sst1 + "\n\n" + "DATE:- " + PickUpFragment.myDate.getText().toString() +
                            "\nTIME:- " + PickUpFragment.myTime.getText().toString() + "\nNOTE:- " + PickUpFragment.myNote.getText().toString() + "\nDEPOSITE AMOUNT:- "
                            + PickUpFragment.depAm.getText().toString();


                    Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
                    startActivity(intent);
                } else if (tabs.getSelectedTabPosition() == 1) {

                    Log.i("Pressed", tabs.getTabAt(1).getText().toString());
                    allData = foodde + "\n\n\n\n" + sst + finalPrice + "\n\n\n\n" + sst2 + "\n\n" + "DATE:- " + DeliveryFragment.myDate.getText().toString() +
                            "\nTIME:- " + DeliveryFragment.myTime.getText().toString() + "\nDELIVERY ADDRESS:- " + DeliveryFragment.deliveryAddss.getText().toString() +
                            "\nPOSTAL CODE:- " + DeliveryFragment.postalC.getText().toString() + "\nNOTE:- " + DeliveryFragment.noteDeli.getText().toString() +
                            "\nDEPOSIT AMOUNT:- " + DeliveryFragment.depAmDelivery.getText().toString();



                    Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
                    startActivity(intent);
                }
            }
        });


    }


}



