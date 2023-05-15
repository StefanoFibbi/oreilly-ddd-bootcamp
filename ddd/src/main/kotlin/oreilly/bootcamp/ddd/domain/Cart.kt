package oreilly.bootcamp.ddd.domain

import java.util.UUID
import oreilly.bootcamp.ddd.domain.common.DomainModelEntity
import oreilly.bootcamp.ddd.domain.common.EntityId
import oreilly.bootcamp.ddd.domain.events.DomainEvent

@JvmInline
value class CartId(val value: UUID) : EntityId

fun UUID.toCartId() = CartId(this)

sealed class BaseCart : DomainModelEntity() {
    data class Cart(
        override val id: CartId = UUID.randomUUID().toCartId(),
        val items: Collection<Item> = emptyList(),
        val events: Collection<DomainEvent> = emptyList()
    ) : BaseCart() {
        fun add(itemToAdd: Item) = this.copy(
            items = items + itemToAdd,
            events = events + DomainEvent.ItemAddedToCartEvent.from(itemToAdd)
        )

        fun checkout() = CheckedOutCart(
            id = id,
            items = items,
            events = events
        )

        fun removeAllProduct(product: Product) = this.copy(
            items = items.filterNot { it.product == product },
            events = events + DomainEvent.ProductRemovedToCartEvent.from(product)
        )

        fun removedProducts() = events.filterIsInstance<DomainEvent.ProductRemovedToCartEvent>()
    }

    data class CheckedOutCart(
        override val id: CartId = UUID.randomUUID().toCartId(),
        val items: Collection<Item> = emptyList(),
        val events: Collection<DomainEvent> = emptyList()
    ) : BaseCart()
}