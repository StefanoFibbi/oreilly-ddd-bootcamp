package oreilly.bootcamp.ddd.domain

import java.math.BigDecimal

data class Price(val amount: Amount, val currency: Currency) {
    fun reducePriceByPercentage(percentage: BigDecimal): Price = this.copy(
        amount = Amount(amount.value - (amount.value * percentage) / 100.toBigDecimal())
    )
}

@JvmInline
value class Amount(val value: BigDecimal)

sealed class Currency(
    val name: String,
    val symbol: String,
) {
    object USD : Currency(name = "USD", symbol = "$")

    override fun toString(): String = name
}
