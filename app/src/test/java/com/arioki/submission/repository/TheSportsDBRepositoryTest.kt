/*
 * *
 *   Created by Yoga Setiawan on 11/14/19 12:20 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/14/19 12:20 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.repository

import com.arioki.submission.remote.TheSportsDBApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TheSportsDBRepositoryTest {
    @Mock
    lateinit var theSportsDBApi: TheSportsDBApi.Api
    lateinit var theSportsDBRepository: TheSportsDBRepository
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        theSportsDBRepository = TheSportsDBRepository(theSportsDBApi)
    }

    @Test
    fun searchEvent() {
        theSportsDBRepository.searchEvent("madrid", {
            it
        }, {
            it
        })
        Mockito.verify(theSportsDBRepository).searchEvent("madrid", {
            it
        }, {
            it
        })
    }
}