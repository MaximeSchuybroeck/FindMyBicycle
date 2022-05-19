// Generated by view binder compiler. Do not edit!
package java.be.kuleuven.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView appName;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final Button newUserButton;

  @NonNull
  public final EditText passwordInput;

  @NonNull
  public final TextView textPassword;

  @NonNull
  public final TextView textUserName;

  @NonNull
  public final EditText usernameInput;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull TextView appName,
      @NonNull Button loginButton, @NonNull Button newUserButton, @NonNull EditText passwordInput,
      @NonNull TextView textPassword, @NonNull TextView textUserName,
      @NonNull EditText usernameInput) {
    this.rootView = rootView;
    this.appName = appName;
    this.loginButton = loginButton;
    this.newUserButton = newUserButton;
    this.passwordInput = passwordInput;
    this.textPassword = textPassword;
    this.textUserName = textUserName;
    this.usernameInput = usernameInput;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appName;
      TextView appName = ViewBindings.findChildViewById(rootView, id);
      if (appName == null) {
        break missingId;
      }

      id = R.id.loginButton;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.newUserButton;
      Button newUserButton = ViewBindings.findChildViewById(rootView, id);
      if (newUserButton == null) {
        break missingId;
      }

      id = R.id.passwordInput;
      EditText passwordInput = ViewBindings.findChildViewById(rootView, id);
      if (passwordInput == null) {
        break missingId;
      }

      id = R.id.textPassword;
      TextView textPassword = ViewBindings.findChildViewById(rootView, id);
      if (textPassword == null) {
        break missingId;
      }

      id = R.id.textUserName;
      TextView textUserName = ViewBindings.findChildViewById(rootView, id);
      if (textUserName == null) {
        break missingId;
      }

      id = R.id.usernameInput;
      EditText usernameInput = ViewBindings.findChildViewById(rootView, id);
      if (usernameInput == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, appName, loginButton,
          newUserButton, passwordInput, textPassword, textUserName, usernameInput);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}