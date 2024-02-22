package io.zzom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZZomApplication

fun main(args: Array<String>) {
	runApplication<ZZomApplication>(*args)
}
