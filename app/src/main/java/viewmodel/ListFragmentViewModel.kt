package viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dummylistingapp.model.Item
import com.example.dummylistingapp.network.ApiServiceInstance
import com.example.dummylistingapp.network.HTTPClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ListFragmentViewModel: ViewModel() {
    lateinit var itemList: MutableLiveData<Item>

    init {
        itemList = MutableLiveData()
    }

    fun getItemListObserver(): MutableLiveData<Item> {
        return itemList
    }

    fun makeApiCall(s: String){
        val retroInstance = ApiServiceInstance.getRetroInstance().create(HTTPClient::class.java)
        retroInstance.getItems("a354b7ee", s)
            // an Observable emits its data in the thread where the subscription was declared
            // subscribeOn with RxJava's Scheduler to create an alternative thread
            .subscribeOn(Schedulers.io())
            // observeOn with RxAndroid's AndroidSchedulers.mainThread to send the Observable's notifications to Android main UI thread,
            // ready to display the retrieved data in the app UI.
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getItemListObserverRx())
    }

    private fun getItemListObserverRx(): Observer<Item> {
        return object :Observer<Item>{
            override fun onSubscribe(d: Disposable) {
                // start showing progress indicator
            }

            override fun onNext(t: Item) {
                itemList.postValue(t)
            }

            override fun onError(e: Throwable) {
//                itemList.postValue(null)
                Log.i("sueshan", "Error found")
            }

            override fun onComplete() {
                // hide progress indicator
            }

        }
    }
}