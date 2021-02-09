package com.lubo.repository.di

import com.lubo.base.network.auth.AuthNetSource
import com.lubo.impl.network.auth.AuthMapper
import com.lubo.impl.network.auth.AuthNetSourceImpl
import com.lubo.impl.network.auth.TokenMapper
import com.lubo.repository.base.AuthRepository
import com.lubo.repository.base.OnboardingRepository
import com.lubo.repository.impl.auth.AuthRepositoryImpl
import com.lubo.repository.impl.auth.OnboardingRepositoryImpl
import org.kodein.di.*

val repositoryModule = DI.Module("repository") {

    //mappers
    bind() from singleton { AuthMapper() }
    bind() from singleton { TokenMapper() }

    //sources
    bind<AuthNetSource>() with singleton { AuthNetSourceImpl() }

    //repos
    bind<OnboardingRepository>() with singleton { OnboardingRepositoryImpl() }
    bind<AuthRepository>() with singleton { AuthRepositoryImpl(instance(), instance(), instance()) }
}