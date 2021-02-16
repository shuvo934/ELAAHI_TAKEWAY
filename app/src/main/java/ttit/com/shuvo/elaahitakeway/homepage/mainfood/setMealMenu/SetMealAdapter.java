package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;


public class SetMealAdapter extends RecyclerView.Adapter<SetMealAdapter.SetMealViewHolder> {

    public ArrayList<NormalFoodItem> itemsOfStarter;
    public Context starterContext;
    private ClickedStarterItem myStarterItem;

    public static String foodNameFromAdapter;
    public static String priceFormAdapter;

    public SetMealAdapter(Context myContext, ArrayList<NormalFoodItem> starterItems, ClickedStarterItem csi) {
        this.itemsOfStarter = starterItems;
        this.starterContext = myContext;
        this.myStarterItem = csi;
    }

    public interface ClickedStarterItem {
        void onStarterItemClicked(int starterItemPosition);
    }

    @NonNull
    @Override
    public SetMealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(starterContext).inflate(R.layout.set_meal_item, parent, false);
        SetMealViewHolder svh = new SetMealViewHolder(v, myStarterItem);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull SetMealViewHolder holder, int position) {

        NormalFoodItem starterItem = itemsOfStarter.get(position);

        holder.starterItemName.setText(starterItem.getMyFood());
        holder.starterItemDescription.setText(starterItem.getMyFoodDesc());
        holder.starterCount.setText(starterItem.getMyFoodPrice());


        if (holder.starterItemName.getText().toString().endsWith("V")) {

            String text = holder.starterItemName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-1, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.starterItemName.setText(ss);
            Log.i("paisi",holder.starterItemName.getText().toString());

        }

    }

    @Override
    public int getItemCount() {
        return itemsOfStarter.size();
    }

    public class SetMealViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView starterItemName;
        public TextView starterItemDescription;
        public ImageView selectedItem;
        public TextView starterCount;
        ClickedStarterItem clickedStarterItem;

        public SetMealViewHolder(@NonNull View itemView, ClickedStarterItem cI) {
            super(itemView);
            starterItemName = itemView.findViewById(R.id.set_meal_item_name);
            starterItemDescription = itemView.findViewById(R.id.set_meal_description);
            //selectedItem = itemView.findViewById(R.id.starter_item_selected);
            starterCount = itemView.findViewById(R.id.set_meal_price);
            this.clickedStarterItem = cI;
            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View v) {
            clickedStarterItem.onStarterItemClicked(getAdapterPosition());
            Log.i("Starter Name", itemsOfStarter.get(getAdapterPosition()).getMyFood());
            foodNameFromAdapter = itemsOfStarter.get(getAdapterPosition()).getMyFood();
            priceFormAdapter = itemsOfStarter.get(getAdapterPosition()).getMyFoodPrice();
        }
    }
}
