package com.hardsoftstudio.rxflux.store;


public interface RxStoresRegister {
  /**
   * RxFlux method to let the view create the stores that need for this activity, this method is
   * called every time the activity is created. Normally you will instantiate the store with the
   * singleton instance.
   */
  void onRxStoresRegister();

  void onRxStoresUnRegister();
}
