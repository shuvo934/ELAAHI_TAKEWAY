package ttit.com.shuvo.elaahitakeway.homepage.cart;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {


    public ArrayList<CartItem> mCartList;
    private Context mContext;

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cart_item, parent, false);
        CartViewHolder cvh = new CartViewHolder(v);

        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        CartItem myItem = mCartList.get(position);

        holder.cartFood.setText(myItem.getMyCartFood());
        holder.foodQuantity.setText(myItem.getMyFoodQuantity());
        holder.foodPrice.setText(myItem.getMyPrices());

        String text = holder.cartFood.getText().toString();
        SpannableString ss1 = new SpannableString(text);

        if (myItem.getMyCartFood().contains("Festival Food") || myItem.getMyCartFood().contains("Elaahi Specials")) {
            holder.addQuantityButton.setVisibility(View.INVISIBLE);
            holder.minusQuantityButton.setVisibility(View.INVISIBLE);
        }else {
            holder.addQuantityButton.setVisibility(View.VISIBLE);
            holder.minusQuantityButton.setVisibility(View.VISIBLE);
        }

//        if (holder.cartFood.getText().toString().endsWith("(V) (N)")) {
//
//            String text = holder.cartFood.getText().toString();
//            SpannableString ss = new SpannableString(text);
//            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-7, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            holder.cartFood.setText(ss);
//            Log.i("paisi",holder.cartFood.getText().toString());
//
//        }
//
//        if (holder.cartFood.getText().toString().endsWith("VE")) {
//
//            String text = holder.cartFood.getText().toString();
//            SpannableString ss = new SpannableString(text);
//            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            holder.cartFood.setText(ss);
//            Log.i("paisi",holder.cartFood.getText().toString());
//
//        }
//        if (holder.cartFood.getText().toString().endsWith("V")) {
//
//            String text = holder.cartFood.getText().toString();
//            SpannableString ss = new SpannableString(text);
//            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-1, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            holder.cartFood.setText(ss);
//            Log.i("paisi",holder.cartFood.getText().toString());
//
//        }
//        if (holder.cartFood.getText().toString().endsWith("HOT"))  {
//
//            String text = holder.cartFood.getText().toString();
//            SpannableString ss = new SpannableString(text);
//            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-3, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            holder.cartFood.setText(ss);
//            Log.i("paisi",holder.cartFood.getText().toString());
//
//        }
//
//        if ( holder.cartFood.getText().toString().endsWith("Medium")) {
//            String text = holder.cartFood.getText().toString();
//            SpannableString ss = new SpannableString(text);
//            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-6, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            holder.cartFood.setText(ss);
//            //Log.i("paisi",holder.appitisernName.getText().toString());
//        }
//        if ( holder.cartFood.getText().toString().endsWith("SPICY")) {
//            String text = holder.cartFood.getText().toString();
//            SpannableString ss = new SpannableString(text);
//            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-5, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            holder.cartFood.setText(ss);
//            //Log.i("paisi",holder.appitisernName.getText().toString());
//        }
//        if ( holder.cartFood.getText().toString().endsWith("MILD")) {
//            String text = holder.cartFood.getText().toString();
//            SpannableString ss = new SpannableString(text);
//            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-4, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            holder.cartFood.setText(ss);
//            //Log.i("paisi",holder.appitisernName.getText().toString());
//        }
        if (holder.cartFood.getText().toString().contains("HOT") ) {

            for (int i = -1; (i = text.indexOf("HOT", i + 1)) != -1; i++) {
                System.out.println(i);
                ss1.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)), i, i + 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        if (holder.cartFood.getText().toString().contains("MILD") ) {

            for (int i = -1; (i = text.indexOf("MILD", i + 1)) != -1; i++) {
                System.out.println(i);
                ss1.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)), i, i + 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        if (holder.cartFood.getText().toString().contains("SPICY") ) {

            for (int i = -1; (i = text.indexOf("SPICY", i + 1)) != -1; i++) {
                System.out.println(i);
                ss1.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)), i, i + 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        if (holder.cartFood.getText().toString().contains("Medium") ) {

            for (int i = -1; (i = text.indexOf("Medium", i + 1)) != -1; i++) {
                System.out.println(i);
                ss1.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)), i, i + 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
//        if (holder.cartFood.getText().toString().contains("V") ) {
//
//            for (int i = -1; (i = text.indexOf("V", i + 1)) != -1; i++) {
//                System.out.println(i);
//                ss1.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
        if (holder.cartFood.getText().toString().contains("VE") ) {

            for (int i = -1; (i = text.indexOf("VE", i + 1)) != -1; i++) {
                System.out.println(i);
                ss1.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)), i, i + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        if (holder.cartFood.getText().toString().contains("(V) (N)") ) {

            for (int i = -1; (i = text.indexOf("(V) (N)", i + 1)) != -1; i++) {
                System.out.println(i);
                ss1.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),i, i + 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        holder.cartFood.setText(ss1);
//        for (CartItem item : mCartList) {
//            if (item.getMyCartFood().contains("Festival Food") || item.getMyCartFood().contains("Elaahi Specials")) {
//                holder.addQuantityButton.setVisibility(View.INVISIBLE);
//            } else {
//                holder.addQuantityButton.setVisibility(View.VISIBLE);
//            }
//        }

    }

    @Override
    public int getItemCount() {
        return mCartList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        public TextView cartFood;
        public TextView foodPrice;
        public TextView foodQuantity;
        public Button addQuantityButton;
        public Button minusQuantityButton;
        public ImageButton removeFoodButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartFood = itemView.findViewById(R.id.cart_food_name);
            foodPrice = itemView.findViewById(R.id.prices);
            foodQuantity = itemView.findViewById(R.id.actual_quantity);
            addQuantityButton = itemView.findViewById(R.id.add_quantity);
            minusQuantityButton = itemView.findViewById(R.id.minus_quantity);
            removeFoodButton = itemView.findViewById(R.id.remove_from_cart);




            addQuantityButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = foodQuantity.getText().toString();
                    int num = Integer.parseInt(text);
                    int add = num + 1;
                    foodQuantity.setText(String.valueOf(add));
                    mCartList.get(getAdapterPosition()).setMyFoodQuantity(String.valueOf(add));

                }

            });

            minusQuantityButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = foodQuantity.getText().toString();
                    int num = Integer.parseInt(text);

                    if (num == 1) {
                        return;
                    }else {
                        int minus = num -1;
                        foodQuantity.setText(String.valueOf(minus));
                        mCartList.get(getAdapterPosition()).setMyFoodQuantity(String.valueOf(minus));


                    }
                }
            });

            removeFoodButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCartList.remove(getAdapterPosition());
                    CartActivity.myCartAdapter.notifyDataSetChanged();
                }
            });

        }
    }

    public CartAdapter(Context context, ArrayList<CartItem> cartItems) {
        mContext = context;
        mCartList = cartItems;
    }

}
