package com.example.certificatequestionapi.user.domain.repository

import com.example.certificatequestionapi.user.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>, CustomUserRepository