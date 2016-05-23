package com.hardsoftstudio.rxflux.sample.ui;

import android.app.Fragment;
import android.os.Bundle;
import com.hardsoftstudio.rxflux.dispatcher.RxViewDispatch;
import com.hardsoftstudio.rxflux.sample.SampleApp;
import com.hardsoftstudio.rxflux.store.RxStoresRegister;

/**
 * Created by dallas on 16-5-16.
 */
public abstract class BaseFragment extends Fragment implements RxViewDispatch, RxStoresRegister {
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    onRxStoresRegister();
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    SampleApp.get(getActivity()).getRxFlux().getDispatcher().unregisterRxView(this);
    SampleApp.get(getActivity()).getRxFlux().getDispatcher().registerRxView(this);
  }

  @Override public void onResume() {
    super.onResume();
    SampleApp.get(getActivity()).getRxFlux().getDispatcher().registerRxView(this);
  }

  @Override public void onStop() {
    super.onStop();
    SampleApp.get(getActivity()).getRxFlux().getDispatcher().unregisterRxView(this);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    onRxStoresUnRegister();
  }
}
