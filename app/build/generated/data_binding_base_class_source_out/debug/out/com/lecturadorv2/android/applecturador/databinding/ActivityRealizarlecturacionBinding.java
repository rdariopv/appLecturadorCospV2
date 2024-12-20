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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lecturadorv2.android.applecturador.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRealizarlecturacionBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnCalc;

  @NonNull
  public final Button btnSendLecturacion;

  @NonNull
  public final EditText etLectura;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final Spinner spObs;

  @NonNull
  public final Switch swNmed;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView tvAlert;

  @NonNull
  public final TextView tvCodF;

  @NonNull
  public final TextView tvConP;

  @NonNull
  public final TextView tvDCodf;

  @NonNull
  public final TextView tvDataConsumo;

  @NonNull
  public final TextView tvDescCodigo;

  @NonNull
  public final TextView tvImCodSocio;

  @NonNull
  public final TextView tvNombreS;

  @NonNull
  public final TextView tvNume;

  @NonNull
  public final TextView tvTConsumo;

  private ActivityRealizarlecturacionBinding(@NonNull RelativeLayout rootView,
      @NonNull Button btnCalc, @NonNull Button btnSendLecturacion, @NonNull EditText etLectura,
      @NonNull FloatingActionButton fab, @NonNull Spinner spObs, @NonNull Switch swNmed,
      @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5,
      @NonNull TextView textView6, @NonNull TextView tvAlert, @NonNull TextView tvCodF,
      @NonNull TextView tvConP, @NonNull TextView tvDCodf, @NonNull TextView tvDataConsumo,
      @NonNull TextView tvDescCodigo, @NonNull TextView tvImCodSocio, @NonNull TextView tvNombreS,
      @NonNull TextView tvNume, @NonNull TextView tvTConsumo) {
    this.rootView = rootView;
    this.btnCalc = btnCalc;
    this.btnSendLecturacion = btnSendLecturacion;
    this.etLectura = etLectura;
    this.fab = fab;
    this.spObs = spObs;
    this.swNmed = swNmed;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.tvAlert = tvAlert;
    this.tvCodF = tvCodF;
    this.tvConP = tvConP;
    this.tvDCodf = tvDCodf;
    this.tvDataConsumo = tvDataConsumo;
    this.tvDescCodigo = tvDescCodigo;
    this.tvImCodSocio = tvImCodSocio;
    this.tvNombreS = tvNombreS;
    this.tvNume = tvNume;
    this.tvTConsumo = tvTConsumo;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRealizarlecturacionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRealizarlecturacionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_realizarlecturacion, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRealizarlecturacionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCalc;
      Button btnCalc = ViewBindings.findChildViewById(rootView, id);
      if (btnCalc == null) {
        break missingId;
      }

      id = R.id.btnSendLecturacion;
      Button btnSendLecturacion = ViewBindings.findChildViewById(rootView, id);
      if (btnSendLecturacion == null) {
        break missingId;
      }

      id = R.id.etLectura;
      EditText etLectura = ViewBindings.findChildViewById(rootView, id);
      if (etLectura == null) {
        break missingId;
      }

      id = R.id.fab;
      FloatingActionButton fab = ViewBindings.findChildViewById(rootView, id);
      if (fab == null) {
        break missingId;
      }

      id = R.id.spObs;
      Spinner spObs = ViewBindings.findChildViewById(rootView, id);
      if (spObs == null) {
        break missingId;
      }

      id = R.id.swNmed;
      Switch swNmed = ViewBindings.findChildViewById(rootView, id);
      if (swNmed == null) {
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

      id = R.id.tvAlert;
      TextView tvAlert = ViewBindings.findChildViewById(rootView, id);
      if (tvAlert == null) {
        break missingId;
      }

      id = R.id.tvCodF;
      TextView tvCodF = ViewBindings.findChildViewById(rootView, id);
      if (tvCodF == null) {
        break missingId;
      }

      id = R.id.tvConP;
      TextView tvConP = ViewBindings.findChildViewById(rootView, id);
      if (tvConP == null) {
        break missingId;
      }

      id = R.id.tvDCodf;
      TextView tvDCodf = ViewBindings.findChildViewById(rootView, id);
      if (tvDCodf == null) {
        break missingId;
      }

      id = R.id.tvDataConsumo;
      TextView tvDataConsumo = ViewBindings.findChildViewById(rootView, id);
      if (tvDataConsumo == null) {
        break missingId;
      }

      id = R.id.tvDescCodigo;
      TextView tvDescCodigo = ViewBindings.findChildViewById(rootView, id);
      if (tvDescCodigo == null) {
        break missingId;
      }

      id = R.id.tvImCodSocio;
      TextView tvImCodSocio = ViewBindings.findChildViewById(rootView, id);
      if (tvImCodSocio == null) {
        break missingId;
      }

      id = R.id.tvNombreS;
      TextView tvNombreS = ViewBindings.findChildViewById(rootView, id);
      if (tvNombreS == null) {
        break missingId;
      }

      id = R.id.tvNume;
      TextView tvNume = ViewBindings.findChildViewById(rootView, id);
      if (tvNume == null) {
        break missingId;
      }

      id = R.id.tvTConsumo;
      TextView tvTConsumo = ViewBindings.findChildViewById(rootView, id);
      if (tvTConsumo == null) {
        break missingId;
      }

      return new ActivityRealizarlecturacionBinding((RelativeLayout) rootView, btnCalc,
          btnSendLecturacion, etLectura, fab, spObs, swNmed, textView3, textView4, textView5,
          textView6, tvAlert, tvCodF, tvConP, tvDCodf, tvDataConsumo, tvDescCodigo, tvImCodSocio,
          tvNombreS, tvNume, tvTConsumo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
