package bd.com.cmed.apiresponsedisplay.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import bd.com.cmed.apiresponsedisplay.R;
import bd.com.cmed.apiresponsedisplay.model.users;
import bd.com.cmed.apiresponsedisplay.util.Constants;


public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ListViewHolder>{

    private List<users> usersList;
    private Context context;

    public UsersListAdapter(List<users> usersList, Context context){
        this.usersList = usersList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_users_list, parent, false);

        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        users itemUsers = usersList.get(position);

        String name = itemUsers.getFirstName() +" "+ itemUsers.getLastName();
        String mobileNumber = "Mobile no. " + itemUsers.getPhones().getMobile();

        String photoUrl = "";
        if(itemUsers.getGender().equalsIgnoreCase("male")){
            photoUrl = Constants.PHOTO_URL_MEN + itemUsers.getPhoto() + ".jpg";
        }else{
            photoUrl = Constants.PHOTO_URL_WOMEN + itemUsers.getPhoto() + ".jpg";
        }

        holder.fullName.setText(name);
        holder.mobileNumber.setText(mobileNumber);

        PicassoHttpsSupport.getInstance(context)
                .load(photoUrl)
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView fullName, mobileNumber;

        public ListViewHolder(View view) {
            super(view);

            photo = view.findViewById(R.id.iv_photo);
            fullName = view.findViewById(R.id.txt_name);
            mobileNumber = view.findViewById(R.id.txt_mobile_number);
        }
    }
}
