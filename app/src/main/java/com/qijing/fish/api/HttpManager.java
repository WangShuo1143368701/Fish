package com.qijing.fish.api;


import com.qijing.fish.model.respone.BaseRespone;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
/**
 * Created by User on 2017/6/6.
 */

public class HttpManager {
    public static final String TAG = "HttpManager";
    /**
     *    有loading 的请求
     * @param baseView
     * @param observable
     * @param onResultListener
     * @param compositeDisposable
     */
    public void doHttpTaskWithDialog(final BaseView baseView, Observable observable,CompositeDisposable compositeDisposable, final OnResultListener onResultListener) {
        if (baseView != null) {
            baseView.showDialog();
        }
        DisposableObserver disposableObserver = new DisposableObserver() {
            @Override
            public void onNext( Object o) {
                LogUtils.e(TAG, "onNext ======" + o.toString());
                if (baseView != null) {
                    baseView.dismissDialog();
                    BaseRespone respone =  (BaseRespone) o;
                    if (respone != null && respone.isOk()) {
                        onResultListener.onSuccess(respone);
                    }else {
                        String msg;
                        if (respone == null) {
                            msg = "respone  == null";
                        }else {
                            msg = "r  = "+respone.ret;
                        }
                        onResultListener.onError(new Exception() , msg);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(TAG, "onError===" + e.toString());
                if (baseView != null) {
                    baseView.dismissDialog();
                    onResultListener.onError(e, "onError");
                }
            }

            @Override
            public void onComplete() {
                if (baseView != null) {
                    baseView.dismissDialog();
                }
                LogUtils.e(TAG, "onComplete()==");
            }
        };

        observable.retryWhen(new RetryWhenNetworkException())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .onErrorResumeNext(funcException)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver);
        compositeDisposable.add(disposableObserver);
    }

    /**
     *         无loading 的请求
     * @param baseView
     * @param observable
     * @param onResultListener
     * @param compositeDisposable
     */
    public static void  doHttpTask(final BaseView baseView, Observable observable, CompositeDisposable compositeDisposable, final OnResultListener onResultListener) {
        DisposableObserver disposableObserver = new DisposableObserver() {
            @Override
            public void onNext(Object o) {
                LogUtils.e(TAG, "onNext ======" + o.toString());
                if (baseView != null) {
                    BaseRespone respone =  (BaseRespone) o;
                    if (respone != null && respone.isOk()) {
                        onResultListener.onSuccess(respone);
                    }else {
                        String msg;
                        if (respone == null) {
                            msg = null;
                        }else {
                            msg = respone.ret;
                        }
                        onResultListener.onError(null, msg);
                    }
                }
            }
            @Override
            public void onError(Throwable e) {
                LogUtils.e(TAG, "onError===" + e.toString());
                if (baseView != null) {
                    onResultListener.onError(e, null);
                }
            }
            @Override
            public void onComplete() {
                if (baseView != null) {
                }
                LogUtils.e(TAG, "onComplete()==");
            }
        };
        observable.retryWhen(new RetryWhenNetworkException())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .onErrorResumeNext(funcException)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver);
        compositeDisposable.add(disposableObserver);
    }


    /**
     *
     * @param observable
     * @param onResultListener
     */
    public static void  doHttpTask(Observable observable, final OnResultListener onResultListener) {
        DisposableObserver disposableObserver = new DisposableObserver() {
            @Override
            public void onNext(Object o) {
                LogUtils.e(TAG, "onNext ======" + o.toString());
                    BaseRespone respone =  (BaseRespone) o;
                    if (respone != null && respone.isOk()) {
                        onResultListener.onSuccess(respone);
                    }else {
                        String msg;
                        if (respone == null) {
                            msg = "respone  == null";
                        }else {
                            msg = "r  = "+respone.ret;
                        }
                        onResultListener.onError(new Exception() , msg);
                    }
            }
            @Override
            public void onError(Throwable e) {
                LogUtils.e(TAG, "onError===" + e.toString());
                    onResultListener.onError(e, "onError");
            }
            @Override
            public void onComplete() {
                LogUtils.e(TAG, "onComplete()==");
            }
        };
        observable.retryWhen(new RetryWhenNetworkException())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .onErrorResumeNext(funcException)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver);
    }

    //接口回调
    public interface OnResultListener {
        void onSuccess(BaseRespone t);
        void onError(Throwable error, String msg);
    }

    /**
     * 异常处理
     */
    static Function funcException = new Function<Throwable, Observable>() {
        @Override
        public Observable apply(Throwable throwable) throws Exception {
            return Observable.error(FactoryException.analysisExcetpion(throwable));
        }
    };
}
