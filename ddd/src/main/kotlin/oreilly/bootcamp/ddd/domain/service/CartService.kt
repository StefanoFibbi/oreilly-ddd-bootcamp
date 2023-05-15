package oreilly.bootcamp.ddd.domain.service

import oreilly.bootcamp.ddd.domain.BaseCart.Cart
import oreilly.bootcamp.ddd.domain.BaseCart.CheckedOutCart
import oreilly.bootcamp.ddd.domain.Item
import oreilly.bootcamp.ddd.domain.Order

class CartService {
    fun checkoutCart(cart: Cart): Pair<CheckedOutCart, Order> =
        Pair(
            cart.checkout(),
            checkoutCart(
                remainingItems = cart.items,
                currentOrder = Order(
                    products = emptyList()
                )
            )
        )

    private fun checkoutCart(remainingItems: Collection<Item>, currentOrder: Order): Order =
        if (remainingItems.isEmpty()) currentOrder
        else checkoutCart(
            remainingItems = remainingItems - remainingItems.first(),
            currentOrder = currentOrder.addAll(
                productsToAdd = List(remainingItems.first().quantity) { remainingItems.first().product }
            )
        )
}
