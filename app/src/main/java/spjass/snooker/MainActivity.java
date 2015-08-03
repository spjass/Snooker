package spjass.snooker;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends FragmentActivity {
    MainActivityFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Game game = fragment.game;
        savedInstanceState.putInt("p1Points", game.getPlayerList().get(0).getPoints());
        savedInstanceState.putInt("p2Points", game.getPlayerList().get(1).getPoints());
        savedInstanceState.putString("Player1", game.getPlayerList().get(0).getName());
        savedInstanceState.putString("Player2", game.getPlayerList().get(1).getName());
        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        Game game = fragment.game;
        game.getPlayerList().get(0).setPoints(savedInstanceState.getInt("p1Points"));
        game.getPlayerList().get(1).setPoints(savedInstanceState.getInt("p2Points"));
        game.getPlayerList().get(0).setName(savedInstanceState.getString("Player1"));
        game.getPlayerList().get(1).setName(savedInstanceState.getString("Player2"));
        fragment.refreshUI();
        fragment.setProgress();

    }

    public void ballClicked(View v) {


        fragment.ballClicked(v);
        /*
        Snackbar
                .make(layout, "Ball clicked", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("snooker", "snackbar");
                    }
                })
                .show();
                */
    }
}
