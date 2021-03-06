package org.apache.tinkerpop.gremlin.ogm.steps.relationship.edgespec

import org.apache.tinkerpop.gremlin.ogm.elements.Vertex
import org.apache.tinkerpop.gremlin.ogm.steps.relationship.Relationship

/**
 * Creates a [Relationship] that is bi-directional. When traversed from a 'FROM' object,
 * there will be 0 or more 'TO' objects. When the [inverse] is traversed from a 'TO' object,
 * there will be 0 or more 'FROM' objects.
 */
data class ManyToManySymmetricEdgeSpec<TYPE : Vertex>(
        override val name: String
) : EdgeSpec.ManyToMany.Symmetric<TYPE>
