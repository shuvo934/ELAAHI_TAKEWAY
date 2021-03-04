package ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu;

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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;


public class SideDishMainMenuAdapter extends RecyclerView.Adapter<SideDishMainMenuAdapter.SideDishViewHolder> {

    public ArrayList<SubCategoryItemTag> itemsOfStarter;
    public Context starterContext;
    private ClickedStarterItem myStarterItem;

    public SideDishMainMenuAdapter(Context myContext, ArrayList<SubCategoryItemTag> starterItems, ClickedStarterItem csi) {
        this.itemsOfStarter = starterItems;
        this.starterContext = myContext;
        this.myStarterItem = csi;
    }

    public interface ClickedStarterItem {
        void onStarterItemClicked(int starterItemPosition);
    }

    @NonNull
    @Override
    public SideDishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(starterContext).inflate(R.layout.elaahi_adult_starter_item, parent, false);
        SideDishViewHolder svh = new SideDishViewHolder(v, myStarterItem);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull SideDishViewHolder holder, int position) {

        SubCategoryItemTag starterItem = itemsOfStarter.get(position);

        holder.starterItemName.setText(starterItem.getfName());
        holder.starterItemDescription.setText(starterItem.getfNote());
        holder.starterCount.setText(starterItem.getfRate());
        holder.starterCount.setVisibility(View.INVISIBLE);

        if (holder.starterItemName.getText().toString().endsWith("V")) {

            String text = holder.starterItemName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.starterItemName.setText(ss);
            Log.i("paisi",holder.starterItemName.getText().toString());

        }

        if (holder.starterItemDescription.getText().toString().contains("null")) {
            holder.starterItemDescription.setText("");
        }

    }

    @Override
    public int getItemCount() {
        return itemsOfStarter.size();
    }

    public class SideDishViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView starterItemName;
        public TextView starterItemDescription;
        public ImageView selectedItem;
        public TextView starterCount;
        ClickedStarterItem clickedStarterItem;

        public SideDishViewHolder(@NonNull View itemView, ClickedStarterItem cI) {
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
            Log.i("Starter Name", itemsOfStarter.get(getAdapterPosition()).getfName());
        }
    }
}
