package com.example.kotlin_mission.service

import UserRequest
import com.example.kotlin_mission.dto.UserResponse

interface UserService{
    fun createUser(request : UserRequest): Long
}