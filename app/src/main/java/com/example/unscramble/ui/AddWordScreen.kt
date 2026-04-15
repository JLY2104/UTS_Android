package com.example.unscramble.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWordScreen(
    onNavigateBack: () -> Unit,
    onSaveWord: (String) -> Unit
) {
    var wordInput by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tambah Kata Baru") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = wordInput,
                onValueChange = { wordInput = it },
                label = { Text("Masukkan kata") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(onClick = onNavigateBack) {
                    Text("Batal")
                }

                Button(
                    onClick = {
                        onSaveWord(wordInput)
                        wordInput = "" // Kosongkan setelah disimpan
                        onNavigateBack() // Kembali ke layar sebelumnya
                    },
                    enabled = wordInput.isNotBlank() // Tombol mati jika input kosong
                ) {
                    Text("Simpan Kata")
                }
            }
        }
    }
}