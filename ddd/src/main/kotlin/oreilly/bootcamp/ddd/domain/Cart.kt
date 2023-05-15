package oreilly.bootcamp.ddd.domain

class Cart(
    private val items: Collection<Item> = emptyList()
) {

    fun add(itemToAdd: Item) = Cart(items + itemToAdd)

    fun removeAllProduct(product: Product) = Cart(
        items = this.items.filterNot { it.product == product }
    )

    fun get() = items
}