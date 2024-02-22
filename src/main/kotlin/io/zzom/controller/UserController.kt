package io.zzom.controller

import io.zzom.controller.dto.SignUpRequest
import io.zzom.entity.User
import io.zzom.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @PostMapping
    fun signUp(@RequestBody request: SignUpRequest): User {
        return this.userService.signUp(User.of(request))
    }

}