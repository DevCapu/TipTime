package br.com.devcapu.tiptime

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performTextReplacement
import br.com.devcapu.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeScreen()
            }
        }
        composeTestRule.onNode(hasText("Bill amount")).performTextReplacement("10")
        composeTestRule.onNode(hasText("Tip (%)")).performTextReplacement("20")
        composeTestRule.onNode(hasText("Tip amount: $2.00")).assertExists()
    }
}