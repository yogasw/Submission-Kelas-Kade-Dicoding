/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 10:26 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 10:02 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.searchEvent

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
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)

class SearchEventPresenterTest {
    private lateinit var presenter: SearchEventPresenter
    @Mock
    lateinit var view: SearchEventView
    @Mock
    lateinit var repository: TheSportsDBRepository
    @Mock
    private var eventItem: List<EventItem> = mutableListOf()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = SearchEventPresenter(view, repository)
    }

    @Test
    fun searchEventSuccess() {
        val text = "Real Madrid"
        `when`(view.getTextSearch()).thenReturn(text)
        presenter.searchData()
        argumentCaptor<TheSportsDBRepositoryCallback>().apply {
            verify(repository).searchEvent(eq(text), capture())
            firstValue.onSuccess(eventItem)
        }
        verify(view).finishSearchMatch(eventItem)
        verify(view).hiddenSimmer()
    }

    @Test
    fun searchEventFailedOrEmpty() {
        val text = ""
        `when`(view.getTextSearch()).thenReturn(text)
        presenter.searchData()
        argumentCaptor<TheSportsDBRepositoryCallback>().apply {
            verify(repository).searchEvent(eq(text), capture())
            firstValue.onError()
        }
        verify(view).dataEmpty()
    }
}