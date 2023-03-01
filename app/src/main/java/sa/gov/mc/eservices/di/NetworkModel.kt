package sa.gov.mc.eservices.di

import com.google.android.gms.common.api.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.Timeout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

import sa.gov.mc.eservices.Constants
import sa.gov.mc.eservices.Instance
import sa.gov.mc.eservices.data.CaptchaRemoteDataSource
import sa.gov.mc.eservices.data.CheckOtpRemoteDataSource

import sa.gov.mc.eservices.network.AccountService
import sa.gov.mc.eservices.rawan.AuthApiService
import sa.gov.mc.eservices.repository.CaptchaRepository
import sa.gov.mc.eservices.repository.CheckOtpRepository
import sa.gov.mc.eservices.repository.LoginRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject


import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModel {


@Provides
@Singleton
fun provideHttpClient():OkHttpClient {
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    return  OkHttpClient.Builder()
        .addInterceptor(interceptor).readTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20,TimeUnit.SECONDS)
        .build()
}

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.Base_Url).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAccountService(retrofit: Retrofit): AccountService{
        return retrofit.create(AccountService::class.java)
    }


    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideCaptchaRemoteDataSource(accountService: AccountService) =
        CaptchaRemoteDataSource(accountService, provideDispatcher())


    @Provides
    fun provideCaptchaRepository(accountService: AccountService): CaptchaRepository =
        CaptchaRepository(provideCaptchaRemoteDataSource(accountService))




    @Provides
    fun provideLoginRepository(accountService: AccountService): LoginRepository =
        LoginRepository(accountService)


    @Provides
    fun provideCheckOtpRemoteDataSource(accountApiService: AccountService) =
        CheckOtpRemoteDataSource(accountApiService, provideDispatcher())


    @Provides
    @Singleton
    fun provideCheckOtoRepository(accountApiService: AccountService): CheckOtpRepository =
        CheckOtpRepository(provideCheckOtpRemoteDataSource(accountApiService))



    //**********************************************************************************************
    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

}


