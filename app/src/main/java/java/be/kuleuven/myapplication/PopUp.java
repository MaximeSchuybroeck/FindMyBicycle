package java.be.kuleuven.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class PopUp extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(app.getPopUpTitle())
                .setMessage(app.getPopUpMessage())
                .setPositiveButton("ok", (dialogInterface, i) -> {});
        return builder.create();
    }
}