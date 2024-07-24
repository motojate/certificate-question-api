package com.example.certificatequestionapi.question.domain.repository

import com.example.certificatequestionapi.question.domain.model.Question
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long>, CustomQuestionRepository, KotlinJdslJpqlExecutor