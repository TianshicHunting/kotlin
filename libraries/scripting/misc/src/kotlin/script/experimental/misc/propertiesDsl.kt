/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package kotlin.script.experimental.misc

import kotlin.reflect.KClass
import kotlin.script.experimental.api.TypedKey


inline operator fun <reified T> TypedKey<T>.invoke(v: T): Pair<TypedKey<T>, T> = this to v

inline operator fun <reified K> TypedKey<KClass<*>>.invoke(): Pair<TypedKey<KClass<*>>, KClass<*>> = this to K::class

inline operator fun <reified E> TypedKey<List<E>>.invoke(vararg vs: E): Pair<TypedKey<List<E>>, List<E>> = this to vs.toList()

@JvmName("invokeIterable")
inline operator fun <reified E> TypedKey<Iterable<E>>.invoke(vararg vs: E): Pair<TypedKey<Iterable<E>>, Iterable<E>> = this to vs.toList()

// TODO: make tests from examples below
/*
val x = with(kotlin.script.experimental.api.ScriptingEnvironmentProperties) {
    baseClass<String>()
}

val y = with(kotlin.script.experimental.api.ScriptCompileConfigurationParams) {
    importedPackages("a1", "a2")
}
*/