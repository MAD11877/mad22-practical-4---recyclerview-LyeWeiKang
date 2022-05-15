package sg.edu.np.mad.mad_practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Message = findViewById(R.id.Message);
        Message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });
        Intent receivingEndListActivity = getIntent();
        String name = receivingEndListActivity.getStringExtra("name");
        String description = receivingEndListActivity.getStringExtra("description");
        TextView displayName=findViewById(R.id.displayname);
        displayName.setText(name);
        TextView displayDescription=findViewById(R.id.displaydescription);
        displayDescription.setText(description);
        User newUser = new User(name, description,0 , true);
        Button follow=findViewById(R.id.follow);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView follow=findViewById(R.id.follow);
                if (newUser.followed){
                    follow.setText("Unfollow");
                    newUser.followed=false;
                    Toast.makeText(MainActivity.this,"Followed", Toast.LENGTH_SHORT).show();
                }
                else{
                    follow.setText("follow");
                    newUser.followed=true;

                }
            }
        });
    }



    }


