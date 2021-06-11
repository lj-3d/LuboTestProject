package com.lubo.data.di

import com.lubo.base.auth.AuthNetSource
import com.lubo.mapper.impl.AuthMapper
import com.lubo.impl.network.auth.AuthNetSourceImpl
import com.lubo.mapper.impl.TokenMapper
import com.lubo.data.repository.AuthRepositoryImpl
import com.lubo.data.repository.OnboardingRepositoryImpl
import com.lubo.repository.AuthRepository
import com.lubo.repository.OnboardingRepository
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