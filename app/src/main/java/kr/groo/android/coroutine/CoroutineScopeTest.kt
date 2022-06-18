package kr.groo.android.coroutine

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

/**
 * 코루틴 스코프 테스트
 *
 * @author groo
 * @since 2022/06/18
 */
private const val TAG = "COROUTINE_SCOPE_TEST"

/**
 * Application 생명주기 (Job 관리 X)
 */
@DelicateCoroutinesApi
fun globalScopeTest() {
    GlobalScope.launch {
        Log.d(TAG, "globalScopeTest")
    }
}

/**
 * Activity 생명주기 (Job 관리 X)
 */
fun AppCompatActivity.lifecycleScopeTest() {
    lifecycleScope.launch {
        Log.d(TAG, "lifecycleScopeTest")
    }
}

/**
 * ViewModel 생명주기 (Job 관리 X)
 */
fun ViewModel.viewModelScopeTest() {
    viewModelScope.launch {
        Log.d(TAG, "viewModelScopeTest")
    }
}

/**
 * 복잡한 연산, CPU 고도화 (Job 관리 O)
 */
fun defaultDispatcherTest() {
    CoroutineScope(Dispatchers.Default).launch {
        Log.d(TAG, "defaultDispatcherTest")
    }
}

/**
 * 네트워크, DB 입출력 (Job 관리 O)
 */
fun ioDispatcherTest() {
    CoroutineScope(Dispatchers.IO).launch {
        Log.d(TAG, "ioDispatcherTest")
    }
}

/**
 * UI 상호작용 (Job 관리 O)
 */
fun mainDispatcherTest() {
    CoroutineScope(Dispatchers.Main).launch {
        Log.d(TAG, "mainDispatcherTest")
    }
}

/**
 * 상황에 따라 Scope 수시로 전환 (Job 관리 O)
 */
fun unconfinedDispatcherTest() {
    CoroutineScope(Dispatchers.Unconfined).launch {
        Log.d(TAG, "unconfinedDispatcherTest")
    }
}
