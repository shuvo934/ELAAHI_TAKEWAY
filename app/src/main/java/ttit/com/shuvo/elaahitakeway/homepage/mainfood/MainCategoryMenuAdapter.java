package ttit.com.shuvo.elaahitakeway.homepage.mainfood;

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

public class MainCategoryMenuAdapter extends RecyclerView.Adapter<MainCategoryMenuAdapter.CCCViewHolder> {

    private ArrayList<CategoryItem> mCategoryItem;
    private MenuClickedItem myClickedItem;


    public MainCategoryMenuAdapter(ArrayList<CategoryItem> categoryItems, MenuClickedItem cli) {
        this.mCategoryItem = categoryItems;
        this.myClickedItem = cli;
    }

    public class CCCViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mtext;
        MenuClickedItem mClickedItem;

        public CCCViewHolder(@NonNull View itemView, MenuClickedItem ci) {
            super(itemView);
            mtext = itemView.findViewById(R.id.name_menu_category);
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

    public interface MenuClickedItem {
        void onCategoryClicked(int CategoryPosition);
    }

    @NonNull
    @Override
    public CCCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_menu_category_name, parent, false);
        CCCViewHolder categoryViewHolder = new CCCViewHolder(view, myClickedItem);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CCCViewHolder holder, int position) {

        CategoryItem categoryItem = mCategoryItem.get(position);

        holder.mtext.setText(categoryItem.getmText());

    }

    @Override
    public int getItemCount() {
        return mCategoryItem.size();
    }


}
