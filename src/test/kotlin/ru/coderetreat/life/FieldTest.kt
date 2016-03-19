package ru.coderetreat.life

import org.hamcrest.Matchers.*
import org.jetbrains.spek.api.Spek
import org.junit.Assert.assertThat

/**
 * @author vladimir
 */
class FieldTest : Spek() {init{
    given("game field") {
        on("invoke method toString") {
            val field = Field(arrayOf(
                    booleanArrayOf(false, true),
                    booleanArrayOf(true, false)
            ))
            val expected = "\n *\n* \n"
            it("should return $expected") {
                val result = field.toString()
                assertThat(result, equalTo(expected))
            }
        }

        on("invoke method clone()") {
            val field = Field(arrayOf(
                    booleanArrayOf(false, true),
                    booleanArrayOf(true, false)
            ))
            it("should return deep copy of $field") {
                val result = field.clone()
                assertThat(result, not(sameInstance(field)))
                assertThat(result, equalTo(field))
            }
        }

        on("invoke method next()") {
            val field = Field(arrayOf(
                    booleanArrayOf(false, true, false),
                    booleanArrayOf(false, true, false),
                    booleanArrayOf(false, true, false)
            ))
            val expected = Field(arrayOf(
                    booleanArrayOf(false, false, false),
                    booleanArrayOf(true, true, true),
                    booleanArrayOf(false, false, false)
            ))
            it("should return $expected") {
                assertThat(field.next(), equalTo(expected))
            }
        }
    }
}}