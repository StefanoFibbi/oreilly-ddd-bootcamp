package oreilly.bootcamp.ddd.domain

data class Cart(
    val items: Collection<Item> = emptyList()
) {
    fun add(itemToAdd: Item) = this.copy(items = items + itemToAdd)

    fun removeAllProduct(product: Product) = this.copy(
        items = this.items.filterNot { it.product == product }
    )
}