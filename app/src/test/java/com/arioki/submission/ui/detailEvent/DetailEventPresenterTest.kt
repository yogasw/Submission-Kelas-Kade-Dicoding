/*
 * *
 *   Created by Yoga Setiawan on 11/15/19 4:03 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 4:03 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailEvent

import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.db.SportDBHelper
import com.arioki.submission.repository.DetailEventCallback
import com.arioki.submission.repository.TheSportsDBRepository
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
class DetailEventPresenterTest {
    private lateinit var presenter: DetailEventPresenter
    @Mock
    private lateinit var view: DetailEventView
    @Mock
    private lateinit var theSportsDBRepository: TheSportsDBRepository

    @Mock
    private lateinit var databse: SportDBHelper
    @Mock
    private var detailEventItem: List<DetailEventItem> = mutableListOf()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailEventPresenter(view, 123, theSportsDBRepository, databse)
    }

    @Test
    fun getDataSuccessFromApi() {
        presenter.getDataFromApi()
        argumentCaptor<DetailEventCallback>().apply {
            verify(theSportsDBRepository).detailEvent(eq(123), capture())
            firstValue.onSuccess(detailEventItem)
        }
        verify(view).hiddenShimmer()
        verify(view).finishLoadData(detailEventItem[0])

    }

    @Test
    fun getDataFailedFromApi() {
        presenter.getDataFromApi()
        argumentCaptor<DetailEventCallback>().apply {
            verify(theSportsDBRepository).detailEvent(eq(123), capture())
            firstValue.onError()
        }
        verify(view).hiddenShimmer()
    }
}