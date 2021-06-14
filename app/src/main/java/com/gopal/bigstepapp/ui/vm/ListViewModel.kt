package com.gopal.bigstepapp.ui.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.gopal.bigstepapp.data.entities.Results
import com.gopal.bigstepapp.data.repository.CharacterRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    fun savelistToLocal(items: Results) {
        GlobalScope.launch {
            repository.saveListToLocal(items)
        }
    }

    val listFrmApi = repository.getListFrmApi()

    val listFrmLocal = repository.getListFrmLocal()

}
