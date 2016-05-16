package com.hardsoftstudio.rxflux.dispatcher;

import com.hardsoftstudio.rxflux.action.RxError;
import com.hardsoftstudio.rxflux.store.RxStoreChange;

/**
 * Created by marcel on 10/09/15.
 * All the activities must implement this interface in order to get notified by RxFlux when
 * events happen.
 */
public interface RxViewDispatch {

  /**
   * All the stores will call this event so the view can react and request the needed data
   */
  void onRxStoreChanged(RxStoreChange change);

  void onRxError(RxError error);


}
