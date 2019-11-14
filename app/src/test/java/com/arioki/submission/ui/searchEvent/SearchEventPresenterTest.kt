/*
 * *
 *   Created by Yoga Setiawan on 11/14/19 11:12 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/14/19 11:12 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.searchEvent

import com.arioki.submission.repository.TheSportsDBRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)

class SearchEventPresenterTest {
    lateinit var presenter: SearchEventPresenter
    @Mock
    lateinit var view: SearchEventView
    @Mock
    lateinit var repository: TheSportsDBRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = SearchEventPresenter(view, repository)
    }

    @Test
    fun searchData() {
        val dummytextSearch = "madrid"

        runBlocking {
            `when`(view.getTextSearch()).thenReturn(dummytextSearch)
            verify(view).hiddenSimmer()
        }
    }

}