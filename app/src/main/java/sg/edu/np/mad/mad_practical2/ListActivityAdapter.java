package sg.edu.np.mad.mad_practical2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivityAdapter extends RecyclerView.Adapter<ListActivityViewHolder> {
    ArrayList<String> Name;
    ArrayList<String>Description;
    ListActivity activity;
    public ListActivityAdapter(ArrayList<String>Name,ArrayList<String>Description,ListActivity activity){
        this.Name=Name;
        this.Description=Description;
        this.activity=activity;
    }
    @NonNull
    @Override
    public ListActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item=null;
        if(viewType==0)
            item= LayoutInflater.from(parent.getContext()).inflate(R.layout.listactivity_alternatercv,parent,false);
        else
            item= LayoutInflater.from(parent.getContext()).inflate(R.layout.listactivity_rcv,null,false);



        return new ListActivityViewHolder(item);
    }
    @Override
    public int getItemViewType(int position) {
        String n = Name.get(position);
        if(Character.toString(n.charAt(n.length() - 1)).equals("7"))
            return 0;
        else
            return 1;


    }

    @Override
    public void onBindViewHolder(@NonNull ListActivityViewHolder holder, int position) {
        String n=Name.get(position);
        holder.name.setText(n);
        String d=Description.get(position);
        holder.description.setText(d);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(activity);
                ad.setTitle("Profile");
                ad.setMessage(n);
                ad.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(activity,MainActivity.class);
                        Bundle extras = new Bundle();
                        extras.putString("name",n);
                        extras.putString("description",d);
                        intent.putExtras(extras);
                        activity.startActivity(intent);
                    }
                });
                ad.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                ad.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Name.size();
    }
}
