package com.example.kotlin_mission.controller

import UserRequest
import com.example.kotlin_mission.dto.UserResponse
import com.example.kotlin_mission.service.UserService
import org.springframework.http.HttpStatus

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserContrlloer(private val userService: UserService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody request: UserRequest): Long = userService.createUser(request)

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): UserResponse = userService.getUser(id)

    @GetMapping
    fun getAll(): List<UserResponse> = userService.getAll()

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody request: UserRequest): UserResponse = userService.updateUser(id, request)
    
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUser(id)

}