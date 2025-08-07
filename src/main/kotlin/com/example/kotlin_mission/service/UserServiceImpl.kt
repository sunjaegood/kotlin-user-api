package com.example.kotlin_mission.service

import UserRequest

import com.example.kotlin_mission.entity.User
import com.example.kotlin_mission.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService{
    override fun createUser(request: UserRequest): Long {
        val user = userRepository.save(User(name = request.name))
        return user.id
    }

}