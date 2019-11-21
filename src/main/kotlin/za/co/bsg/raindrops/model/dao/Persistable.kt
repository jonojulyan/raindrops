package za.co.bsg.raindrops.model.dao

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class Persistable<T : Serializable> {

    companion object {
        private const val serialUID = -1729839812371273L
    }

    @Id
    @GeneratedValue
    private var id: T? = null

    fun getId(): T? {
        return id
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (javaClass != other?.javaClass) {
            return false
        }

        other as Persistable<*>

        if (id != other.id) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Entity of type ${this.javaClass.name} with id: $id"
    }
}