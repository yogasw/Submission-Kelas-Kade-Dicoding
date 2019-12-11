/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 5:02 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.nextEvent

import com.arioki.submission.data.EventItem
import com.arioki.submission.repository.TheSportsDBRepository
import com.arioki.submission.repository.TheSportsDBRepositoryCallback
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NextEventPresenterTest {
    @Mock
    lateinit var view: NextEventView
    @Mock
    lateinit var repository: TheSportsDBRepository
    private var eventItem: List<EventItem> = mutableListOf()
    private lateinit var presenter: NextEventPresenter
    private var id = 123
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = NextEventPresenter(view, id, repository)
    }

    @Test
    fun getDataSuccess() {
        presenter.getData()
        argumentCaptor<TheSportsDBRepositoryCallback>().apply {
            verify(repository).nextEvent(eq(id), capture())
            firstValue.onSuccess(eventItem)
        }
        verify(view).hiddenSimmer()
        verify(view).getDataDone(eventItem)
    }

    @Test
    fun getDataFailed() {
        presenter.getData()
        argumentCaptor<TheSportsDBRepositoryCallback>().apply {
            verify(repository).nextEvent(eq(id), capture())
            firstValue.onError()
        }
        verify(view).hiddenSimmer()
    }
}