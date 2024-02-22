package io.zzom.entity

import io.zzom.controller.dto.SignUpRequest
import jakarta.persistence.*

@Entity
@Table(name = "`user`")
class User(name: String) {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(nullable = false)
    var name: String = name

    companion object {
        fun of(request: SignUpRequest): User {
            return User(request.name)
        }
    }
}