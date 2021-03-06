package org.apache.tinkerpop.gremlin.ogm.steps.bound.single

import org.apache.tinkerpop.gremlin.ogm.steps.Step
import org.apache.tinkerpop.gremlin.ogm.steps.bound.BoundStep

/**
 * A [SingleBoundStep] composes a [Step] and a single [FROM] object to start the traversal from.
 */
interface SingleBoundStep<FROM, TO> : BoundStep<FROM, TO> {

    /**
     * The object to start the [SingleBoundStep]'s g with
     */
    val from: FROM

    override val froms: List<FROM> get() = listOf(from)

    override val step: Step<FROM, TO>

    /**
     * A [SingleBoundStep] that traverses to a optional or non-optional (aka single) object.
     */
    interface ToOne<FROM, TO> : SingleBoundStep<FROM, TO>, BoundStep.ToOne<FROM, TO> {

        override val step: Step.ToOne<FROM, TO>
    }

    /**
     * A [SingleBoundStep] that results to 0 or more 'TO' objects.
     */
    interface ToMany<FROM, TO> : SingleBoundStep<FROM, TO>, BoundStep.ToMany<FROM, TO> {

        override val step: Step.ToMany<FROM, TO>
    }

    /**
     * A [SingleBoundStep] that results to exactly 1 'TO' objects.
     */
    interface ToSingle<FROM, TO> : ToOne<FROM, TO>, BoundStep.ToSingle<FROM, TO> {

        override val step: Step.ToSingle<FROM, TO>
    }

    /**
     * A [SingleBoundStep] that results to 0 or 1 'TO' objects.
     */
    interface ToOptional<FROM, TO> : ToOne<FROM, TO>, BoundStep.ToOptional<FROM, TO> {

        override val step: Step.ToOptional<FROM, TO>
    }
}
