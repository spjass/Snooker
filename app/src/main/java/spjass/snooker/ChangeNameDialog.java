package spjass.snooker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Spjass on 04-Jun-15.
 */
public class ChangeNameDialog extends Dialog {
    final Player player;
    public ChangeNameDialog(Context context, Player player) {
        super(context);
        final View rootView = getWindow().getDecorView();
        this.setContentView(R.layout.dialog_name_change);
        this.player = player;
        this.setTitle("Change name");
        TextView titleText = (TextView) rootView.findViewById(R.id.titleText);



        EditText text = (EditText) rootView.findViewById(R.id.changeNameEditText);
        text.setText(player.getName());



    }
}
