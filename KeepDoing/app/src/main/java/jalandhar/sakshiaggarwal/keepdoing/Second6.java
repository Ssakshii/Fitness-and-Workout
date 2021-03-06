package jalandhar.sakshiaggarwal.keepdoing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Second6 extends AppCompatActivity implements AdapterView.OnItemClickListener{  //Intermediate Abs Workout
    ListView mylist1;
    TextView textView46,textView47;
    String[] activities={"First7","Third3","Third7","Fifth3","First5"};
    String[] exernames ={"Knee Toucher","Plank","Heel Toucher","Abs Stretch","Russian Twist"};
    int[] image={R.drawable.s1,R.drawable.j1,R.drawable.t4,R.drawable.l2,R.drawable.o2};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysecond6);
        setTitle("Intermediate Abs Workout");
        mylist1=findViewById(R.id.mylist1);
        textView46=findViewById(R.id.textView46);
        textView47=findViewById(R.id.textView47);
        Typeface myfont = Typeface.createFromAsset(getAssets(), "Magnificent.ttf");
        textView46.setTypeface(myfont);
        textView47.setTypeface(myfont);
        myhelper obj=new myhelper(this,android.R.layout.simple_list_item_1,exernames);
        mylist1.setAdapter(obj);
        mylist1.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            Class myclass = Class.forName(getPackageName() + "." + activities[position]);
            Intent myintent=new Intent(this,myclass);
            startActivity(myintent);
        }
        catch(Exception e)
        {
            Log.e("keep Doing","Error in Item Click Listener");
        }
    }
    class myhelper extends ArrayAdapter<String>
    {
        public myhelper(@NonNull Context context, int resource, @NonNull String[] objects) {
            super(context, resource, objects);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View myrow=getLayoutInflater().inflate(R.layout.activitylistdesign1,parent,false);
            TextView exername;
            ImageView img1;
            img1=myrow.findViewById(R.id.img1);
            img1.setImageResource(image[position]);
            exername=myrow.findViewById(R.id.exername);
            Typeface myfont = Typeface.createFromAsset(getAssets(), "Magnificent.ttf");
            exername.setTypeface(myfont);
            exername.setText(exernames[position]);
            return myrow;
        }
    }
}
