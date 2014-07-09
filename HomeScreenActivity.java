package com.example.ugent.leonjakobquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class HomeScreenActivity extends Activity {

    private Button mNextButton;
    private String mGroupName;
    private EditText mGroupEditText;
    public static final String EXTRA_GROUPNAME = "com.ugent.LeonJakobQuiz.HomeScreenActivity.group_name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        mNextButton = (Button) findViewById(R.id.next_button);
        mGroupEditText = (EditText) findViewById(R.id.group_name_edit_text);
        mNextButton.setEnabled(false);

        mGroupEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGroupName=s.toString();
                boolean a = !mGroupEditText.getText().toString().trim().isEmpty();
                if (a)
                {
                    mNextButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, QuizActivity.class);
                intent.putExtra(HomeScreenActivity.EXTRA_GROUPNAME, mGroupName);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
