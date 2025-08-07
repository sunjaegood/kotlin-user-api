package com.example.kotlin_mission.service

import UserRequest
import com.example.kotlin_mission.dto.UserResponse

import com.example.kotlin_mission.entity.User
import com.example.kotlin_mission.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService{
    override fun createUser(request: UserRequest): Long {
        val user = userRepository.save(User(name = request.name))
        return user.id
    }

    override fun getUser(id: Long): UserResponse {
        val user = userRepository.findById(id).orElseThrow{ ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")}
        return UserResponse(user.id, user.name)
    }

    override fun getAll(): List<UserResponse> {
        return userRepository.findAll().map { UserResponse(it.id, it.name) }
    }

}