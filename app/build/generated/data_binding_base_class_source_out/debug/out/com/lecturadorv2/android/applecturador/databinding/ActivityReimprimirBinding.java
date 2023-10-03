// Generated by view binder compiler. Do not edit!
package com.lecturadorv2.android.applecturador.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.lecturadorv2.android.applecturador.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityReimprimirBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnCancelar;

  @NonNull
  public final Button btnSendPrint;

  @NonNull
  public final EditText etLecturaP;

  @NonNull
  public final Spinner spObsP;

  @NonNull
  public final Switch swNmedP;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView tvDescCodigoP;

  @NonNull
  public final TextView tvDescPeriodoP;

  @NonNull
  public final TextView tvImCodSocioP;

  @NonNull
  public final TextView tvNombreSP;

  @NonNull
  public final TextView tvNumeP;

  private ActivityReimprimirBinding(@NonNull RelativeLayout rootView, @NonNull Button btnCancelar,
      @NonNull Button btnSendPrint, @NonNull EditText etLecturaP, @NonNull Spinner spObsP,
      @NonNull Switch swNmedP, @NonNull TextView textView3, @NonNull TextView textView4,
      @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView tvDescCodigoP,
      @NonNull TextView tvDescPeriodoP, @NonNull TextView tvImCodSocioP,
      @NonNull TextView tvNombreSP, @NonNull TextView tvNumeP) {
    this.rootView = rootView;
    this.btnCancelar = btnCancelar;
    this.btnSendPrint = btnSendPrint;
    this.etLecturaP = etLecturaP;
    this.spObsP = spObsP;
    this.swNmedP = swNmedP;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.tvDescCodigoP = tvDescCodigoP;
    this.tvDescPeriodoP = tvDescPeriodoP;
    this.tvImCodSocioP = tvImCodSocioP;
    this.tvNombreSP = tvNombreSP;
    this.tvNumeP = tvNumeP;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityReimprimirBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityReimprimirBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_reimprimir, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityReimprimirBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCancelar;
      Button btnCancelar = ViewBindings.findChildViewById(rootView, id);
      if (btnCancelar == null) {
        break missingId;
      }

      id = R.id.btnSendPrint;
      Button btnSendPrint = ViewBindings.findChildViewById(rootView, id);
      if (btnSendPrint == null) {
        break missingId;
      }

      id = R.id.etLecturaP;
      EditText etLecturaP = ViewBindings.findChildViewById(rootView, id);
      if (etLecturaP == null) {
        break missingId;
      }

      id = R.id.spObsP;
      Spinner spObsP = ViewBindings.findChildViewById(rootView, id);
      if (spObsP == null) {
        break missingId;
      }

      id = R.id.swNmedP;
      Switch swNmedP = ViewBindings.findChildViewById(rootView, id);
      if (swNmedP == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.tvDescCodigoP;
      TextView tvDescCodigoP = ViewBindings.findChildViewById(rootView, id);
      if (tvDescCodigoP == null) {
        break missingId;
      }

      id = R.id.tvDescPeriodoP;
      TextView tvDescPeriodoP = ViewBindings.findChildViewById(rootView, id);
      if (tvDescPeriodoP == null) {
        break missingId;
      }

      id = R.id.tvImCodSocioP;
      TextView tvImCodSocioP = ViewBindings.findChildViewById(rootView, id);
      if (tvImCodSocioP == null) {
        break missingId;
      }

      id = R.id.tvNombreSP;
      TextView tvNombreSP = ViewBindings.findChildViewById(rootView, id);
      if (tvNombreSP == null) {
        break missingId;
      }

      id = R.id.tvNumeP;
      TextView tvNumeP = ViewBindings.findChildViewById(rootView, id);
      if (tvNumeP == null) {
        break missingId;
      }

      return new ActivityReimprimirBinding((RelativeLayout) rootView, btnCancelar, btnSendPrint,
          etLecturaP, spObsP, swNmedP, textView3, textView4, textView5, textView6, tvDescCodigoP,
          tvDescPeriodoP, tvImCodSocioP, tvNombreSP, tvNumeP);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
