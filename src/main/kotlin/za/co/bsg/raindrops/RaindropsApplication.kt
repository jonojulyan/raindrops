package za.co.bsg.raindrops

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RaindropsApplication

fun main(args: Array<String>) {
	runApplication<RaindropsApplication>(*args)
}
