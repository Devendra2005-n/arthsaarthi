package com.arthsaarthi

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.arthsaarthi.presentation.expenses.AddTransactionScreen
import com.arthsaarthi.presentation.expenses.ExpenseListScreen
import com.arthsaarthi.presentation.goals.GoalsScreen
import com.arthsaarthi.presentation.home.HomeScreen
import com.arthsaarthi.presentation.investments.InvestmentsScreen
import com.arthsaarthi.presentation.onboarding.OnboardingScreen
import com.arthsaarthi.presentation.settings.SettingsScreen
import com.arthsaarthi.presentation.tax.TaxScreen

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Filled.Home)
    object Expenses : Screen("expenses", "Expenses", Icons.Filled.Receipt)
    object Investments : Screen("investments", "Invest", Icons.Filled.TrendingUp)
    object Tax : Screen("tax", "Tax", Icons.Filled.Calculate)
    object Goals : Screen("goals", "Goals", Icons.Filled.Flag)
}

val bottomNavItems = listOf(
    Screen.Home, Screen.Expenses, Screen.Investments, Screen.Tax, Screen.Goals
)

@Composable
fun ArthSaarthiNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "onboarding") {

        composable("onboarding") {
            OnboardingScreen(onOnboardingComplete = {
                navController.navigate("main") {
                    popUpTo("onboarding") { inclusive = true }
                }
            })
        }

        composable("main") {
            MainScreen(
                onAddTransaction = { navController.navigate("add_transaction") },
                onSettings = { navController.navigate("settings") }
            )
        }

        composable("add_transaction") {
            AddTransactionScreen(onBack = { navController.popBackStack() })
        }

        composable("settings") {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}

@Composable
fun MainScreen(onAddTransaction: () -> Unit, onSettings: () -> Unit) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { Text(screen.title) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            if (currentRoute == Screen.Home.route || currentRoute == Screen.Expenses.route) {
                FloatingActionButton(
                    onClick = onAddTransaction,
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add Transaction", tint = androidx.compose.ui.graphics.Color.White)
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) { HomeScreen(onAddTransaction = onAddTransaction, onSettings = onSettings) }
            composable(Screen.Expenses.route) { ExpenseListScreen() }
            composable(Screen.Investments.route) { InvestmentsScreen() }
            composable(Screen.Tax.route) { TaxScreen() }
            composable(Screen.Goals.route) { GoalsScreen() }
        }
    }
}
