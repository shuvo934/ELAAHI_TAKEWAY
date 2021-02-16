package ttit.com.shuvo.elaahitakeway.homepage;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>  {

    private ArrayList<CategoryItem> mCategoryItem;
    private ClickedItem myClickedItem;


    public CategoryAdapter(ArrayList<CategoryItem> categoryItems, ClickedItem cli) {
        this.mCategoryItem = categoryItems;
        this.myClickedItem = cli;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mtext;
        ClickedItem mClickedItem;

        public CategoryViewHolder(@NonNull View itemView, ClickedItem ci) {
            super(itemView);
            mtext = itemView.findViewById(R.id.categoryName);
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
            Log.i("Category Name", mCategoryItem.get(getAdapterPosition()).getmText());
        }
    }

    public interface ClickedItem {
        void onCategoryClicked(int CategoryPosition);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view, myClickedItem);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        CategoryItem categoryItem = mCategoryItem.get(position);

        holder.mtext.setText(categoryItem.getmText());

    }

    @Override
    public int getItemCount() {
        return mCategoryItem.size();
    }


}
