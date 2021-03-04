package ttit.com.shuvo.elaahitakeway.homepage.festivalfood;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.CategoryAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.CategoryItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;

public class FestivalAdapter extends RecyclerView.Adapter<FestivalAdapter.FestiveViewHolder> {

    private ArrayList<NormalFoodItem> mCategoryItem;
    private FestiveClickedItem myClickedItem;


    public FestivalAdapter(ArrayList<NormalFoodItem> categoryItems, FestiveClickedItem cli) {
        this.mCategoryItem = categoryItems;
        this.myClickedItem = cli;
    }

    public class FestiveViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mtext;
        public TextView price;
        FestiveClickedItem mClickedItem;

        public FestiveViewHolder(@NonNull View itemView, FestiveClickedItem ci) {
            super(itemView);
            mtext = itemView.findViewById(R.id.festive_name);
            price = itemView.findViewById(R.id.festive_price);

            this.mClickedItem = ci;

            itemView.setOnClickListener(this::onClick);



//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mListener != null) {
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION) {
//                            mListener.onItemClick(position);
//                        }
//                    }
//                }
//            });
        }

        @Override
        public void onClick(View v) {
            mClickedItem.onCategoryClicked(getAdapterPosition());
            Log.i("Category Name", mCategoryItem.get(getAdapterPosition()).getMyFood());
        }
    }

    public interface FestiveClickedItem {
        void onCategoryClicked(int CategoryPosition);
    }

    @NonNull
    @Override
    public FestiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.festival_item, parent, false);
        FestiveViewHolder categoryViewHolder = new FestiveViewHolder(view, myClickedItem);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FestiveViewHolder holder, int position) {

        NormalFoodItem categoryItem = mCategoryItem.get(position);

        holder.mtext.setText(categoryItem.getMyFood());
        holder.price.setText(categoryItem.getMyFoodPrice());

    }

    @Override
    public int getItemCount() {
        return mCategoryItem.size();
    }

}
