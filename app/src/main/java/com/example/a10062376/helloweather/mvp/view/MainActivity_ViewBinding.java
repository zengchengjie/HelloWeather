// Generated code from Butter Knife. Do not modify!
package com.example.a10062376.helloweather.mvp.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.a10062376.helloweather.R;
import com.example.a10062376.helloweather.mvp.view.MainActivity;

import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165219;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.buttonClick, "field 'clickMe' and method 'onClick'");
    target.clickMe = Utils.castView(view, R.id.buttonClick, "field 'clickMe'", Button.class);
    view2131165219 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.showResult = Utils.findRequiredViewAsType(source, R.id.showResult, "field 'showResult'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.clickMe = null;
    target.showResult = null;

    view2131165219.setOnClickListener(null);
    view2131165219 = null;
  }
}
