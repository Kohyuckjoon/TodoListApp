package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.ContentEntity
import com.example.myapplication.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel() {
    //doneEvent 입력 완료 시, Input activity를 닫기 위해서 뷰모델 -> 엑티비티로 신호를 주는 역할을 합니다.
    private val _doneEvent = MutableLiveData<Unit>()
    val doneEvent : LiveData<Unit> = _doneEvent

    val content = MutableLiveData<String>()
    var memo = MutableLiveData<String?>()
    var item : ContentEntity? = null

    fun initData(item:ContentEntity) {
        this.item = item
        content.value = item.content
        memo.value = item.memo
    }

    fun insertData() {
        content.value?.let { content ->
            viewModelScope.launch(Dispatchers.IO){
                contentRepository.insert(
                    item?.copy(
                        content = content,
                        memo = memo.value
                    )?: ContentEntity(content = content, memo = memo.value)
                )
                _doneEvent.postValue(Unit)
            }
        }
    }
}