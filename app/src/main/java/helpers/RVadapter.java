package helpers;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uc.ehome.MainActivity;
import com.uc.ehome.R;

import java.util.ArrayList;

import com.uc.ehome.ViewTaskActivity;
import com.uc.ehome.models.TaskDetails;

public class RVadapter extends RecyclerView.Adapter<RVadapter.CardViewHolder> {

    static ArrayList<TaskDetails> task, accepted_task;

    public RVadapter(ArrayList<TaskDetails> task, ArrayList<TaskDetails> accepted_task) {
        this.task = task;
        this.accepted_task = accepted_task;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if(task != null) {
            view = inflater.inflate(R.layout.fragment_task, parent, false);
        }
        else{
            view = inflater.inflate(R.layout.fragment_accepted_task, parent, false);
        }

        CardViewHolder cvh = new CardViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        if(task != null) {
            holder.title.setText(task.get(position).getTitle());
            holder.location.setText(task.get(position).getLocation());
            holder.status.setText(task.get(position).getStatus());
            holder.iv.setImageURI(task.get(position).getImage());
        }
        else{
            holder.title.setText(accepted_task.get(position).getTitle());
            holder.time.setText(accepted_task.get(position).getDate() + " " + accepted_task.get(position).getTime());
            holder.iv.setImageURI(accepted_task.get(position).getImage());
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        int size = 0;

        if(task != null) size = task.size();
        else size = accepted_task.size();

        return size;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        TextView title, location, status, time;
        ImageView iv;

        CardViewHolder(View itemView) {
            super(itemView);

            if(RVadapter.task != null){
                title = (TextView) itemView.findViewById(R.id.task_title);
                location = (TextView) itemView.findViewById(R.id.task_location);
                status = (TextView) itemView.findViewById(R.id.task_status);
                iv = (ImageView) itemView.findViewById(R.id.task_attached_image);
            }
            else{
                title = (TextView) itemView.findViewById(R.id.accepted_task_title);
                time = (TextView) itemView.findViewById(R.id.task_expiration);
                iv = (ImageView) itemView.findViewById(R.id.accepted_task_attached_image);
            }

        }
    }
}
