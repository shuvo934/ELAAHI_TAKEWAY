package ttit.com.shuvo.elaahitakeway.homepage.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import ttit.com.shuvo.elaahitakeway.R;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    public ArrayList<OrderItem> mOrder;
    private Context mContext;

    public OrderAdapter(Context context, ArrayList<OrderItem> orderItems) {
        this.mContext = context;
        this.mOrder = orderItems;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.place_order_food_item, parent,false);
        OrderViewHolder ovh = new OrderViewHolder(v);
        return ovh;

    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        OrderItem oItem = mOrder.get(position);

        holder.item.setText(oItem.getMyItemNo());
        holder.orderFood.setText(oItem.getMyOrderFood());
        holder.priceTag.setText(oItem.getMyPriceTag());
        holder.quantityActual.setText(oItem.getMyQuantity());

    }

    @Override
    public int getItemCount() {
        return mOrder.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{

        public TextView item;
        public TextView orderFood;
        public TextView priceTag;
        public TextView quantityActual;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item_no);
            orderFood = itemView.findViewById(R.id.order_food_name);
            priceTag = itemView.findViewById(R.id.price_tag);
            quantityActual = itemView.findViewById(R.id.number_of_quantity);
        }
    }
}