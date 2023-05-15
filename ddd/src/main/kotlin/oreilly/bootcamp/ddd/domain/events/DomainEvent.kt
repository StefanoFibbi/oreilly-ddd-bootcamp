package oreilly.bootcamp.ddd.domain.events

import oreilly.bootcamp.ddd.domain.Item
import oreilly.bootcamp.ddd.domain.Product

sealed class DomainEvent {
    data class ItemAddedToCartEvent(val productName: String, val quantity: Int) : DomainEvent() {
        companion object {
            fun from(item: Item) = ItemAddedToCartEvent(
                productName = item.product.name,
                quantity = item.quantity
            )
        }
    }

    data class ProductRemovedToCartEvent(val productName: String) : DomainEvent() {
        companion object {
            fun from(product: Product) = ProductRemovedToCartEvent(
                productName = product.name
            )
        }
    }
}
