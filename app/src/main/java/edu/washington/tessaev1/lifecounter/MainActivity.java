package edu.washington.tessaev1.lifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    public Button increase;
    public Button decrease;
    public Button increaseFive;
    public Button decreaseFive;
//    public TextView lives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] playerOne = {R.id.player1, R.id.count1, R.id.plus1, R.id.minus1, R.id.plus_five1,
                            R.id.minus_five1};
        int[] playerTwo = {R.id.player2, R.id.count2, R.id.plus2, R.id.minus2, R.id.plus_five2,
                R.id.minus_five2};
        int[] playerThree = {R.id.player3, R.id.count3, R.id.plus3, R.id.minus3, R.id.plus_five3,
                R.id.minus_five3};
        int[] playerFour = {R.id.player4, R.id.count4, R.id.plus4, R.id.minus4, R.id.plus_five4,
                R.id.minus_five4};

        setButtonClickListeners(playerOne);
        setButtonClickListeners(playerTwo);
        setButtonClickListeners(playerThree);
        setButtonClickListeners(playerFour);
    }

    public void setButtonClickListeners(int[] playerInfo) {
        final TextView currentName = (TextView) findViewById(playerInfo[0]);
        final String name = currentName.getText().toString();
        final TextView lifeCount = (TextView) findViewById(playerInfo[1]);

        increase = (Button) findViewById(playerInfo[2]);
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(v, 1, lifeCount, name);
            }
        });
        decrease = (Button) findViewById(playerInfo[3]);
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(v, -1, lifeCount, name);
            }
        });
        increaseFive = (Button) findViewById(playerInfo[4]);
        increaseFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(v, 5, lifeCount, name);
            }
        });
        decreaseFive = (Button) findViewById(playerInfo[5]);
        decreaseFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(v, -5, lifeCount, name);
            }
        });

//        increase.setOnClickListener(new ButtonListener(1));
//        decrease.setOnClickListener(new ButtonListener(-1));
//        increaseFive.setOnClickListener(new ButtonListener(5));
//        decreaseFive.setOnClickListener(new ButtonListener(-5));
    }

    public void update(View v, int add, TextView lifeCount, String name) {
        int count = Integer.parseInt(lifeCount.getText().toString().split(" ")[0]);
        count += add;
        lifeCount.setText(count + " lives");
        if(count <= 0) {
            final TextView loser = (TextView) findViewById(R.id.loser_message);
            loser.setText(name + " LOSES!");
            loser.setVisibility(View.VISIBLE);
        }

    }

//    public class ButtonListener implements View.OnClickListener {
//        public int action;
//
//        public ButtonListener(int num) {
//            action = num;
//        }
//
//        @Override
//        public void onClick(View v) {
//            int count = Integer.parseInt(lives.getText().toString().split(" ")[0]);
//            count += action;
//            lives.setText(count + " lives");
//        }
//    }
}
