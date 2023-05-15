package oreilly.bootcamp.ddd.domain

import oreilly.bootcamp.ddd.domain.events.DomainEvent

data class Cart(
    val items: Collection<Item> = emptyList(),
    val events: Collection<DomainEvent> = emptyList()
) {
    fun add(itemToAdd: Item) = this.copy(
        items = items + itemToAdd,
        events = events + DomainEvent.ItemAddedToCartEvent.from(itemToAdd)
    )

    fun removeAllProduct(product: Product) = this.copy(
        items = items.filterNot { it.product == product },
        events = events + DomainEvent.ProductRemovedToCartEvent.from(product)
    )

    fun removedProducts() = events.filterIsInstance<DomainEvent.ProductRemovedToCartEvent>()
}