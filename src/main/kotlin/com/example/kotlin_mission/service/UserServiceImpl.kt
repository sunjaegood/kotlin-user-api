package com.example.kotlin_mission.service

import UserRequest
import com.example.kotlin_mission.dto.UserResponse

import com.example.kotlin_mission.entity.User
import com.example.kotlin_mission.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService{
    @Transactional
    override fun createUser(request: UserRequest): Long {
        val user = userRepository.save(User(name = request.name))
        return user.id
    }

    @Transactional(readOnly = true)
    override fun getUser(id: Long): UserResponse {
        val user=validateUser(id)
        return UserResponse(user.id, user.name)
    }

    @Transactional(readOnly = true)
    override fun getAll(): List<UserResponse> {
        return userRepository.findAll().map { UserResponse(it.id, it.name) }
    }

    @Transactional
    override fun updateUser(id: Long, request: UserRequest): UserResponse {
        val user=validateUser(id)
        user.name = request.name
        return UserResponse(user.id, user.name)

    }

    @Transactional
    override fun deleteUser(id: Long) {
        val user=validateUser(id)
        userRepository.deleteById(id)
    }

    fun validateUser(id : Long):User{
        return userRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found") }
    }
}