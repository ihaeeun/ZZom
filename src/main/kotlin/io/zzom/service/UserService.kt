package io.zzom.service

import io.zzom.entity.User
import io.zzom.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun signUp(user: User): User {
        return userRepository.save(user)
    }

}