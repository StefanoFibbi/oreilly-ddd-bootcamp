package oreilly.bootcamp.ddd

import oreilly.bootcamp.ddd.domain.Cart
import oreilly.bootcamp.ddd.domain.Item
import oreilly.bootcamp.ddd.domain.Product
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DddApplication

fun main(args: Array<String>) {

    val cart =
        Cart()
            .add(
                itemToAdd = Item(
                    product = Product(name = "Pen"),
                    quantity = 1,
                )
            )
            .add(
                itemToAdd = Item(
                    product = Product(name = "Rubber"),
                    quantity = 10,
                )
            )
            .add(
                itemToAdd = Item(
                    product = Product(name = "Apple pencil"),
                    quantity = 10,
                )
            )
            .removeAllProduct(
                Product(name = "Rubber")
            )

    println(cart.get())
}
