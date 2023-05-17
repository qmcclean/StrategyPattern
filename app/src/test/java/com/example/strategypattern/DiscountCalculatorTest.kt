package com.example.strategypattern

import io.kotest.matchers.shouldBe
import org.junit.Test

class DiscountCalculatorTest {

    @Test
    fun `Applying percentage off discount`() {
        val calculator = DiscountCalculator(100.0)
        calculator.setDiscountStrategy(PercentageOffStrategy())
        calculator.applyDiscount(20.0)
        calculator.getFinalPrice() shouldBe 80.0
    }

    @Test
    fun `Applying dollar amount off discount`() {
        val calculator = DiscountCalculator(100.0)
        calculator.setDiscountStrategy(DollarAmountOffStrategy())
        calculator.applyDiscount(10.0)
        calculator.getFinalPrice() shouldBe 90.0
    }

    @Test
    fun `Applying new price discount`() {
        val calculator = DiscountCalculator(100.0)
        calculator.setDiscountStrategy(NewPriceStrategy())
        calculator.applyDiscount(50.0)
        calculator.getFinalPrice() shouldBe 50.0
    }

    @Test
    fun `Resetting the discount`() {
        val calculator = DiscountCalculator(100.0)
        calculator.setDiscountStrategy(PercentageOffStrategy())
        calculator.applyDiscount(20.0)
        calculator.resetDiscount()
        calculator.getFinalPrice() shouldBe 100.0
    }

    @Test
    fun `Not applying discount when strategy is not set`() {
        val calculator = DiscountCalculator(100.0)
        calculator.applyDiscount(20.0)
        calculator.getFinalPrice() shouldBe 100.0
    }

    @Test
    fun `Apply multiple discounts`() {
        val calculator = DiscountCalculator(100.0)
        calculator.setDiscountStrategy(PercentageOffStrategy())
        calculator.applyDiscount(20.0)
        calculator.getFinalPrice() shouldBe 80.0
        calculator.setDiscountStrategy(DollarAmountOffStrategy())
        calculator.applyDiscount(5.0)
        calculator.getFinalPrice() shouldBe 75.0
        calculator.setDiscountStrategy(NewPriceStrategy())
        calculator.applyDiscount(5.0)
        calculator.getFinalPrice() shouldBe 5.0
    }

    @Test
    fun `Testing stacking multiple discounts`() {
        val calculator = DiscountCalculator(100.0)

        calculator.setDiscountStrategy(DollarAmountOffStrategy())
        calculator.applyDiscount(5.0)
        calculator.getFinalPrice() shouldBe 95.0
        calculator.setDiscountStrategy(PercentageOffStrategy())
        calculator.applyDiscount(20.0)
        calculator.getFinalPrice() shouldBe 76.0
    }
}