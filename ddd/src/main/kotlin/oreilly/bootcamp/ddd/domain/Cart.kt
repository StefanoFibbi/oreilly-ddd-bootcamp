package oreilly.bootcamp.ddd.domain

class Cart(
    private val items: Collection<Item> = emptyList()
) {

    fun add(itemToAdd: Item) = Cart(items + itemToAdd)
    fun get() = items
}