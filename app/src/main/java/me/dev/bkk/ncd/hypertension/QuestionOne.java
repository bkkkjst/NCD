package me.dev.bkk.ncd.hypertension;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.dev.bkk.ncd.R;

public class QuestionOne extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_one, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*public  void rbListener(View view){
        Log.e("QuestionOneFragment", String.valueOf(view.getId()) +" | size"+integerList.size());
        Bundle bundle = new Bundle();

        if(!integerList.contains(view.getId())){
            integerList.add(view.getId());
        }else{}


        bundle.putIntegerArrayList("rbnId", (ArrayList<Integer>) integerList);

        QuestionOneFragment questionOneFragment = new QuestionOneFragment();
        questionOneFragment.setArguments(bundle);
    }*/
}
