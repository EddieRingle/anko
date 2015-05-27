/*
 * Copyright 2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.anko

import android.app.Activity
import android.app.ProgressDialog
import android.app.Service
import android.support.v4.app.Fragment
import android.view.View
import android.widget.LinearLayout
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import android.content.Intent
import android.os.Build
import android.support.v7.widget.AppCompatEditText
import android.support.v7.widget.AppCompatSpinner
import android.view.ViewManager
import android.widget.EditText
import android.widget.Spinner
import org.jetbrains.anko.custom.addView
import org.jetbrains.anko.internals.AnkoInternals

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.tintedEditText(): EditText = tintedEditText({})
public inline fun ViewManager.tintedEditText(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: EditText.() -> Unit): EditText = addView { ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) AppCompatEditText(ctx) else EditText(ctx)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.tintedSpinner(): Spinner = tintedSpinner({})
public inline fun ViewManager.tintedSpinner(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: Spinner.() -> Unit): Spinner = addView { ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) AppCompatSpinner(ctx) else Spinner(ctx)
    view.init()
    view
}

