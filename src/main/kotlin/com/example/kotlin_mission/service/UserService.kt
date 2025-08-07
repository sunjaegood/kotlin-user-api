package com.example.kotlin_mission.service

import UserRequest
import com.example.kotlin_mission.dto.UserResponse

interface UserService{
    fun createUser(request : UserRequest): Long
    fun getUser(id : Long): UserResponse
    fun getAll(): List<UserResponse>
    fun updateUser(id: Long, request: UserRequest): UserResponse
    fun deleteUser(id : Long)
}