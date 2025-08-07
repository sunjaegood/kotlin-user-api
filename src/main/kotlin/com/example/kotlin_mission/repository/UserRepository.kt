package com.example.kotlin_mission.repository

import com.example.kotlin_mission.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>