/**
 * 
 */
package com.exelon.ee.event;

/**
 * @author ukaegbu
 *
 */
public enum EventType {
	userCreated,
	userModified,
	userPswdChanged,
	userPswdReset,
	userDeleted,
	userDisabled,
	trainerDeleted,
	trainerCreated,
	trainerModified,
	sessionAssigned,
	sessionNotHeld,
	sessionUnHeld,
	sessionAssessorAssigned,
	sessionAssessorAccepted,
	sessionAssessorRejected,
	sessionAccepted,
	sessionRejected,
	
	sessionClosed,
	partnerCreated,
	partnerUpdated,
	partnerSuspended,
	
}
