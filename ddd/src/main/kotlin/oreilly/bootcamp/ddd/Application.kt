package oreilly.bootcamp.ddd

import oreilly.bootcamp.ddd.domain.Amount
import oreilly.bootcamp.ddd.domain.Cart
import oreilly.bootcamp.ddd.domain.Currency
import oreilly.bootcamp.ddd.domain.Item
import oreilly.bootcamp.ddd.domain.Price
import oreilly.bootcamp.ddd.domain.Product
import oreilly.bootcamp.ddd.domain.service.CompetitorBasedPricer
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DddApplication

fun main(args: Array<String>) {
    val competitorBasedPricer = CompetitorBasedPricer()
    val cart: Cart =
        Cart()
            .add(
                itemToAdd = Item(
                    product = Product(
                        name = "Apple pencil",
                        price = competitorBasedPricer.discountedPrice(
                            productName = "Apple pencil",
                            fallbackPrice = Price(
                                amount = Amount(120.toBigDecimal()),
                                currency = Currency.USD
                            )
                        )

                    ),
                    quantity = 1,
                )
            )
            .add(
                itemToAdd = Item(
                    product = Product(
                        name = "Rubber",
                        price = competitorBasedPricer.discountedPrice(
                            productName = "Rubber",
                            fallbackPrice = Price(
                                amount = Amount(5.50.toBigDecimal()),
                                currency = Currency.USD
                            )
                        )
                    ),
                    quantity = 10,
                )
            )

    println("Item in the cart: ${cart.items}")
    println("Removed products: ${cart.removedProducts().map { it.productName }}")
}
