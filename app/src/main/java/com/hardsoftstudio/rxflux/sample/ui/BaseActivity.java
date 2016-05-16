package com.hardsoftstudio.rxflux.sample.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hardsoftstudio.rxflux.dispatcher.RxViewDispatch;
import com.hardsoftstudio.rxflux.sample.SampleApp;
import com.hardsoftstudio.rxflux.store.RxStoresRegister;

/**
 * Created by dallas on 16-5-16.
 */
public abstract class BaseActivity extends AppCompatActivity implements RxViewDispatch, RxStoresRegister {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    onRxStoresRegister();

    SampleApp.get(this).getRxFlux().getDispatcher().registerRxView(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
    SampleApp.get(this).getRxFlux().getDispatcher().registerRxView(this);
  }

  @Override
  protected void onStop() {
    super.onStop();
    SampleApp.get(this).getRxFlux().getDispatcher().unregisterRxView(this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    onRxStoresUnRegister();
  }
}
