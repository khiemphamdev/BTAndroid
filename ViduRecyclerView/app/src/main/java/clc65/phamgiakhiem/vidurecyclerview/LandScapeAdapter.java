package clc65.phamgiakhiem.vidurecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> listData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> listData) {
        this.context = context;
        this.listData = listData;
    }

    // B3.3: Code các hàm ghi đè của lớp Adapter
    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land, parent, false);
        ItemLandHolder viewHolderCreated = new ItemLandHolder(vItem);
        return viewHolderCreated;
    }
    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        // Lấy đối tượng hiển thị
        LandScape landScapeHienThi = listData.get(position);
        // Trích thông tin
        String imageFile = landScapeHienThi.getImageFile();
        String imageName = landScapeHienThi.getImageName();
        // Đặt vào các trường thông tin của holder
        holder.tvImageText.setText(imageName);
        // Muốn đặt ảnh vào phải làm các bước sau:
        // -- B1: Lấy tên package
        String packageName = holder.itemView.getContext().getPackageName();
        // --B2: Lấy ID của ảnh
        int imageID = holder.itemView.getResources().getIdentifier(imageFile, "mipmap", packageName);
        holder.ivImage.setImageResource(imageID);
    }
    @Override
    public int getItemCount() {
        return listData.size();
    }
    class ItemLandHolder extends RecyclerView.ViewHolder {
        TextView tvImageText;
        ImageView ivImage;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvImageText = itemView.findViewById(R.id.imageName);
            ivImage = itemView.findViewById(R.id.imageLand);
        }
    }
}

