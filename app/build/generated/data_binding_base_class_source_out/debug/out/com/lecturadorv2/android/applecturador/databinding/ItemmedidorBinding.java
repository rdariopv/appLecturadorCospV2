// Generated by view binder compiler. Do not edit!
package com.lecturadorv2.android.applecturador.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.lecturadorv2.android.applecturador.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemmedidorBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView tvCodf;

  @NonNull
  public final TextView tvImCodSocio;

  @NonNull
  public final TextView tvImNombreSocio;

  @NonNull
  public final TextView tvNtcn;

  private ItemmedidorBinding(@NonNull RelativeLayout rootView, @NonNull LinearLayout linearLayout2,
      @NonNull TextView textView7, @NonNull TextView tvCodf, @NonNull TextView tvImCodSocio,
      @NonNull TextView tvImNombreSocio, @NonNull TextView tvNtcn) {
    this.rootView = rootView;
    this.linearLayout2 = linearLayout2;
    this.textView7 = textView7;
    this.tvCodf = tvCodf;
    this.tvImCodSocio = tvImCodSocio;
    this.tvImNombreSocio = tvImNombreSocio;
    this.tvNtcn = tvNtcn;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemmedidorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemmedidorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.itemmedidor, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemmedidorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.tvCodf;
      TextView tvCodf = ViewBindings.findChildViewById(rootView, id);
      if (tvCodf == null) {
        break missingId;
      }

      id = R.id.tvImCodSocio;
      TextView tvImCodSocio = ViewBindings.findChildViewById(rootView, id);
      if (tvImCodSocio == null) {
        break missingId;
      }

      id = R.id.tvImNombreSocio;
      TextView tvImNombreSocio = ViewBindings.findChildViewById(rootView, id);
      if (tvImNombreSocio == null) {
        break missingId;
      }

      id = R.id.tvNtcn;
      TextView tvNtcn = ViewBindings.findChildViewById(rootView, id);
      if (tvNtcn == null) {
        break missingId;
      }

      return new ItemmedidorBinding((RelativeLayout) rootView, linearLayout2, textView7, tvCodf,
          tvImCodSocio, tvImNombreSocio, tvNtcn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
