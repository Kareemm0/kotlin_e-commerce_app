package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kotline_commerceapplication.Core.Utils.AppColors

@Composable
fun CustomTextFormFiled(

    value: String,
    onValueChange: (String) -> Unit,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = 1,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .background(AppColors.transparent),
    isError: Boolean = false,
    supportingText: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        shape = RoundedCornerShape(24),
        colors = OutlinedTextFieldDefaults.colors(
            errorTextColor = AppColors.red,
            errorBorderColor = AppColors.red

        ),
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier,
        suffix = suffix,
        prefix = prefix,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        maxLines = maxLines,
        label = label,
        placeholder = placeholder,
        isError = isError,
        supportingText = supportingText
    )
}