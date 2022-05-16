package java.be.kuleuven.myapplication;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Objects;

public class PopUp extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(app.getPopUpTitle())
                .setMessage(app.getPopUpMessage())
                .setPositiveButton("ok", (dialogInterface, i) -> {});
        return builder.create();
    }
}