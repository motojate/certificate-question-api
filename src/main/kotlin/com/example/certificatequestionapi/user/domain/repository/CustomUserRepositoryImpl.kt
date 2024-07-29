package com.example.certificatequestionapi.user.domain.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor

class CustomUserRepositoryImpl(private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor) : CustomUserRepository {
}