/*
 * *
 *   Created by Yoga Setiawan on 11/15/19 9:03 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 9:02 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailLiga

import com.arioki.submission.data.LeaguesItem
import com.arioki.submission.repository.DetailLigaRepositoryCallback
import com.arioki.submission.repository.TheSportsDBRepository
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailLigaPresenterTest {
    private lateinit var presenter: DetailLigaPresenter
    @Mock
    private lateinit var view: DetailLigaView
    @Mock
    private lateinit var theSportsDBRepository: TheSportsDBRepository
    @Mock
    private lateinit var leaguesItem: LeaguesItem

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailLigaPresenter(view, 123, theSportsDBRepository)
    }

    @Test
    fun getDetailLigaSuccess() {
        presenter.getDetailLiga()
        argumentCaptor<DetailLigaRepositoryCallback>().apply {
            verify(theSportsDBRepository).leaguesLookup(eq(123), capture())
            firstValue.onSuccess(leaguesItem)
        }
        verify(view).startShimmer()
        verify(view).getDetaiLigaDone(leaguesItem)

    }

    @Test
    fun getDetailLigaFailed() {
        presenter.getDetailLiga()
        argumentCaptor<DetailLigaRepositoryCallback>().apply {
            verify(theSportsDBRepository).leaguesLookup(eq(123), capture())
            firstValue.onError()
        }
        verify(view).startShimmer()
        verify(view).getDetailLigaFailed()

    }
}