// Generated by view binder compiler. Do not edit!
package com.lecturadorv2.android.applecturador.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lecturadorv2.android.applecturador.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ItemobsBinding implements ViewBinding {
  @NonNull
  private final TextView rootView;

  @NonNull
  public final TextView txtObs;

  private ItemobsBinding(@NonNull TextView rootView, @NonNull TextView txtObs) {
    this.rootView = rootView;
    this.txtObs = txtObs;
  }

  @Override
  @NonNull
  public TextView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemobsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemobsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.itemobs, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemobsBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    TextView txtObs = (TextView) rootView;

    return new ItemobsBinding((TextView) rootView, txtObs);
  }
}
