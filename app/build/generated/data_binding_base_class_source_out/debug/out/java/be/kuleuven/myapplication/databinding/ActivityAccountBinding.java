// Generated by view binder compiler. Do not edit!
package java.be.kuleuven.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.be.kuleuven.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAccountBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView PhoneNumber;

  @NonNull
  public final TextView accountScreenInfo;

  @NonNull
  public final AutoCompleteTextView autoCompleteTextView;

  @NonNull
  public final AutoCompleteTextView autoCompleteTextView2;

  @NonNull
  public final AutoCompleteTextView autoCompleteTextView3;

  @NonNull
  public final TextView collarBarrier;

  @NonNull
  public final Button editPassword;

  @NonNull
  public final Button editPhonenumber;

  @NonNull
  public final Button editUsername;

  @NonNull
  public final TextView password;

  @NonNull
  public final TextView username;

  private ActivityAccountBinding(@NonNull ConstraintLayout rootView, @NonNull TextView PhoneNumber,
      @NonNull TextView accountScreenInfo, @NonNull AutoCompleteTextView autoCompleteTextView,
      @NonNull AutoCompleteTextView autoCompleteTextView2,
      @NonNull AutoCompleteTextView autoCompleteTextView3, @NonNull TextView collarBarrier,
      @NonNull Button editPassword, @NonNull Button editPhonenumber, @NonNull Button editUsername,
      @NonNull TextView password, @NonNull TextView username) {
    this.rootView = rootView;
    this.PhoneNumber = PhoneNumber;
    this.accountScreenInfo = accountScreenInfo;
    this.autoCompleteTextView = autoCompleteTextView;
    this.autoCompleteTextView2 = autoCompleteTextView2;
    this.autoCompleteTextView3 = autoCompleteTextView3;
    this.collarBarrier = collarBarrier;
    this.editPassword = editPassword;
    this.editPhonenumber = editPhonenumber;
    this.editUsername = editUsername;
    this.password = password;
    this.username = username;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_account, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAccountBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.PhoneNumber;
      TextView PhoneNumber = ViewBindings.findChildViewById(rootView, id);
      if (PhoneNumber == null) {
        break missingId;
      }

      id = R.id.accountScreenInfo;
      TextView accountScreenInfo = ViewBindings.findChildViewById(rootView, id);
      if (accountScreenInfo == null) {
        break missingId;
      }

      id = R.id.autoCompleteTextView;
      AutoCompleteTextView autoCompleteTextView = ViewBindings.findChildViewById(rootView, id);
      if (autoCompleteTextView == null) {
        break missingId;
      }

      id = R.id.autoCompleteTextView2;
      AutoCompleteTextView autoCompleteTextView2 = ViewBindings.findChildViewById(rootView, id);
      if (autoCompleteTextView2 == null) {
        break missingId;
      }

      id = R.id.autoCompleteTextView3;
      AutoCompleteTextView autoCompleteTextView3 = ViewBindings.findChildViewById(rootView, id);
      if (autoCompleteTextView3 == null) {
        break missingId;
      }

      id = R.id.collarBarrier;
      TextView collarBarrier = ViewBindings.findChildViewById(rootView, id);
      if (collarBarrier == null) {
        break missingId;
      }

      id = R.id.editPassword;
      Button editPassword = ViewBindings.findChildViewById(rootView, id);
      if (editPassword == null) {
        break missingId;
      }

      id = R.id.editPhonenumber;
      Button editPhonenumber = ViewBindings.findChildViewById(rootView, id);
      if (editPhonenumber == null) {
        break missingId;
      }

      id = R.id.editUsername;
      Button editUsername = ViewBindings.findChildViewById(rootView, id);
      if (editUsername == null) {
        break missingId;
      }

      id = R.id.password;
      TextView password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.username;
      TextView username = ViewBindings.findChildViewById(rootView, id);
      if (username == null) {
        break missingId;
      }

      return new ActivityAccountBinding((ConstraintLayout) rootView, PhoneNumber, accountScreenInfo,
          autoCompleteTextView, autoCompleteTextView2, autoCompleteTextView3, collarBarrier,
          editPassword, editPhonenumber, editUsername, password, username);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}