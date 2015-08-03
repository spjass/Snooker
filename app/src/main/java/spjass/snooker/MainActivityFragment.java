package spjass.snooker;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ArrayList<AppCompatButton> buttonList;
    View view;
    AppCompatButton fabImageButton2;
    AppCompatButton fabImageButton3;
    AppCompatButton fabImageButton4;
    AppCompatButton fabImageButton5;
    AppCompatButton fabImageButton6;
    AppCompatButton fabImageButton7;
    AppCompatButton fabImageButton8;
    Game game;
    Player player1;
    Player player2;
    float progress;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("snooker", "starting");
        progress = 50;
        view = inflater.inflate(R.layout.fragment_main, container, false);
        Log.d("snooker", "we got here");

        game = new Game();
        player1 = game.getPlayerList().get(0);
        player2 = game.getPlayerList().get(1);

        playerSelectionListeners();


        final FloatingActionButton fabImageButton = (FloatingActionButton) view.findViewById(R.id.fab_image_button);
        fabImageButton2 = (AppCompatButton) view.findViewById(R.id.fab_image_button2);
        fabImageButton3 = (AppCompatButton) view.findViewById(R.id.fab_image_button3);
        fabImageButton4 = (AppCompatButton) view.findViewById(R.id.fab_image_button4);
        fabImageButton5 = (AppCompatButton) view.findViewById(R.id.fab_image_button5);
        fabImageButton6 = (AppCompatButton) view.findViewById(R.id.fab_image_button6);
        fabImageButton7 = (AppCompatButton) view.findViewById(R.id.fab_image_button7);
        fabImageButton8 = (AppCompatButton) view.findViewById(R.id.fab_image_button8);

        ColorStateList csl2 = new ColorStateList(new int[][]{new int[0]}, new int[]{getResources().getColor(R.color.red)});
        ColorStateList csl3 = new ColorStateList(new int[][]{new int[0]}, new int[]{getResources().getColor(R.color.Gold)});
        ColorStateList csl4 = new ColorStateList(new int[][]{new int[0]}, new int[]{getResources().getColor(R.color.Green)});
        ColorStateList csl5 = new ColorStateList(new int[][]{new int[0]}, new int[]{getResources().getColor(R.color.SaddleBrown)});
        ColorStateList csl6 = new ColorStateList(new int[][]{new int[0]}, new int[]{getResources().getColor(R.color.CornflowerBlue)});
        ColorStateList csl7 = new ColorStateList(new int[][]{new int[0]}, new int[]{getResources().getColor(R.color.Pink)});
        ColorStateList csl8 = new ColorStateList(new int[][]{new int[0]}, new int[]{getResources().getColor(R.color.Black)});

        /*
        fabImageButton2.setBackgroundTintList(csl2);
        fabImageButton3.setBackgroundTintList(csl3);
        fabImageButton4.setBackgroundTintList(csl4);
        fabImageButton5.setBackgroundTintList(csl5);
        fabImageButton6.setBackgroundTintList(csl6);
        fabImageButton7.setBackgroundTintList(csl7);
        fabImageButton8.setBackgroundTintList(csl8);
        */

        fabImageButton2.setSupportBackgroundTintList(csl2);
        fabImageButton3.setSupportBackgroundTintList(csl3);
        fabImageButton4.setSupportBackgroundTintList(csl4);
        fabImageButton5.setSupportBackgroundTintList(csl5);
        fabImageButton6.setSupportBackgroundTintList(csl6);
        fabImageButton7.setSupportBackgroundTintList(csl7);
        fabImageButton8.setSupportBackgroundTintList(csl8);


        buttonList = new ArrayList<>();


        buttonList.add(fabImageButton2);
        buttonList.add(fabImageButton3);
        buttonList.add(fabImageButton4);
        buttonList.add(fabImageButton5);
        buttonList.add(fabImageButton6);
        buttonList.add(fabImageButton7);
        buttonList.add(fabImageButton8);



        fabImageButton.setOnClickListener(new View.OnClickListener() {
            boolean fabActive = false;

            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.abc_grow_fade_in_from_bottom);
                animation1.setDuration(1000);

                Animation animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.abc_popup_exit);
                animation2.setDuration(300);

                if (!fabActive) {

                    for (AppCompatButton button : buttonList) {
                        button.setVisibility(View.VISIBLE);
                        button.startAnimation(animation1);
                    }

                    fabActive = true;
                } else {
                    for (AppCompatButton button : buttonList) {
                        button.setVisibility(View.GONE);
                        button.startAnimation(animation2);
                    }

                    fabActive = false;
                }


                Log.d("snooker", "button clicked");


            }
        });

        refreshUI();
        return view;
    }





    public void ballClicked(View v)
    {

        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.relativeLayout);
        AppCompatButton button = (AppCompatButton) v;
        int points;

        PlayEvent event = new PlayEvent(game.getPlayerInTurn(), 0);

        String text = "";
        if (button == fabImageButton2){
            event.setPoints(1);
        } else if (button == fabImageButton3) {
            event.setPoints(2);
        } else if (button == fabImageButton4) {
            event.setPoints(3);
        } else if (button == fabImageButton5) {
            event.setPoints(4);
        } else if (button == fabImageButton6) {
            event.setPoints(5);
        } else if (button == fabImageButton7) {
            event.setPoints(6);
        } else if (button == fabImageButton8) {
            event.setPoints(7);
        }


        text = event.getPlayStr();
        event.play();

        game.setLastPlayedEvent(event);
        setProgress();
        refreshUI();

        Snackbar snack = Snackbar.make(getView(), text, Snackbar.LENGTH_LONG);
        View snackView = snack.getView();
        TextView tv = (TextView) snackView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(getResources().getColor(R.color.White));
        snack.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.getLastPlayedEvent().undo();
                Toast.makeText(getActivity(), "Points removed", Toast.LENGTH_SHORT).show();
                refreshUI();
                setProgress();
            }
        }).show();

    }

    public void refreshUI() {
        TextView p1points = (TextView) view.findViewById(R.id.textViewPoints);
        TextView p2points = (TextView) view.findViewById(R.id.textViewPoints2);
        p1points.setText(player1.getPoints() + "");
        p2points.setText(player2.getPoints() + "");


        //setProgress();


    }

    public void playerSelectionListeners() {

        final TextView p1tv = (TextView) view.findViewById(R.id.textView);
        final TextView p2tv = (TextView) view.findViewById(R.id.textView2);


        p1tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.setPlayerInTurn(player1);
                refreshUI();
                playerSelection();
            }
        });

        p1tv.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                final ChangeNameDialog dialog = new ChangeNameDialog(getActivity(), player1);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_name_change, null);
                builder.setView(view);

                TextView title = new TextView(getActivity());

                title.setText("Custom Centered Title");
                title.setBackgroundColor(Color.DKGRAY);
                title.setPadding(10, 10, 10, 10);
                title.setGravity(Gravity.CENTER);
                title.setTextColor(Color.WHITE);
                title.setTextSize(20);

                builder.setCustomTitle(title);
                final TextView p1tv = (TextView) view.findViewById(R.id.textView);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                        EditText text = (EditText) dialog.findViewById(R.id.changeNameEditText);
                        String str = text.getText().toString();
                        dialog.player.setName(str);
                        MainActivityFragment.this.playerSelection();

                        p1tv.setText(str);


                    }
                });
                dialog.show();
                return false;
            }
        });



        p2tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.setPlayerInTurn(player2);
                refreshUI();
                playerSelection();
            }
        });

        p2tv.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(), "Long click invoked", Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_name_change);
                dialog.setTitle("Change name");
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return false;
            }
        });
    }

    public void playerSelection() {
        TextView p1tv = (TextView) view.findViewById(R.id.textView);
        TextView p2tv = (TextView) view.findViewById(R.id.textView2);

        Player player = game.getPlayerInTurn();
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.scale);


        if (player == player1) {

            p1tv.setTypeface(null, Typeface.BOLD);
            p1tv.startAnimation(animation);
            p2tv.setTypeface(null, Typeface.NORMAL);

        } else {

            p2tv.setTypeface(null, Typeface.BOLD);
            p2tv.startAnimation(animation);
            p1tv.setTypeface(null, Typeface.NORMAL);

        }
    }

    public void setProgress() {

        ProgressBar mProgress = (ProgressBar) view.findViewById(R.id.circularProgressbar);
           // Main Progress
        //mProgress.setSecondaryProgress(50); // Secondary Progress

        mProgress.setMax(1000); // Maximum Progress


        float divider = (float) player1.getPoints() + player2.getPoints();
        float oldProgress = progress;
        progress = (float) player1.getPoints() / divider * 1000f;

        Log.d("snooker", "progress: " + progress);

        //mProgress.setProgress(game.getPlayerList().get(1).getPoints());
        ObjectAnimator animation = ObjectAnimator.ofInt(mProgress, "progress", (int) oldProgress, (int) progress);
        animation.setDuration(990);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

    }

    public void changePlayerName(String name, Player player) {
        player.setName(name);
    }





}
