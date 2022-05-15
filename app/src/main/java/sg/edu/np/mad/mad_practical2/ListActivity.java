package sg.edu.np.mad.mad_practical2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<String> name=new ArrayList<>();
        ArrayList<String> description=new ArrayList<>();
        for(int i=0;i<20;i++){
            Random random = new Random();
            int intRandom = random.nextInt();
            Random random2 = new Random();
            int intRandom2=random2.nextInt();
            name.add("Name"+intRandom);
            description.add("Description"+intRandom2);
        }
        RecyclerView rv=findViewById(R.id.RecyclerView);
        ListActivityAdapter adapter=new ListActivityAdapter(name,description,ListActivity.this);
        LinearLayoutManager layout=new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);

    }
}