package core.consumer;

import core.provider.MovementListener;

/**
 * MovementConsumer accepts MovementListener to consume those set of operations
 */
public interface MovementConsumer {

    /**
     * sets movement manager to which this rover talks to determine next move.
     * pass null to unset.
     * throws runtime exception if not implemented and tried to be used.
     *
     * @param movementProvider
     */
    void setMovementProvider(MovementListener movementProvider);

}