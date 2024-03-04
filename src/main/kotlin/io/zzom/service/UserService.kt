package io.zzom.service

import io.zzom.entity.Habit
import io.zzom.entity.User
import io.zzom.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val habitService: HabitService) {

    @Transactional
    fun signUp(user: User): User {
        // TODO: 이미 회원인지 확인
        return userRepository.save(user)
    }

    fun getUserInfo(userId: Long): User {
        return userRepository.findById(userId).orElseThrow()
    }

    fun getAllHabits(userId: Long): List<Habit> {
        return this.habitService.getAllByUserId(userId)
    }
}
