package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Composable
fun LoginApp() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.LightGray),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            colors = CardDefaults.cardColors(containerColor =
            Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation =
            4.dp)
        ) {
            LoginScreens()
        }
    }
}

@Composable
fun LoginScreens() {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    if (showDialog) {
        DialogComponent(
            onConfirmation = { showDialog = false },
            dialogTitle = "Notification",
            dialogMessage = dialogMessage
        )
    }


    Column(
        modifier = Modifier.fillMaxWidth().padding(32.dp,24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        Image(
            painter =
            painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo"
        )
        Spacer(modifier = Modifier.height(20.dp))
// Username TextField
        OutlinedTextField( modifier = Modifier.fillMaxWidth(),
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
        )
        Spacer(modifier = Modifier.height(8.dp))
// Password TextField
        OutlinedTextField( modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))
        RememberMeSwitch()
        Spacer(modifier = Modifier.height(12.dp))
// Login Button
        Button(
            onClick = {
                if (username.isNotBlank() && password.isNotBlank()) {
                    dialogMessage = "Login successful"
                } else {
                    dialogMessage = "Please enter username and password"


                }
                showDialog=true
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White)) {
            Text("Login")
        }
    }

}

@Composable
fun DialogComponent(
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogMessage: String,
) {
    Dialog(onDismissRequest = {}) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier.padding(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(dialogTitle, style =
                MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(20.dp))
                Text(dialogMessage, style =
                MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = onConfirmation,

                    modifier = Modifier.align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.White
                    )
                ) {
                    Text("Okay")
                }
            }
        }
    }
}

@Composable
fun RememberMeSwitch() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Text("Remember Me?", modifier = Modifier.padding(start =
        12.dp))
    }
}

//Bai 2
@Composable
fun LightSwitch() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val isChecked = remember { mutableStateOf(false) }
        if (isChecked.value) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Light is On",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        } else {
            Image(
                painter = painterResource(id =
                R.drawable.ic_launcher_background),
                contentDescription = "Light is Off",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Switch(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Green,
                uncheckedThumbColor = Color.Gray,
                checkedTrackColor = Color.Green.copy(alpha = 0.5f),
                uncheckedTrackColor = Color.Gray.copy(alpha =
                0.5f),
                checkedBorderColor = Color.Green.copy(alpha =
                0.75f),
            )
        )
    }
}

//Bài 3



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryChips(
    categories: List<String>,
    selectedCategories: Set<String>,
    onCategorySelected: (String) -> Unit
) {
    Text("Choose categories:", style = MaterialTheme.typography.titleMedium)
    Spacer(modifier = Modifier.height(8.dp))
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        categories.forEach { category ->
            FilterChip(
                selected = selectedCategories.contains(category),
                onClick = { onCategorySelected(category) },
                label = { Text(category) },
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}

@Composable
fun SuggestionChips(
    suggestions: List<String>,
    selectedCategories: Set<String>,
    onSuggestionSelected: (String) -> Unit
) {
    Text("Suggestions:", style = MaterialTheme.typography.titleMedium)
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        suggestions.forEach { suggestion ->
            val isSelected = selectedCategories.contains(suggestion)
            val chipColors = if (isSelected) {
                SuggestionChipDefaults.suggestionChipColors(
                    containerColor = Color.LightGray
                )
            } else {
                SuggestionChipDefaults.suggestionChipColors()
            }
            SuggestionChip(
                onClick = { onSuggestionSelected(suggestion) },
                label = { Text(suggestion) },
                colors = chipColors,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedCategoriesChips(selectedCategories: Set<String>,
                            onCategoryRemoved: (String) -> Unit) {
    Text("Selected categories:", style =
    MaterialTheme.typography.titleMedium)
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        selectedCategories.forEach { selectedCategory ->
            InputChip(
                selected = true,
                onClick = { },
                label = { Text(selectedCategory) },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Deselect",
                        modifier = Modifier.clickable {
                            onCategoryRemoved(selectedCategory) }.size(18.dp)
                    )
                },
                modifier = Modifier.padding(end = 8.dp),
            )
        }
    }
}

@Composable
fun CategoryApp() {
    val categories = listOf("Fiction", "Mystery", "Science Fiction",
        "Fantasy", "Adventure", "Historical", "Horror", "Romance")
    val suggestions = listOf("Biography", "Cookbook", "Poetry", "Self-help",
        "Thriller")
    var selectedCategories by remember { mutableStateOf(setOf<String>()) }
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Choose a category:", style =
        MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        AssistChip(
            onClick = { /* Do something */ },
            label = { Text("Need help?") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CategoryChips(categories, selectedCategories, onCategorySelected = {
                category ->
            selectedCategories = if (selectedCategories.contains(category))
                selectedCategories - category
            else
                selectedCategories + category
        })
        Spacer(modifier = Modifier.height(16.dp))
        SuggestionChips(suggestions, selectedCategories,
            onSuggestionSelected = { suggestion ->
                selectedCategories = selectedCategories + suggestion
            })
        if (selectedCategories.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            SelectedCategoriesChips(selectedCategories, onCategoryRemoved =
            { category ->
                selectedCategories = selectedCategories - category
            })
            Spacer(modifier = Modifier.height(4.dp))
            AssistChip(
                onClick = { selectedCategories = setOf() },
                label = {
                    Text(
                        "Clear selections",

                        style = TextStyle(color = Color.White, fontWeight =

                        FontWeight.Bold)
                    )
                },
                colors = AssistChipDefaults.assistChipColors(containerColor
                = Color.DarkGray),
                border = AssistChipDefaults.assistChipBorder(borderColor =
                Color.Black)
            )
        }
    }
}