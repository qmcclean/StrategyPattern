package com.example.strategypattern

class DollarAmountOffStrategy : DiscountStrategy {
    override fun calculateDiscount(basePrice: Double, discountAmount: Double): Double {
        return basePrice - discountAmount
    }
}