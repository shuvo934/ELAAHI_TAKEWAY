package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters;

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

public class StarterItemAdapter extends RecyclerView.Adapter<StarterItemAdapter.StarterItemViewHolder> {

    public ArrayList<StarterItem> itemsOfStarter;
    public Context starterContext;
    private ClickedStarterItem myStarterItem;

    public StarterItemAdapter(Context myContext, ArrayList<StarterItem> starterItems, ClickedStarterItem csi) {
        this.itemsOfStarter = starterItems;
        this.starterContext = myContext;
        this.myStarterItem = csi;
    }

    public interface ClickedStarterItem {
        void onStarterItemClicked(int starterItemPosition);
    }

    @NonNull
    @Override
    public StarterItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(starterContext).inflate(R.layout.elaahi_adult_starter_item, parent, false);
        StarterItemViewHolder svh = new StarterItemViewHolder(v, myStarterItem);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StarterItemViewHolder holder, int position) {

        StarterItem starterItem = itemsOfStarter.get(position);

        holder.starterItemName.setText(starterItem.getTypeOfFood());
        holder.starterItemDescription.setText(starterItem.getFoodDescribed());
        holder.starterCount.setText(starterItem.getFoodCount());



        if (holder.starterItemName.getText().toString().endsWith("V")) {

            String text = holder.starterItemName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.starterItemName.setText(ss);
            Log.i("paisi",holder.starterItemName.getText().toString());

        }

    }

    @Override
    public int getItemCount() {
        return itemsOfStarter.size();
    }

    public class StarterItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView starterItemName;
        public TextView starterItemDescription;
        public ImageView selectedItem;
        public TextView starterCount;
        ClickedStarterItem clickedStarterItem;

        public StarterItemViewHolder(@NonNull View itemView, ClickedStarterItem cI) {
            super(itemView);
            starterItemName = itemView.findViewById(R.id.starter_item_name);
            starterItemDescription = itemView.findViewById(R.id.starter_description);
            selectedItem = itemView.findViewById(R.id.starter_item_selected);
            starterCount = itemView.findViewById(R.id.starterCountElahi);
            this.clickedStarterItem = cI;
            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View v) {
            clickedStarterItem.onStarterItemClicked(getAdapterPosition());
            Log.i("Starter Name", itemsOfStarter.get(getAdapterPosition()).getTypeOfFood());
        }
    }
}
