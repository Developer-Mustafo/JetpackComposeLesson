package uz.coder.jetpackcomposelesson

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class MyViewModel(private val application: Application):AndroidViewModel(application) {
    val db = MyDatabase(application)
    fun add(string: String){
        db.add(string)
    }
    fun getList() = db.allList()
}