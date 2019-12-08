/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:31 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/8/19 11:23 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.standingsEvent


import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.data.StandingsEventItem
import com.arioki.submission.ext.logger
import com.arioki.submission.ui.detailLiga.DetailLigaActivity
import kotlinx.android.synthetic.main.fragment_standings_event.*
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI


/**
 * A simple [Fragment] subclass.
 */
class StandingsEventFragment : Fragment(), StandingsEventView {
    private lateinit var mainView: View
    lateinit var presenter: StandingsEventPresenter
    lateinit var data: List<StandingsEventItem>

    companion object {
        const val ivLogo = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainView = inflater.inflate(R.layout.fragment_standings_event, container, false)
        return mainView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = StandingsEventPresenter(this, App.instances.repository)
        val activity = activity as DetailLigaActivity
        presenter.getData(activity.getId())

        if (::data.isInitialized) {
            data.forEach {
                it.name.logger("LOG123")
            }
        }
    }

    override fun getDataError(t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDataSuccess(it: List<StandingsEventItem>) {
        data = it
        setLayout(getUi())
    }

    private fun getUi(): View {
        return UI {
            scrollView {
                tableLayout {
                    padding = dip(16)
                    backgroundColor = Color.WHITE
                    orientation = LinearLayout.VERTICAL
                    tableRow {
                        padding = dip(5)
                        gravity = Gravity.CENTER
                        imageView {
                            id = R.id.imageView
                            contentDescription = resources.getString(R.string.logo_team)
                        }.lparams(width = dip(25), height = dip(25))
                        textView {
                            text = "Name"
                        }.lparams {
                            marginStart = dip(16)
                        }
                        textView {
                            text = "P"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            weight = 1f
                        }
                        textView {
                            text = "GA"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            weight = 1f
                        }
                        textView {
                            text = "D"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            weight = 1f
                        }
                        textView {
                            text = "GF"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            weight = 1f
                        }
                        textView {
                            text = "L"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            weight = 1f
                        }
                        textView {
                            text = "W"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            weight = 1f
                        }
                        textView {
                            text = "GD"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            weight = 1f
                        }
                        textView {
                            text = "Total"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            weight = 1f
                        }

                    }.lparams(width = matchParent, height = matchParent)
                    if (::data.isInitialized) {
                        var number = 0
                        data.forEach {
                            with(it) {
                                number += 1
                                tableRow {
                                    padding = dip(5)
                                    gravity = Gravity.CENTER
                                    imageView {
                                        id = ivLogo
                                        contentDescription = resources.getString(R.string.logo_team)
                                    }.lparams(width = dip(25), height = dip(25))
                                    textView {
                                        id = R.id.tv_name
                                        text = """$number. $name"""
                                    }.lparams {
                                        marginStart = dip(16)
                                    }
                                    textView {
                                        id = R.id.tv_played
                                        text = played.toString()
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    }.lparams {
                                        weight = 1f
                                    }
                                    textView {
                                        id = R.id.tv_goalsagainst
                                        text = goalsagainst.toString()
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    }.lparams {
                                        weight = 1f
                                    }
                                    textView {
                                        id = R.id.draw
                                        text = draw.toString()
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    }.lparams {
                                        weight = 1f
                                    }
                                    textView {
                                        id = R.id.tv_goalsfor
                                        text = goalsfor.toString()
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    }.lparams {
                                        weight = 1f
                                    }
                                    textView {
                                        id = R.id.loss
                                        text = loss.toString()
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    }.lparams {
                                        weight = 1f
                                    }
                                    textView {
                                        id = R.id.win
                                        text = win.toString()
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    }.lparams {
                                        weight = 1f
                                    }
                                    textView {
                                        id = R.id.tv_goalsdifference
                                        text = goalsdifference.toString()
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    }.lparams {
                                        weight = 1f
                                    }
                                    textView {
                                        id = R.id.total
                                        text = total.toString()
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    }.lparams {
                                        weight = 1f
                                    }

                                }.lparams(width = matchParent, height = matchParent)
                            }
                        }
                        relativeLayout {
                            textView {
                                id = R.id.tv_ket
                                text = "Keterangan : "
                            }
                            linearLayout {
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    text = "1. P: Player"
                                }
                                textView {
                                    text = "2. GA: Goals Against"
                                }
                                textView {
                                    text = "3. D: Draw"
                                }
                                textView {
                                    text = "4. GF: Goals For"
                                }
                                textView {
                                    text = "5. L: Loss"
                                }
                                textView {
                                    text = "6. W: Win"
                                }
                                textView {
                                    text = "7. GD: Goals Difference"
                                }
                                textView {
                                    text = "8. T: Total"
                                }
                            }.lparams(width = matchParent) {
                                below(R.id.tv_ket)
                            }
                        }.lparams(width = matchParent)
                    }
                }
            }
        }.view
    }

    private fun setLayout(view: View) {
        flMain.removeAllViews()
        flMain.addView(view)
    }
}
