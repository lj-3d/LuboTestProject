package com.lubo.repository.di

import com.lubo.base.network.auth.AuthNetSource
import com.lubo.impl.network.auth.AuthMapper
import com.lubo.impl.network.auth.AuthNetSourceImpl
import com.lubo.impl.network.auth.TokenMapper
import com.lubo.repository.base.AuthRepository
import com.lubo.repository.base.OnboardingRepository
import com.lubo.repository.impl.AuthRepositoryImpl
import com.lubo.repository.impl.OnboardingRepositoryImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val repositoryModule = DI.Module("repository") {

    //mappers
    bind() from singleton { AuthMapper() }
    bind() from singleton { TokenMapper() }

    //sources
    bind<AuthNetSource>() with singleton { AuthNetSourceImpl() }

    //repos
    bind<OnboardingRepository>() with singleton { OnboardingRepositoryImpl(instance()) }
    bind<AuthRepository>() with singleton {
        AuthRepositoryImpl(
            instance(),
            instance(),
            instance()
        )
    }
}