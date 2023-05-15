package oreilly.bootcamp.ddd.domain.common

abstract class DomainModelEntity {
    abstract val id: EntityId
    override fun equals(other: Any?): Boolean = other != null && other is DomainModelEntity && other.id == this.id
    override fun hashCode(): Int {
        return id.hashCode()
    }
}