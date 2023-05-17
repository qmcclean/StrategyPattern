package com.example.strategypattern

class DiscountCalculator(private var basePrice: Double) {
    private var originalPrice: Double = basePrice
    private var discountStrategy: DiscountStrategy? = null

    fun setDiscountStrategy(strategy: DiscountStrategy) {
        discountStrategy = strategy
    }

    fun applyDiscount(discountAmount: Double) {
        discountStrategy?.let { strategy ->
            basePrice.let { price ->
                basePrice = strategy.calculateDiscount(price, discountAmount)
            }
        } ?: run {
            println("Please set a discount strategy first.")
        }
    }

    fun resetDiscount() {
        basePrice = originalPrice
    }

    fun getFinalPrice(): Double {
        return basePrice
    }
}