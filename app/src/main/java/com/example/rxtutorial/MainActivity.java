package com.example.rxtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.rxtutorial.viewModels.MainViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

import io.reactivex.Observer;


import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    CompositeDisposable disposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    /*    Observable<Tasks> tasksObservable = Observable
                .fromIterable(DataSource.createDataSource())
                .subscribeOn(Schedulers.io())
                .filter(new Predicate<Tasks>() {
                    @Override
                    public boolean test(Tasks tasks) throws Exception {
                        Log.d(TAG, "test: " + Thread.currentThread().getName());
                        Thread.sleep(3000);
                        return tasks.isComplete;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());

        tasksObservable.subscribe(new Observer<Tasks>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");

                disposable.add(d);
            }

            @Override
            public void onNext(Tasks tasks) {
                Log.d(TAG, "onNext: " + Thread.currentThread().getName());
                Log.d(TAG, "onNext: " + tasks.getDescription());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage() );
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: called ");
            }
        });*/

        /*Observable<DownloadableObject> downloadableObservable = Observable
                .just(DataSource.startDownload())
                .subscribeOn(Schedulers.io())
                .filter(new Predicate<DownloadableObject>() {
                    @Override
                    public boolean test(DownloadableObject downloadableObject) throws Exception {
                        downloadableObject.downloadData();
                        return true;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());


        downloadableObservable.subscribe(new Observer<DownloadableObject>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable.add(d);
            }

            @Override
            public void onNext(DownloadableObject downloadableObject) {
                Log.d(TAG, "onNext: " + downloadableObject.downloadedString);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: called");
            }
        });*/

    /*    Observable<DownloadableObject> downloadableObjectObservable = Observable
                .create(new ObservableOnSubscribe<DownloadableObject>() {
                    @Override
                    public void subscribe(ObservableEmitter<DownloadableObject> emitter) throws Exception {
                        if(!emitter.isDisposed()){
                            emitter.onNext(new DownloadableObject());
                            emitter.onComplete();
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .filter(new Predicate<DownloadableObject>() {
                    @Override
                    public boolean test(DownloadableObject downloadableObject) throws Exception {
                        downloadableObject.downloadData();
                        return true;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());

        downloadableObjectObservable.subscribe(new Observer<DownloadableObject>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(DownloadableObject downloadableObject) {
                Log.d(TAG, "onNext: " + downloadableObject.downloadedString);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/

    /*Observable<Tasks> taskCreateObservable = Observable
            .create(new ObservableOnSubscribe<Tasks>() {
                @Override
                public void subscribe(ObservableEmitter<Tasks> emitter) throws Exception {
                    for(Tasks tasks : DataSource.createDataSource()){
                        if(!emitter.isDisposed()){
                            emitter.onNext(tasks);
                        }
                    }
                    if(!emitter.isDisposed()){
                        emitter.onComplete();
                    }
                }
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());

    taskCreateObservable.subscribe(new Observer<Tasks>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(Tasks tasks) {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    });*/

    /* Observable<String> stringObservable = Observable
            .just(DataSource.startDownload())
            .subscribeOn(Schedulers.io())
            .map(new Function<DownloadableObject, String>() {
                @Override
                public String apply(DownloadableObject downloadableObject) throws Exception {
                    downloadableObject.downloadData();
                    return downloadableObject.downloadedString;
                }
            })
            .observeOn(AndroidSchedulers.mainThread());

        stringObservable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
*/

       /* Observable<Integer> longObservable = Observable
                .range(0, 9)
                .subscribeOn(Schedulers.io())
                .takeWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return true;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());

        longObservable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/

       Observable<Tasks> observable = Observable
               .fromIterable(DataSource.createDataSource())
               .subscribeOn(Schedulers.io())
               .takeWhile(new Predicate<Tasks>() {
                   @Override
                   public boolean test(Tasks tasks) throws Exception {
                       return tasks.isComplete();
                   }
               })
               .observeOn(AndroidSchedulers.mainThread());

       observable.subscribe(new Observer<Tasks>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(Tasks tasks) {
               Log.d(TAG, "onNext: " + tasks.getDescription());
           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onComplete() {

           }
       });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
