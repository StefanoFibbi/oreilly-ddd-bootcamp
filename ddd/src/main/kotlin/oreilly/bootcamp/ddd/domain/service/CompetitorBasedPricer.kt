package oreilly.bootcamp.ddd.domain.service

import java.math.BigDecimal
import oreilly.bootcamp.ddd.domain.Amount
import oreilly.bootcamp.ddd.domain.Currency
import oreilly.bootcamp.ddd.domain.Price

typealias ProductName = String

class CompetitorBasedPricer() {
    private val competitorProducts: Map<ProductName, Price>

    init {
        competitorProducts = mapOf(
            "Apple pencil" to Price(amount = Amount(100.toBigDecimal()), currency = Currency.USD),
            "Air Pods Pro" to Price(amount = Amount(255.toBigDecimal()), currency = Currency.USD),
            "Air Pods Max" to Price(amount = Amount(500.toBigDecimal()), currency = Currency.USD),
        )
    }

    fun discountedPrice(productName: ProductName, fallbackPrice: Price) =
        competitorProducts[productName]
            ?.reducePriceByPercentage(discountPercentage)
            ?: fallbackPrice

    companion object {
        val discountPercentage: BigDecimal = 10.toBigDecimal();
    }
}