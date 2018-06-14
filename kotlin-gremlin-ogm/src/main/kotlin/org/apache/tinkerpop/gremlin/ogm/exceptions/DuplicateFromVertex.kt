package org.apache.tinkerpop.gremlin.ogm.exceptions

import kotlin.reflect.KClass

internal class DuplicateFromVertex(
        kClass: KClass<*>,
        name1: String?,
        name2: String?,
        annotationType: AnnotationType
) : AnnotationException(
        description = "Only one $annotationType may be annotated with @FromVertex. " +
                "${annotationType.name.capitalize()}: $name1, $name2. Class: $kClass."
)