// Generated by view binder compiler. Do not edit!
package com.lecturadorv2.android.applecturador.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lecturadorv2.android.applecturador.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogSearchBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etCodf;

  @NonNull
  public final EditText etNcnt;

  @NonNull
  public final TextView tvCdof;

  @NonNull
  public final TextView tvNcnt;

  private DialogSearchBinding(@NonNull LinearLayout rootView, @NonNull EditText etCodf,
      @NonNull EditText etNcnt, @NonNull TextView tvCdof, @NonNull TextView tvNcnt) {
    this.rootView = rootView;
    this.etCodf = etCodf;
    this.etNcnt = etNcnt;
    this.tvCdof = tvCdof;
    this.tvNcnt = tvNcnt;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.etCodf;
      EditText etCodf = ViewBindings.findChildViewById(rootView, id);
      if (etCodf == null) {
        break missingId;
      }

      id = R.id.etNcnt;
      EditText etNcnt = ViewBindings.findChildViewById(rootView, id);
      if (etNcnt == null) {
        break missingId;
      }

      id = R.id.tvCdof;
      TextView tvCdof = ViewBindings.findChildViewById(rootView, id);
      if (tvCdof == null) {
        break missingId;
      }

      id = R.id.tvNcnt;
      TextView tvNcnt = ViewBindings.findChildViewById(rootView, id);
      if (tvNcnt == null) {
        break missingId;
      }

      return new DialogSearchBinding((LinearLayout) rootView, etCodf, etNcnt, tvCdof, tvNcnt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
