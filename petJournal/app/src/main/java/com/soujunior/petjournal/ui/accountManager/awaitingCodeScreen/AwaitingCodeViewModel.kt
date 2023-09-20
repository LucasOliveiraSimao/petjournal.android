package com.soujunior.petjournal.ui.accountManager.awaitingCodeScreen

import androidx.lifecycle.ViewModel
import com.soujunior.petjournal.ui.ValidationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class AwaitingCodeViewModel : ViewModel() {
    abstract val state: StateFlow<AwaitingCodeFormState>
    abstract val buttonIsEnable: StateFlow<Boolean>
    abstract val validationEventChannel: Channel<ValidationEvent>
    open val validationEvents: Flow<ValidationEvent>
        get() = validationEventChannel.receiveAsFlow()

    abstract val message: StateFlow<String>

    abstract fun postOtpVerification()
    abstract fun failed(exception: Throwable?)
    abstract fun success(resultPostAwaitingCode: String)
    abstract fun onEvent(event: AwaitingCodeFormEvent)
    abstract fun enableButton(): Boolean
}