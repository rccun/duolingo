package com.example.duolingo.di

import com.example.duolingo.data.api.SupabaseApi
import com.example.duolingo.data.repository.AuthRepositoryImpl
import com.example.duolingo.data.utils.EmailValidatorImpl
import com.example.duolingo.domain.repository.AuthRepository
import com.example.duolingo.domain.usecase.Auth.SignUpUseCase
import com.example.duolingo.domain.usecase.Auth.ValidateConfirmPasswordUseCase
import com.example.duolingo.domain.usecase.Auth.ValidateEmailUseCase
import com.example.duolingo.domain.usecase.Auth.ValidatePasswordUseCase
import com.example.duolingo.domain.usecase.Auth.ValidateTermsUseCase
import com.example.duolingo.domain.usecase.Auth.ValidateUseCase
import com.example.duolingo.domain.utils.EmailValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthRepository(api: SupabaseApi): AuthRepository =
        AuthRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideValidateEmailUseCase(validator: EmailValidator) =
        ValidateEmailUseCase(validator)

    @Provides
    @Singleton
    fun provideValidatePasswordUseCase() =
        ValidatePasswordUseCase()

    @Provides
    @Singleton
    fun provideValidateConfirmPasswordUseCase() =
        ValidateConfirmPasswordUseCase()
    @Provides
    @Singleton
    fun provideValidateTermsUseCase() =
        ValidateTermsUseCase()

    @Provides
    @Singleton
    fun provideEmailValidator(): EmailValidator =
        EmailValidatorImpl()

    @Provides
    @Singleton
    fun provideSignUpUseCase(
        repo: AuthRepository,
    ) =
        SignUpUseCase(repo)


    @Provides
    @Singleton
    fun provideValidateUseCase (
        passwordValidation: ValidatePasswordUseCase,
        confirmPasswordUseCase: ValidateConfirmPasswordUseCase,
        termsUseCase: ValidateTermsUseCase
    ) =
        ValidateUseCase(passwordValidation, confirmPasswordUseCase, termsUseCase)

}