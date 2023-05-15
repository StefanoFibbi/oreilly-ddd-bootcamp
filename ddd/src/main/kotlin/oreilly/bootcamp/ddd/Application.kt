package oreilly.bootcamp.ddd

import oreilly.bootcamp.ddd.domain.Amount
import oreilly.bootcamp.ddd.domain.Cart
import oreilly.bootcamp.ddd.domain.Currency
import oreilly.bootcamp.ddd.domain.Item
import oreilly.bootcamp.ddd.domain.Price
import oreilly.bootcamp.ddd.domain.Product
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DddApplication

fun main(args: Array<String>) {

    val cart: Cart =
        Cart()
            .add(
                itemToAdd = Item(
                    product = Product(
                        name = "Pen",
                        price = Price(
                            amount = Amount(10.toBigDecimal()),
                            currency = Currency.USD
                        )
                    ),
                    quantity = 1,
                )
            )
            .add(
                itemToAdd = Item(
                    product = Product(
                        name = "Rubber",
                        price = Price(
                            amount = Amount(5.50.toBigDecimal()),
                            currency = Currency.USD
                        )
                    ),
                    quantity = 10,
                )
            )

    println("Item in the cart: ${cart.items}")
    println("Removed products: ${cart.removedProducts().map { it.productName }}")
}
