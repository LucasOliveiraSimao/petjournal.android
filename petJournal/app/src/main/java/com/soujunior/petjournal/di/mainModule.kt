package com.soujunior.petjournal.di

import androidx.room.Room
import com.petjournal.database.database.db.AppDatabase
import com.petjournal.database.repository.GuardianLocalDataSourceImpl
import com.soujunior.data.remote.AuthService
import com.soujunior.data.remote.GuardianService
import com.soujunior.data.remote.adapters.internal.NetworkResultCallAdapterFactory
import com.soujunior.data.repository.AuthRepositoryImpl
import com.soujunior.data.repository.GuardianRepositoryImpl
import com.soujunior.domain.repository.AuthRepository
import com.soujunior.domain.repository.GuardianLocalDataSource
import com.soujunior.domain.repository.GuardianRepository
import com.soujunior.domain.repository.ValidationRepository
import com.soujunior.domain.use_case.auth.AwaitingCodeUseCase
import com.soujunior.domain.use_case.auth.ChangePasswordUseCase
import com.soujunior.domain.use_case.auth.CheckLoginStatusUseCase
import com.soujunior.domain.use_case.auth.ForgotPasswordUseCase
import com.soujunior.domain.use_case.auth.GetSavedPasswordUseCase
import com.soujunior.domain.use_case.auth.LoginUseCase
import com.soujunior.domain.use_case.auth.LogoutUseCase
import com.soujunior.domain.use_case.auth.SavePasswordUseCase
import com.soujunior.domain.use_case.auth.SignUpUseCase
import com.soujunior.domain.use_case.auth.util.ValidationRepositoryImpl
import com.soujunior.domain.use_case.guardian.GetGuardianNameUseCase
import com.soujunior.petjournal.ui.accountManager.awaitingCodeScreen.AwaitingCodeViewModel
import com.soujunior.petjournal.ui.accountManager.awaitingCodeScreen.AwaitingCodeViewModelImpl
import com.soujunior.petjournal.ui.accountManager.changePasswordScreen.ChangePasswordViewModel
import com.soujunior.petjournal.ui.accountManager.changePasswordScreen.ChangePasswordViewModelImpl
import com.soujunior.petjournal.ui.accountManager.forgotPasswordScreen.ForgotPasswordViewModel
import com.soujunior.petjournal.ui.accountManager.forgotPasswordScreen.ForgotPasswordViewModelImpl
import com.soujunior.petjournal.ui.accountManager.loginScreen.LoginViewModel
import com.soujunior.petjournal.ui.accountManager.loginScreen.LoginViewModelImpl
import com.soujunior.petjournal.ui.accountManager.registerScreen.RegisterViewModel
import com.soujunior.petjournal.ui.accountManager.registerScreen.RegisterViewModelImpl
import com.soujunior.petjournal.ui.appArea.detailScreen.DetailScreenViewModel
import com.soujunior.petjournal.ui.appArea.detailScreen.DetailScreenViewModelImpl
import com.soujunior.petjournal.ui.appArea.homeScreen.HomeScreenViewModel
import com.soujunior.petjournal.ui.appArea.homeScreen.HomeScreenViewModelImpl
import com.soujunior.petjournal.ui.appArea.registerPetScreen.RegisterPetViewModel
import com.soujunior.petjournal.ui.appArea.registerPetScreen.RegisterPetViewModelImpl
import com.soujunior.petjournal.ui.apresentation.splashScreen.SplashViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val mainModule = module {

    // Repositories
    single<ValidationRepository> { ValidationRepositoryImpl() }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    single<GuardianRepository> { GuardianRepositoryImpl(get(), get(), get()) }
    single<GuardianLocalDataSource> { GuardianLocalDataSourceImpl(get()) }

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
    single { get<AppDatabase>().guardianProfileDao() }

    // UseCases
    factory { SignUpUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { ForgotPasswordUseCase(get()) }
    factory { AwaitingCodeUseCase(get()) }
    factory { ChangePasswordUseCase(get()) }
    factory { CheckLoginStatusUseCase(get()) }
    factory { GetSavedPasswordUseCase(get()) }
    factory { SavePasswordUseCase(get()) }
    factory { GetGuardianNameUseCase(get()) }
    factory { LogoutUseCase(get()) }

    single<AuthService> { get<Retrofit>().create(AuthService::class.java) }
    single<GuardianService> { get<Retrofit>().create(GuardianService::class.java) }

    // Moshi Converter
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    // Retrofit Service
    single {
        Retrofit.Builder()
            .baseUrl("https://petjournal-api.onrender.com/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
            .build()
    }


    // ViewModels
    viewModel<HomeScreenViewModel> { HomeScreenViewModelImpl(get(), get()) }
    viewModel<DetailScreenViewModel> { DetailScreenViewModelImpl() }
    viewModel<RegisterPetViewModel> { RegisterPetViewModelImpl() }
    viewModel<LoginViewModel> { LoginViewModelImpl(get(), get(), get(), get()) }
    viewModel<RegisterViewModel> { RegisterViewModelImpl(get(), get()) }
    viewModel<AwaitingCodeViewModel> { AwaitingCodeViewModelImpl(get(), get(), get()) }
    viewModel<ForgotPasswordViewModel> { ForgotPasswordViewModelImpl(get(), get()) }
    viewModel<ChangePasswordViewModel> { ChangePasswordViewModelImpl(get(), get()) }
    viewModel { SplashViewModel(get()) }
}