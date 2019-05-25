package engineer.davidauza.agenciaemd.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import engineer.davidauza.agenciaemd.R;
import engineer.davidauza.agenciaemd.activities.TourGuideDetailActivity;
import engineer.davidauza.agenciaemd.models.Location;

/**
 * {@link LocationAdapter} is a {@link RecyclerView.Adapter} that can provide the layout for each
 * list item based on a data source, which is a list of {@link Location} objects.
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder> {

    /**
     * The ArrayList containing the list of locations to display.
     */
    private ArrayList<Location> mLocations;

    /**
     * Create a new {@link LocationAdapter} object.
     *
     * @param pLocation is the ArrayList containing the list of locations to display.
     */
    public LocationAdapter(ArrayList<Location> pLocation) {
        mLocations = pLocation;
    }

    /**
     * Create new Views (invoked by the layout manager).
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Create a new View
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_tour_guide_location, viewGroup, false);
        return new MyViewHolder(view);
    }

    /**
     * Replace the contents of a View (invoked by the layout manager)
     */
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, int i) {
        // Get element from the dataset at this position
        Location currentLocation = mLocations.get(i);
        // Replace the contents of the View with that element
        viewHolder.mPictureImageView.setImageResource(currentLocation.getPicture());
        viewHolder.mNameTextView.setText(currentLocation.getName());
        viewHolder.mDescriptionTextView.setText(currentLocation.getDescription());

        setOnClickListener(viewHolder, currentLocation);
    }

    /**
     * Return the size of the dataset (invoked by the layout manager)
     */
    @Override
    public int getItemCount() {
        return mLocations.size();
    }

    /**
     * This method sets an OnClickListener for the elements of the list.
     */
    private void setOnClickListener(MyViewHolder pViewHolder,
                                    final Location pCurrentLocation) {
        pViewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, TourGuideDetailActivity.class);
                // TODO check if it actually works
                intent.putExtra(TourGuideDetailActivity.EXTRA_IMAGE,
                        pCurrentLocation.getPicture());
                intent.putExtra(TourGuideDetailActivity.EXTRA_NAME,
                        pCurrentLocation.getName());
                intent.putExtra(TourGuideDetailActivity.EXTRA_DESCRIPTION,
                        pCurrentLocation.getDescription());
                context.startActivity(intent);
            }
        });
    }

    /**
     * Provide a reference to the Views for each data item.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        /**
         * The CardView which contains the layout for each list item.
         */
        public View mView;

        /**
         * The ImageView which displays the picture of the location.
         */
        public ImageView mPictureImageView;

        /**
         * The TextView which displays the name of the location.
         */
        public TextView mNameTextView;

        /**
         * The TextView which displays the description of the location.
         */
        public TextView mDescriptionTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mPictureImageView = itemView.findViewById(R.id.img_location);
            mNameTextView = itemView.findViewById(R.id.lbl_location_name);
            mDescriptionTextView = itemView.findViewById(R.id.lbl_location_description);
        }
    }
}
