package com.example.templaterecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

// Constructeur
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private String stagiaires[], descs[];
    private int avatars[];

    public RecyclerAdapter(Context context, String[] stagiaires, String[] descs, int[] avatars) {
        this.context = context;
        this.stagiaires = stagiaires;
        this.descs = descs;
        this.avatars = avatars;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.stagiaire.setText(stagiaires[position]);
        holder.description.setText(descs[position]);
        holder.avatar.setImageResource(avatars[position]);

holder.mainLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Toast.makeText(context,"stagiare:"+ stagiaires[position], Toast.LENGTH_LONG).show();
        Intent intent =new Intent(context,secondeActivity.class);

        intent.putExtra("stagiaire", stagiaires[position]);
        intent.putExtra("descs", descs[position]);
        intent.putExtra("avatars",avatars [position]);

        context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return avatars.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView stagiaire, description;
        ImageView avatar;
        ConstraintLayout mainLayout;




    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        /** Le contenu **/
        stagiaire = itemView.findViewById(R.id.tvName);
        description = itemView.findViewById(R.id.tvDesc);
        avatar = itemView.findViewById(R.id.ivAvatar);

        /** Le contenat**/
        mainLayout = itemView.findViewById(R.id.mainLayout);
    }
}
}
