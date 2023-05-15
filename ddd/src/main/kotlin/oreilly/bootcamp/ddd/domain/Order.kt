package oreilly.bootcamp.ddd.domain

data class Order(
    val products: Collection<Product>
) {
    fun add(productToAdd: Product) = this.copy(
        products = products + productToAdd
    )

    fun addAll(productsToAdd: Collection<Product>) = this.copy(
        products = products + productsToAdd
    )
}
