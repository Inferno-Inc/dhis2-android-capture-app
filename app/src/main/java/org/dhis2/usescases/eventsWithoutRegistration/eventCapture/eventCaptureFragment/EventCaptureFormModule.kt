package org.dhis2.usescases.eventsWithoutRegistration.eventCapture.eventCaptureFragment

import dagger.Module
import dagger.Provides
import org.dhis2.commons.di.dagger.PerFragment
import org.dhis2.usescases.eventsWithoutRegistration.eventCapture.EventCaptureContract

@Module
class EventCaptureFormModule(
    val view: EventCaptureFormView,
    val eventUid: String
) {

    @Provides
    @PerFragment
    fun providePresenter(
        activityPresenter: EventCaptureContract.Presenter
    ): EventCaptureFormPresenter {
        return EventCaptureFormPresenter(
            activityPresenter
        )
    }
}
