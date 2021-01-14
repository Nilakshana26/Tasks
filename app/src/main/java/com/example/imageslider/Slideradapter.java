package com.example.imageslider;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class Slideradapter extends RecyclerView.Adapter<Slideradapter.SliderViewHolder> {

    private List<SliderItem> sliderItems;
    private ViewPager2 viewPage2;

     Slideradapter(List<SliderItem> sliderItems, ViewPager2 viewPage2) {
        this.sliderItems = sliderItems;
        this.viewPage2 = viewPage2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage( sliderItems.get( position ) );
        if(position==sliderItems.size()-2){
            viewPage2.post( runnable );
        }

    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{

        private RoundedImageView imageView;

        SliderViewHolder(@NonNull View itemView) {
            super( itemView );
            imageView =itemView.findViewById( R.id.imageSlide );
        }

        void setImage(SliderItem sliderItem){
            imageView.setImageResource( sliderItem.getImage() );
        }
    }
    private Runnable runnable =new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll( sliderItems );
            notifyDataSetChanged();
        }
    };
}
